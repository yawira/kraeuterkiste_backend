package aw.krauterkiste.kraeuterkisteServer.responsebodies;


import aw.krauterkiste.kraeuterkisteServer.entities.Pump;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PumpResponseBody {

    List<Pump> pumpList = new ArrayList<Pump>();

}
