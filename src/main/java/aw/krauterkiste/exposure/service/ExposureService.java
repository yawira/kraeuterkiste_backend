package aw.krauterkiste.exposure.service;

import aw.krauterkiste.exposure.model.Exposure;
import aw.krauterkiste.exposure.model.ExposureDataDto;
import aw.krauterkiste.exposure.model.ExposureStatusDto;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Service
public class ExposureService {

    private final RestTemplate raspiRestTemplate;
    private final ExposureRepository exposureRepository;

    @Autowired
    public ExposureService(RestTemplate raspiRestTemplate,
                           ExposureRepository exposureRepository) {
        this.raspiRestTemplate = raspiRestTemplate;
        this.exposureRepository = exposureRepository;
    }

    public ExposureStatusDto toggle() {
        ExposureStatusDto statusDto = raspiRestTemplate.getForObject("/led/toggle", ExposureStatusDto.class);

        if(statusDto.isOn()) {
            LocalDateTime start = LocalDateTime.now();
            Exposure exposure = new Exposure();
            exposure.setExposureDateTime(start);
            exposureRepository.save(exposure);
        } else {
            LocalDateTime end = LocalDateTime.now();
            Exposure exposure = exposureRepository.findTopByOrderByExposureDateTimeDesc();
            LocalDateTime start = exposure.getExposureDateTime();
            exposure.setExposureInSecs((int) ChronoUnit.SECONDS.between(start, end));
            exposureRepository.save(exposure);
        }

        return statusDto;
    }

    public ExposureDataDto getData() {
        List<Exposure> data = exposureRepository.findAll();
        ExposureDataDto dataDto = new ExposureDataDto();
        dataDto.setExposureList(data);
        return dataDto;
    }
}
