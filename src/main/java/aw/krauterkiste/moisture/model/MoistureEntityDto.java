package aw.krauterkiste.moisture.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoistureEntityDto {

    List<Moisture> moistureList = new ArrayList<Moisture>();

}
