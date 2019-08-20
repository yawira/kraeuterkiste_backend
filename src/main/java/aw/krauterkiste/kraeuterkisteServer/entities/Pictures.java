package aw.krauterkiste.kraeuterkisteServer.entities;

import lombok.Data;

import javax.persistence.Entity;
import java.time.LocalDateTime;

@Data
@Entity
public class Pictures {

    // fileName = Name der Bilddatei
    private String fileName;
    // pathName = Speicherort der Bilddatei
    private String pathName;

    private LocalDateTime pictureTaken;



}
