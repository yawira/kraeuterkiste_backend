package aw.krauterkiste.exposure.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Exposure {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime dateTime;
    private boolean active;

}