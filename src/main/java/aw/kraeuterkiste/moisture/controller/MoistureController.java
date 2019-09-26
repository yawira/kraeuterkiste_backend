package aw.kraeuterkiste.moisture.controller;

import aw.kraeuterkiste.moisture.model.Moisture;
import aw.kraeuterkiste.moisture.repository.MoistureRepository;
import aw.kraeuterkiste.moisture.model.MoistureDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/data")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<MoistureDto> fetchMoistureData() {
        List<MoistureDto> data = new ArrayList<>();

        for(Moisture moisture : moistureRepository.findAllByOrderByDateTimeAsc()) {
            data.add(new MoistureDto(moisture.getDateTime(), moisture.getPercentage()));
        }

        return data;
    }

    @PostMapping("/data")
    public void saveMoistureData(@RequestBody MoistureDto moistureDto){
        Moisture moisture = new Moisture();

        moisture.setPercentage(moistureDto.getPercentage());
        moisture.setDateTime(moistureDto.getDateTime());

        moistureRepository.save(moisture);
    }
}