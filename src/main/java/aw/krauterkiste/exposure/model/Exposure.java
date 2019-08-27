package aw.krauterkiste.exposure.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Exposure {

    private int exposureInSecs;
    private boolean active;
    private LocalDateTime exposureDateTime;

    @Id
    @GeneratedValue
    @Column(name="exposureId")
    private Long exposureId;


}
