package aw.krauterkiste.exposure.model;

import aw.krauterkiste.exposure.model.Exposure;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExposureResponseBody {

    List<Exposure> exposureList = new ArrayList<Exposure>();

}
