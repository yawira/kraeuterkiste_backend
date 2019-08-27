package aw.krauterkiste.led.controller;

import aw.krauterkiste.led.service.LEDService;
import aw.krauterkiste.led.model.LEDStatusDto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/led")
public class LEDController {

    private final LEDService ledService;

    public LEDController(LEDService ledService) {
        this.ledService = ledService;
    }

    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/toggle")
    @ResponseBody
    public LEDStatusDto toggle() {
        return ledService.toggle();
    }
}

