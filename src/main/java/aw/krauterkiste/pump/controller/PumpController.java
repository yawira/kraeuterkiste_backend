package aw.krauterkiste.pump.controller;

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

    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/toggle")
    @ResponseBody
    public PumpStatusDto toggle() {
        return pumpService.toggle();
    }
}

// TODO neues Package für die Pumpe > COntroller, model, service