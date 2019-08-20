package aw.krauterkiste.kraeuterkisteServer.responsebodies;

import aw.krauterkiste.kraeuterkisteServer.entities.Exposure;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ExposureResponseBody {

    List<Exposure> exposureList = new ArrayList<Exposure>();

}
