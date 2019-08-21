package aw.krauterkiste.kraeuterkisteServer;

import aw.krauterkiste.kraeuterkisteServer.repositories.*;
import aw.krauterkiste.kraeuterkisteServer.responsebodies.*;
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

        moistureResponseBody.setMoistureList(moistureRepository.findAll());

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
    @RequestMapping(value = "/dataview/picture", method = RequestMethod.GET)
    public PicturesResponseBody showPictureData() {

        PicturesResponseBody picturesResponseBody = new PicturesResponseBody();

        picturesResponseBody.setPicturesList(picturesRepository.findAll());

        return picturesResponseBody;
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
    @RequestMapping(value = "/dataview/pump", method = RequestMethod.GET)
    public PumpResponseBody showPumpData() {

        PumpResponseBody pumpResponseBody = new PumpResponseBody();

        pumpResponseBody.setPumpList(pumpRepository.findAll());

        return pumpResponseBody;
    }
}