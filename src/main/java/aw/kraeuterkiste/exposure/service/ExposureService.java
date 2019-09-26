package aw.kraeuterkiste.exposure.service;

import aw.kraeuterkiste.exposure.model.Exposure;
import aw.kraeuterkiste.exposure.model.ExposureDto;
import aw.kraeuterkiste.exposure.repository.ExposureRepository;
import aw.kraeuterkiste.exposure.model.ExposureData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.ArrayList;
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

    // Method toggles exposure and saves start time as well as duration in database
    public ExposureDto toggle() {
        ExposureDto exposureDto = raspiRestTemplate
                .getForObject("/led/toggle", ExposureDto.class);

        Exposure exposure = new Exposure();
        exposure.setDateTime(exposureDto.getDateTime());
        exposure.setActive(exposureDto.isActive());

        exposureRepository.save(exposure);

        return exposureDto;
    }

    // Method necessary to show exposure data in frontend chart
    public List<ExposureData> getData() {
        List<ExposureData> data = new ArrayList<>();
        List<Exposure> rawData = exposureRepository.findAllByOrderByDateTimeDesc();

        LocalDateTime start = null;
        LocalDateTime stop = null;

        for(Exposure rawDataItem : rawData) {
            LocalDateTime dateTime = rawDataItem.getDateTime();

            if(rawDataItem.isActive()) {
                start = dateTime;
            } else {
                stop = dateTime;
            }

            if(start != null && stop != null && stop.isAfter(start)) {
                data.add(new ExposureData(start, stop));
            }
        }

        return data;
    }
}