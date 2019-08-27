package aw.krauterkiste.moisture.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class MoistureDto {

    List<Moisture> moistureList = new ArrayList<Moisture>();

}
