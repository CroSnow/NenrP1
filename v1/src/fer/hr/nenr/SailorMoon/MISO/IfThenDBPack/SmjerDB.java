package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;
import org.omg.CORBA.IRObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Snow on 12/11/15.
 */
public class SmjerDB extends FilledLogicDB {
    private List<IRule> rules;

    public SmjerDB() {
        super();
        this.rules=new LinkedList<>();

    }

    @Override
    public List<IRule> getRules() {
        return this.rules;
    }
}
