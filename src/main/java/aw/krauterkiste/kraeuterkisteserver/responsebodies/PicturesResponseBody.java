package aw.krauterkiste.kraeuterkisteserver.responsebodies;

import aw.krauterkiste.kraeuterkisteserver.entities.Pictures;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Data
public class PicturesResponseBody {

    List<Pictures> picturesList = new ArrayList<Pictures>();

}
