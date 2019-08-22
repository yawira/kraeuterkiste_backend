package aw.krauterkiste.kraeuterkisteserver.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Pump {

    private LocalDateTime startWatering;
    private LocalDateTime stopWatering;
    private LocalDateTime wateringDuration;

    @Id
    @GeneratedValue
    @Column(name="pumpId")
    private Long pumpId;

}
