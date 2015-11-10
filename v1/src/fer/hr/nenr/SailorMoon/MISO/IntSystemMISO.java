package fer.hr.nenr.SailorMoon.MISO;

import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.ILogicDB;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan on 10.11.2015..
 */
public class IntSystemMISO implements IIntSystem {

    ILogicDB db;

    public IntSystemMISO(ILogicDB db){
        this.db=db;
    }

    @Override
    public int resolve(HashMap<String,Integer> map) {
        return 0;
    }
}
