package aw.kraeuterkiste.camera.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Picture {

    @Id
    @GeneratedValue
    @Column(name="picturesId")
    private Long picturesId;

    private String fileName;
    private String pathName;

    private LocalDateTime pictureTaken;

}
