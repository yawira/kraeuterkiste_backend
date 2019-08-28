package aw.krauterkiste.exposure.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
public class Exposure {

    private int exposureInSecs;
    private LocalDateTime exposureDateTime;

    @Id
    @GeneratedValue
    @Column(name="exposureId")
    private Long exposureId;

}