package aw.krauterkiste.kraeuterkisteserver.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@Entity
public class Pictures {

    // fileName = Name der Bilddatei
    private String fileName;
    // pathName = Speicherort der Bilddatei
    private String pathName;

    private LocalDateTime pictureTaken;

    @Id
    @GeneratedValue
    @Column(name="picturesId")
    private Long picturesId;



}
