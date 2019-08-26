package aw.krauterkiste.LED;

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

    public void toggle() {
        raspiRestTemplate.getForObject("/test", Boolean.class);
    }
}
