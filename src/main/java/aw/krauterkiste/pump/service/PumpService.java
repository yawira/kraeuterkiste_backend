package aw.krauterkiste.pump.service;

import aw.krauterkiste.pump.model.Pump;
import aw.krauterkiste.pump.model.PumpDataDto;
import aw.krauterkiste.pump.model.PumpStatusDto;
import aw.krauterkiste.pump.repository.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
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

    public PumpStatusDto toggle() {
        PumpStatusDto statusDto = raspiRestTemplate
                .getForObject("/pump/toggle", PumpStatusDto.class);

        if(statusDto.isOn()) {
            LocalDateTime start = LocalDateTime.now();
            Pump pump = new Pump();
            pump.setStart(start);
            pumpRepository.save(pump);
        } else {
            LocalDateTime end = LocalDateTime.now();
            Pump pump = pumpRepository.findTopByOrderByStartDesc();
            pump.setStop(end);
            pumpRepository.save(pump);
        }

        return statusDto;
    }

    public PumpDataDto getData(){
        List<Pump> data = pumpRepository.findAll();
        PumpDataDto dataDto = new PumpDataDto();
        dataDto.setPumpList(data);
        return dataDto;
    }
}