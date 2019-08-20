package aw.krauterkiste.kraeuterkisteServer.responsebodies;

import aw.krauterkiste.kraeuterkisteServer.entities.Pictures;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PicturesResponseBody {

    List<Pictures> picturesList = new ArrayList<Pictures>();

}
