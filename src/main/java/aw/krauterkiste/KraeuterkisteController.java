package aw.krauterkiste;

import aw.krauterkiste.camera.repository.PicturesRepository;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import aw.krauterkiste.exposure.model.ExposureResponseBody;
import aw.krauterkiste.moisture.repository.MoistureRepository;
import aw.krauterkiste.moisture.model.MoistureResponseBody;
import aw.krauterkiste.plant.repository.PlantRepository;
import aw.krauterkiste.plant.model.PlantResponseBody;
import aw.krauterkiste.pump.model.PumpResponseBody;
import aw.krauterkiste.pump.repository.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KraeuterkisteController {

    private final MoistureRepository moistureRepository;
    private final ExposureRepository exposureRepository;
    private final PicturesRepository picturesRepository;
    private final PlantRepository plantRepository;
    private final PumpRepository pumpRepository;

    @Autowired
    public KraeuterkisteController(MoistureRepository moistureRepository, ExposureRepository exposureRepository, PicturesRepository picturesRepository, PlantRepository plantRepository, PumpRepository pumpRepository) {
        this.moistureRepository = moistureRepository;
        this.exposureRepository = exposureRepository;
        this.picturesRepository = picturesRepository;
        this.plantRepository = plantRepository;
        this.pumpRepository = pumpRepository;
    }

    // Daten aus der Datenbank holen

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/dataview/moisture")
    @ResponseBody
    public MoistureResponseBody showMoistureData() {
        MoistureResponseBody moistureResponseBody = new MoistureResponseBody();

        moistureResponseBody.setMoistureList(moistureRepository.findAllByOrderByMoistureDateTimeAsc());

        return moistureResponseBody;
    }

    @ResponseBody
    @RequestMapping(value = "/dataview/exposure", method = RequestMethod.GET)
    public ExposureResponseBody showExposureData() {

        ExposureResponseBody exposureResponseBody = new ExposureResponseBody();

        exposureResponseBody.setExposureList(exposureRepository.findAll());

        return exposureResponseBody;
    }



    @ResponseBody
    @RequestMapping(value = "/dataview/plant", method = RequestMethod.GET)
    public PlantResponseBody showPlantData() {

        PlantResponseBody plantResponseBody = new PlantResponseBody();

        plantResponseBody.setPlantList(plantRepository.findAll());

        return plantResponseBody;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @ResponseBody
    @GetMapping("/dataview/pump")
    public PumpResponseBody showPumpData() {

        PumpResponseBody pumpResponseBody = new PumpResponseBody();

        pumpResponseBody.setPumpList(pumpRepository.findAll());

        return pumpResponseBody;
    }

}