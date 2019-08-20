package aw.krauterkiste.kraeuterkisteServer.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
public class Exposure {

    private int exposureInSecs;
    private boolean active;
    private LocalDateTime exposureDateTime;


}
