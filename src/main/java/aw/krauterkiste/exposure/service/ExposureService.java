package aw.krauterkiste.exposure.service;

import aw.krauterkiste.exposure.model.Exposure;
import aw.krauterkiste.exposure.model.ExposureDataDto;
import aw.krauterkiste.exposure.model.ExposureDto;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public ExposureDto toggle() {
        ExposureDto exposureDto = raspiRestTemplate
                .getForObject("/led/toggle", ExposureDto.class);

        Exposure exposure = new Exposure();
        exposure.setDateTime(exposureDto.getDateTime());
        exposure.setOn(exposureDto.isOn());

        exposureRepository.save(exposure);

        return exposureDto;
    }

    public ExposureDataDto getData() {
        ExposureDataDto exposureDataDto = new ExposureDataDto();

        exposureDataDto.setExposureList(exposureRepository.findAll());

        return exposureDataDto;
    }
}