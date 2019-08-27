package aw.krauterkiste.pump.service;

import aw.krauterkiste.pump.model.PumpStatusDto;
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

    public PumpStatusDto toggle() {
        return raspiRestTemplate.getForObject("/pump/toggle", PumpStatusDto.class);
    }
}
