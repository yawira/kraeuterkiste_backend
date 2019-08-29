package aw.krauterkiste.pump.service;

import aw.krauterkiste.pump.model.Pump;
import aw.krauterkiste.pump.model.PumpData;
import aw.krauterkiste.pump.model.PumpDto;
import aw.krauterkiste.pump.repository.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PumpService {

    private final RestTemplate raspiRestTemplate;
    private final PumpRepository pumpRepository;

    @Autowired
    public PumpService(RestTemplate raspiRestTemplate,
                       PumpRepository pumpRepository) {
        this.raspiRestTemplate = raspiRestTemplate;
        this.pumpRepository = pumpRepository;
    }

    public PumpDto toggle() {
        PumpDto pumpDto = raspiRestTemplate
                .getForObject("/pump/toggle", PumpDto.class);

        Pump pump = new Pump();
        pump.setDateTime(pumpDto.getDateTime());
        pump.setActive(pumpDto.isActive());

        pumpRepository.save(pump);

        return pumpDto;
    }

    public List<PumpData> getData(){
        List<PumpData> data = new ArrayList<>();

        List<Pump> rawData = pumpRepository.findAllByOrderByDateTimeDesc();

        LocalDateTime start = null;
        LocalDateTime stop = null;

        for(Pump rawDataItem : rawData) {
            LocalDateTime dateTime = rawDataItem.getDateTime();

            if(rawDataItem.isActive()) {
                start = dateTime;
            } else {
                stop = dateTime;
            }

            if(start != null && stop != null && stop.isAfter(start)) {
                PumpData exposureData = new PumpData(start, stop);
                data.add(exposureData);
            }
        }

        return data;
    }
}