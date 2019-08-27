package aw.krauterkiste.led.service;

import aw.krauterkiste.led.model.LEDStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LEDService {

    private final RestTemplate raspiRestTemplate;

    @Autowired
    public LEDService(RestTemplate raspiRestTemplate) {
        this.raspiRestTemplate = raspiRestTemplate;
    }

    public LEDStatusDto toggle() {
        return raspiRestTemplate.getForObject("/led/toggle", LEDStatusDto.class);
    }
}
