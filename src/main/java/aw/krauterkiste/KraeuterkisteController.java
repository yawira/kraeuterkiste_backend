package aw.krauterkiste;

import aw.krauterkiste.camera.repository.PictureRepository;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import aw.krauterkiste.moisture.repository.MoistureRepository;
import aw.krauterkiste.plant.repository.PlantRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class KraeuterkisteController {

    @Autowired
    public KraeuterkisteController() {

    }

}