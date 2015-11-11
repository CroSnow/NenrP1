package fer.hr.nenr.SailorMoon.MISO.SailorSystem;

import fer.hr.nenr.DomainPack.SimpleDomain;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.FilledLogicDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.ILogicDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.LogicDB;
import fer.hr.nenr.SailorMoon.MISO.IntSystemMISO;

import java.util.HashMap;

/**
 * Created by Ivan on 10.11.2015..
 */
public class AkcelerationSystem extends IntSystemMISO {
    public AkcelerationSystem() {
        super(new FilledLogicDB());
    }

    @Override
    public int resolve(HashMap<String, Integer> map) {
        return 0;
    }
}
