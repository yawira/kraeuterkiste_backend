package aw.krauterkiste.led.service;

import aw.krauterkiste.led.model.LEDDto;
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

    public LEDDto toggle() {
        return raspiRestTemplate.getForObject("/led/toggle", LEDDto.class);
    }
}
