package aw.krauterkiste.exposure.controller;

import aw.krauterkiste.exposure.model.ExposureDataDto;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import aw.krauterkiste.exposure.service.ExposureService;
import aw.krauterkiste.exposure.model.ExposureStatusDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/led")
public class ExposureController {

    private final ExposureRepository exposureRepository;
    private final ExposureService exposureService;

    public ExposureController(ExposureService exposureService, ExposureRepository exposureRepository) {
        this.exposureRepository = exposureRepository;
        this.exposureService = exposureService;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @ResponseBody
    @GetMapping("/dataview/exposure")
    public ExposureDataDto showExposureData() {

        ExposureDataDto exposureDataDto = new ExposureDataDto();

        exposureDataDto.setExposureList(exposureRepository.findAll());

        return exposureDataDto;
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