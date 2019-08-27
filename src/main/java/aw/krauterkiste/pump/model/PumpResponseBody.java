package aw.krauterkiste.pump.model;


import aw.krauterkiste.pump.model.Pump;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PumpResponseBody {

    List<Pump> pumpList = new ArrayList<Pump>();

}
