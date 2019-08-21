package aw.krauterkiste.kraeuterkisteServer.responsebodies;

import aw.krauterkiste.kraeuterkisteServer.entities.Moisture;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoistureResponseBody {

    List<Moisture> moistureList = new ArrayList<Moisture>();

}
