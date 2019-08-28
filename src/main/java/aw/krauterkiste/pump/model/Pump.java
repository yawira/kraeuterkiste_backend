package aw.krauterkiste.pump.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Pump {

    private LocalDateTime start;
    private LocalDateTime stop;

    @Id
    @GeneratedValue
    private Long pumpId;

}