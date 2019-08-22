package aw.krauterkiste.kraeuterkisteserver.responsebodies;

import aw.krauterkiste.kraeuterkisteserver.entities.Moisture;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoistureResponseBody {

    List<Moisture> moistureList = new ArrayList<Moisture>();

}
