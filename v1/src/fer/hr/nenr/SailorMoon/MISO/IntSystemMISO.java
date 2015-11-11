package fer.hr.nenr.SailorMoon.MISO;

import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.Relations.Relations;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.ILogicDB;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan on 10.11.2015..
 */
public abstract class IntSystemMISO implements IIntSystem {

    ILogicDB db;

    public IntSystemMISO(ILogicDB db){
        this.db=db;
    }


}
