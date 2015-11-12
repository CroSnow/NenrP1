package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Ivan on 10.11.2015..
 */
public interface ILogicDB {

    public List<IRule> getRules();
}
