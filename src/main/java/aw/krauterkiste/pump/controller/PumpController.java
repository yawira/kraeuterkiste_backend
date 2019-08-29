package aw.krauterkiste.pump.controller;

import aw.krauterkiste.pump.model.PumpDataDto;
import aw.krauterkiste.pump.repository.PumpRepository;
import aw.krauterkiste.pump.service.PumpService;
import aw.krauterkiste.pump.model.PumpStatusDto;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/pump")
@EnableScheduling
public class PumpController {

    private final PumpRepository pumpRepository;
    private final PumpService pumpService;

    public PumpController(PumpService pumpService, PumpRepository pumpRepository) {
        this.pumpRepository = pumpRepository;
        this.pumpService = pumpService;
    }

    @CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
    @ResponseBody
    @GetMapping("/dataview/pump")
    public PumpDataDto showPumpData() {

        PumpDataDto pumpDataDto = new PumpDataDto();

        pumpDataDto.setPumpList(pumpRepository.findAll());

        return pumpDataDto;
    }

    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/toggle")
    @ResponseBody
    public PumpStatusDto toggle() {
        return pumpService.toggle();
    }


    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/data")
    @ResponseBody
    public PumpDataDto getData() {
        return pumpService.getData();
    }
}