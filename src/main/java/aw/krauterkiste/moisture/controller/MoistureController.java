package aw.krauterkiste.moisture.controller;

import aw.krauterkiste.moisture.model.Moisture;
import aw.krauterkiste.moisture.model.MoistureDto;
import aw.krauterkiste.moisture.repository.MoistureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

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


    @PostMapping("/data")
    public void measureMoisture(@RequestBody MoistureDto moistureDto){
        Moisture moisture = new Moisture();
        moisture.setMoistureDateTime(LocalDateTime.now());
        moisture.setMoisturePercentage(moistureDto.getMoistureData());

        moistureRepository.save(moisture);
    }
}