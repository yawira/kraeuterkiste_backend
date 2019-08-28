package aw.krauterkiste;

import aw.krauterkiste.moisture.controller.MoistureController;
import aw.krauterkiste.moisture.model.Moisture;
import aw.krauterkiste.moisture.repository.MoistureRepository;
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
