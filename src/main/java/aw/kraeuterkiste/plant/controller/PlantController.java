package aw.kraeuterkiste.plant.controller;

import aw.kraeuterkiste.plant.model.PlantDto;
import aw.kraeuterkiste.plant.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {
    // Not in use - for future purpose. Should enable you to save multiple plant boxes

    private final PlantRepository plantRepository;

    @Autowired
    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @ResponseBody
    @GetMapping("/data")
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public PlantDto showPlantData() {
        PlantDto plantDto = new PlantDto();

        plantDto.setPlantList(plantRepository.findAll());

        return plantDto;
    }
}
