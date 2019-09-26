package aw.kraeuterkiste.pump.controller;

import aw.kraeuterkiste.pump.model.PumpData;
import aw.kraeuterkiste.pump.model.PumpDto;
import aw.kraeuterkiste.pump.service.PumpService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public PumpDto toggle() {
        return pumpService.toggle();
    }

    @GetMapping("/data")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    public List<PumpData> getData() {
        return pumpService.getData();
    }
}