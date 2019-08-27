package aw.krauterkiste.moisture.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoistureDataDto {

    List<Moisture> moistureList = new ArrayList<Moisture>();

}
