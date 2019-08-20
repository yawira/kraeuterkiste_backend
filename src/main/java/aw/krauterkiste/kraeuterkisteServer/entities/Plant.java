package aw.krauterkiste.kraeuterkisteServer.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDate;

@Data
@Entity
public class Plant {

    private String plantName;
    private LocalDate planted;

}
