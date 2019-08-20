package aw.krauterkiste;

import aw.krauterkiste.kraeuterkisteServer.entities.Moisture;
import aw.krauterkiste.kraeuterkisteServer.repositories.MoistureRepository;
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

    @Autowired
    MoistureRepository moistureRepository;

    @PostConstruct
    public void fillDatabase() {

        Moisture moistureData1 = new Moisture(20, LocalDateTime.now().minusDays(2));
        Moisture moistureData2 = new Moisture(10, LocalDateTime.now().minusHours(4));
        Moisture moistureData3 = new Moisture(95, LocalDateTime.now().minusMonths(2));
        Moisture moistureData4 = new Moisture(3, LocalDateTime.now().minusDays(1));

        moistureRepository.save(moistureData1);
        moistureRepository.save(moistureData2);
        moistureRepository.save(moistureData3);
        moistureRepository.save(moistureData4);

    }

}
