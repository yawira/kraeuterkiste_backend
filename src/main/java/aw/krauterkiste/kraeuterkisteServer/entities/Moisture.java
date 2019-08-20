package aw.krauterkiste.kraeuterkisteServer.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
public class Moisture {

    private double moisturePercentage;
    private LocalDateTime moistureDateTime;


}
