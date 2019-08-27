package aw.krauterkiste.plant.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PlantDto {

    List<Plant> plantList = new ArrayList<Plant>();

}
