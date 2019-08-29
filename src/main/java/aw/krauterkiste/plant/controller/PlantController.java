package aw.krauterkiste.plant.controller;

import aw.krauterkiste.plant.model.PlantDto;
import aw.krauterkiste.plant.repository.PlantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlantController {

    private final PlantRepository plantRepository;

    @Autowired
    public PlantController(PlantRepository plantRepository) {
        this.plantRepository = plantRepository;
    }

    @ResponseBody
    @GetMapping("/dataview/plant")
    public PlantDto showPlantData() {

        PlantDto plantDto = new PlantDto();

        plantDto.setPlantList(plantRepository.findAll());

        return plantDto;
    }
}
