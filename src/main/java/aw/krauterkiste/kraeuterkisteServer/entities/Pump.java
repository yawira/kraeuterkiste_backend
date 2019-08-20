package aw.krauterkiste.kraeuterkisteServer.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
public class Pump {

    private LocalDateTime startWatering;
    private LocalDateTime stopWatering;
    private LocalDateTime wateringDuration;

}
