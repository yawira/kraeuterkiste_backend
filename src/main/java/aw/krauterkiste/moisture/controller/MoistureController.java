package aw.krauterkiste.moisture.controller;

import aw.krauterkiste.moisture.model.Moisture;
import aw.krauterkiste.moisture.model.MoistureDto;
import aw.krauterkiste.moisture.repository.MoistureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@EnableScheduling
@RestController
@RequestMapping("/moisture")
public class MoistureController {

    private final RestTemplate raspiRestTemplate;
    private final MoistureRepository moistureRepository;

    @Autowired
    public MoistureController(MoistureRepository moistureRepository, RestTemplate raspiRestTemplate) {
        this.moistureRepository = moistureRepository;
        this.raspiRestTemplate = raspiRestTemplate;
    }

    @PostConstruct
    public void startMeasurements() {
        measureMoisture();
    }

    @Scheduled(fixedRate = 1000)
    @GetMapping(value = "/data")
    public void measureMoisture(){

        Moisture moistureData = new Moisture();

        MoistureDto moistureResponse = raspiRestTemplate.getForObject("/moisture/data", MoistureDto.class);

        moistureData.setMoisturePercentage(moistureResponse.getMoistureData());
        moistureData.setMoistureDateTime(LocalDateTime.now());

        if(moistureData.getMoisturePercentage() > -1) {

            moistureRepository.save(moistureData);
        }

    }
}