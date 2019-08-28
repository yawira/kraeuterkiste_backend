package aw.krauterkiste.pump.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Pump {

    private int pumpInSecs;
    private LocalDateTime pumpDateTime;

    @Id
    @GeneratedValue
    @Column(name="pumpId")
    private Long pumpId;

}