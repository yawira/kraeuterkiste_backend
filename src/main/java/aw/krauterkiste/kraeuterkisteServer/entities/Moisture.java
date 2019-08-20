package aw.krauterkiste.kraeuterkisteServer.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Moisture {

    private double moisturePercentage;
    private LocalDateTime moistureDateTime;

    @Id
    @GeneratedValue
    @Column(name="moistureId")
    private Long moistureId;


}
