package aw.krauterkiste.exposure.controller;

import aw.krauterkiste.exposure.model.ExposureDataDto;
import aw.krauterkiste.exposure.service.ExposureService;
import aw.krauterkiste.exposure.model.ExposureStatusDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/led")
public class ExposureController {

    private final ExposureService exposureService;

    public ExposureController(ExposureService exposureService) {
        this.exposureService = exposureService;
    }

    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/toggle")
    @ResponseBody
    public ExposureStatusDto toggle() {
        return exposureService.toggle();
    }

    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/data")
    @ResponseBody
    public ExposureDataDto getData() {
        return exposureService.getData();
    }
}

