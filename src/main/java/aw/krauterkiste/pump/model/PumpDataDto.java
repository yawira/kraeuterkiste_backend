package aw.krauterkiste.pump.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PumpDataDto {

    List<Pump> pumpList = new ArrayList<Pump>();

}