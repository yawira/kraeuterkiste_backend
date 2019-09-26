package aw.kraeuterkiste.pump.service;

import aw.kraeuterkiste.pump.model.PumpData;
import aw.kraeuterkiste.pump.model.PumpDto;
import aw.kraeuterkiste.pump.repository.PumpRepository;
import aw.kraeuterkiste.pump.model.Pump;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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

    // Method toggles pump and saves start time as well as duration in database
    public PumpDto toggle() {
        PumpDto pumpDto = raspiRestTemplate
                .getForObject("/pump/toggle", PumpDto.class);

        Pump pump = new Pump();
        pump.setDateTime(pumpDto.getDateTime());
        pump.setActive(pumpDto.isActive());

        pumpRepository.save(pump);

        return pumpDto;
    }

    // Method necessary to show pump data in frontend chart
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
                data.add(new PumpData(start, ChronoUnit.SECONDS.between(start, stop)));
            }
        }

        return data;
    }
}