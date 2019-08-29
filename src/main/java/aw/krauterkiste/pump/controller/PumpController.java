package aw.krauterkiste.pump.controller;

import aw.krauterkiste.pump.model.PumpDataDto;
import aw.krauterkiste.pump.service.PumpService;
import aw.krauterkiste.pump.model.PumpStatusDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pump")
public class PumpController {

    private final PumpService pumpService;

    public PumpController(PumpService pumpService) {
        this.pumpService = pumpService;
    }

    @GetMapping("/toggle")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    public PumpStatusDto toggle() {
        return pumpService.toggle();
    }

    @GetMapping("/data")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    public PumpDataDto getData() {
        return pumpService.getData();
    }
}