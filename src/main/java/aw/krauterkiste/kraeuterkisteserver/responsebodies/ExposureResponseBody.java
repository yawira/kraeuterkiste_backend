package aw.krauterkiste.kraeuterkisteserver.responsebodies;

import aw.krauterkiste.kraeuterkisteserver.entities.Exposure;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExposureResponseBody {

    List<Exposure> exposureList = new ArrayList<Exposure>();

}
