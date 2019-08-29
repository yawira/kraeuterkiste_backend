package aw.krauterkiste.moisture.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Moisture {

    private double percentage;
    private LocalDateTime dateTime;

    @Id
    @GeneratedValue
    @Column(name="moistureId")
    private Long moistureId;

}
