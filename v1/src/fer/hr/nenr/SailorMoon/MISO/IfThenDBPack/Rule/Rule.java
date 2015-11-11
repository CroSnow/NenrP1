package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule;

import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;

import javax.management.relation.Relation;

/**
 * Created by Ivan on 10.11.2015..
 */
public class Rule  implements IRule{
    private IFuzzySet set;
    public Rule(IFuzzySet set){
        this.set=set;
    }
    @Override
    public IFuzzySet procces(IFuzzySet set) {

        return null;
    }

    public IFuzzySet getSet(){
        return this.set;
    }
}
