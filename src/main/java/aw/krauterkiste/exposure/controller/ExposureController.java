package aw.krauterkiste.exposure.controller;

import aw.krauterkiste.exposure.model.ExposureData;
import aw.krauterkiste.exposure.service.ExposureService;
import aw.krauterkiste.exposure.model.ExposureDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ExposureDto toggle() {
        return exposureService.toggle();
    }

    @GetMapping("/data")
    @ResponseBody
    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    public List<ExposureData> getData() {
        return exposureService.getData();
    }
}