package aw.krauterkiste.pump.service;

import aw.krauterkiste.pump.model.PumpDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PumpService {

    private final RestTemplate raspiRestTemplate;

    @Autowired
    public PumpService(RestTemplate raspiRestTemplate) {
        this.raspiRestTemplate = raspiRestTemplate;
    }

    public PumpDto toggle() {
        return raspiRestTemplate.getForObject("/pump/toggle", PumpDto.class);
    }
}
