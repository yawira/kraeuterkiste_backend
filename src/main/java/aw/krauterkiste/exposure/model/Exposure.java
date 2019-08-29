package aw.krauterkiste.exposure.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Exposure {

    private LocalDateTime dateTime;
    private boolean on;

    @Id
    @GeneratedValue
    private Long id;

}