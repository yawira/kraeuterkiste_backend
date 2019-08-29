package aw.krauterkiste;

import aw.krauterkiste.exposure.model.Exposure;
import aw.krauterkiste.exposure.repository.ExposureRepository;
import aw.krauterkiste.moisture.controller.MoistureController;
import aw.krauterkiste.moisture.model.Moisture;
import aw.krauterkiste.moisture.repository.MoistureRepository;
import aw.krauterkiste.pump.model.Pump;
import aw.krauterkiste.pump.repository.PumpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

@SpringBootApplication
public class KrauterkisteApplication {

    public static void main(String[] args) {
        SpringApplication.run(KrauterkisteApplication.class, args);
    }

}
