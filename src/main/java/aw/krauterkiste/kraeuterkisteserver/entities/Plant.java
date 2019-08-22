package aw.krauterkiste.kraeuterkisteserver.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
public class Plant {

    @Id
    @GeneratedValue
    @Column(name="plantId")
    private Long plantId;

    private String plantName;
    private LocalDate planted;

}
