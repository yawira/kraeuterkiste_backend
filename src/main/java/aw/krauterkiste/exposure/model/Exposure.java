package aw.krauterkiste.exposure.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Exposure {

    private LocalDateTime start;
    private LocalDateTime stop;

    @Id
    @GeneratedValue
    private Long id;

}