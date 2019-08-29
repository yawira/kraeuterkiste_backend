package aw.krauterkiste.exposure.controller;

import aw.krauterkiste.exposure.model.ExposureDataDto;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import aw.krauterkiste.exposure.service.ExposureService;
import aw.krauterkiste.exposure.model.ExposureStatusDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/exposure")
public class ExposureController {

    private final ExposureService exposureService;

    public ExposureController(ExposureService exposureService) {
        this.exposureService = exposureService;
    }

    @GetMapping("/toggle")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ExposureStatusDto toggle() {
        return exposureService.toggle();
    }

    @GetMapping("/data")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public ExposureDataDto getData() {
        return exposureService.getData();
    }
}