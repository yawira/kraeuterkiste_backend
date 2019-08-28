package aw.krauterkiste.pump.controller;

import aw.krauterkiste.pump.model.PumpDataDto;
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

    private final PumpService pumpService;

    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
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