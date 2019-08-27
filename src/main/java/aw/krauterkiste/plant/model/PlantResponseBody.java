package aw.krauterkiste.plant.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlantResponseBody {

    List<Plant> plantList = new ArrayList<Plant>();

}
