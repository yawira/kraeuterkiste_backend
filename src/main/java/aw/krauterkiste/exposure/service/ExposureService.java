package aw.krauterkiste.exposure.service;

import aw.krauterkiste.exposure.model.ExposureStatusDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ExposureService {

    private final RestTemplate raspiRestTemplate;

    @Autowired
    public ExposureService(RestTemplate raspiRestTemplate) {
        this.raspiRestTemplate = raspiRestTemplate;
    }

    public ExposureStatusDto toggle() {
        return raspiRestTemplate.getForObject("/led/toggle", ExposureStatusDto.class);
    }
}
