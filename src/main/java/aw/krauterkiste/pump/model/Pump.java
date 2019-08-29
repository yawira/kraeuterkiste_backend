package aw.krauterkiste.pump.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Pump {

    @Id
    @GeneratedValue
    private Long pumpId;

    private LocalDateTime dateTime;
    private boolean active;

}