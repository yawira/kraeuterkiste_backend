package aw.krauterkiste;

import aw.krauterkiste.camera.repository.PictureRepository;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import aw.krauterkiste.exposure.model.ExposureDto;
import aw.krauterkiste.moisture.repository.MoistureRepository;
import aw.krauterkiste.moisture.model.MoistureDto;
import aw.krauterkiste.plant.repository.PlantRepository;
import aw.krauterkiste.plant.model.PlantDto;
import aw.krauterkiste.pump.model.PumpDataDto;
import aw.krauterkiste.pump.repository.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KraeuterkisteController {

    private final MoistureRepository moistureRepository;
    private final ExposureRepository exposureRepository;
    private final PictureRepository pictureRepository;
    private final PlantRepository plantRepository;
    private final PumpRepository pumpRepository;

    @Autowired
    public KraeuterkisteController(MoistureRepository moistureRepository, ExposureRepository exposureRepository, PictureRepository pictureRepository, PlantRepository plantRepository, PumpRepository pumpRepository) {
        this.moistureRepository = moistureRepository;
        this.exposureRepository = exposureRepository;
        this.pictureRepository = pictureRepository;
        this.plantRepository = plantRepository;
        this.pumpRepository = pumpRepository;
    }

    // Daten aus der Datenbank holen

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/dataview/moisture")
    @ResponseBody
    public MoistureDto showMoistureData() {
        MoistureDto moistureDto = new MoistureDto();

        moistureDto.setMoistureList(moistureRepository.findAllByOrderByMoistureDateTimeAsc());

        return moistureDto;
    }

    @ResponseBody
    @RequestMapping(value = "/dataview/exposure", method = RequestMethod.GET)
    public ExposureDto showExposureData() {

        ExposureDto exposureDto = new ExposureDto();

        exposureDto.setExposureList(exposureRepository.findAll());

        return exposureDto;
    }



    @ResponseBody
    @RequestMapping(value = "/dataview/plant", method = RequestMethod.GET)
    public PlantDto showPlantData() {

        PlantDto plantDto = new PlantDto();

        plantDto.setPlantList(plantRepository.findAll());

        return plantDto;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @ResponseBody
    @GetMapping("/dataview/pump")
    public PumpDataDto showPumpData() {

        PumpDataDto pumpDataDto = new PumpDataDto();

        pumpDataDto.setPumpList(pumpRepository.findAll());

        return pumpDataDto;
    }

}