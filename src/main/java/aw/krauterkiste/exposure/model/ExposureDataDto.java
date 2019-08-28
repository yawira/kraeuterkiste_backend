package aw.krauterkiste.exposure.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExposureDataDto {

    List<Exposure> exposureList = new ArrayList<Exposure>();

}