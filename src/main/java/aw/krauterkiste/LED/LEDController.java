package aw.krauterkiste.LED;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/led")
public class LEDController {

    private final LEDService ledService;

    public LEDController(LEDService ledService) {
        this.ledService = ledService;
    }

    @CrossOrigin(value = "http://localhost:3000", allowCredentials = "true")
    @GetMapping("/toggle")
    public void toggle() {
        ledService.toggle();
    }
}
