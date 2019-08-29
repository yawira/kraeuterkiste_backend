package aw.krauterkiste.exposure.service;

import aw.krauterkiste.exposure.model.Exposure;
import aw.krauterkiste.exposure.model.ExposureData;
import aw.krauterkiste.exposure.model.ExposureDataDto;
import aw.krauterkiste.exposure.model.ExposureDto;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
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

        List<Exposure> rawData = exposureRepository.findAllByOrderByDateTimeDesc();

        LocalDateTime start = null;
        LocalDateTime stop = null;

        for(Exposure rawDataItem : rawData) {
            LocalDateTime dateTime = rawDataItem.getDateTime();

            if(rawDataItem.isOn()) {
                start = dateTime;
            } else {
                stop = dateTime;
            }

            if(start != null && stop != null && stop.isAfter(start)) {
                ExposureData exposureData = new ExposureData(start, stop);
                exposureDataDto.getExposureList().add(exposureData);
            }
        }

        return exposureDataDto;
    }
}