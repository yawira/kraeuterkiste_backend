package aw.krauterkiste.kraeuterkisteserver.responsebodies;


import aw.krauterkiste.kraeuterkisteserver.entities.Pump;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PumpResponseBody {

    List<Pump> pumpList = new ArrayList<Pump>();

}
