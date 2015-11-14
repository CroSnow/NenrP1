package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 14.11.2015..
 */
public class AkcDBv2 extends FilledLogicDBv2 {
    private List<IRule> rules= new LinkedList<>();

    public AkcDBv2(){
        super();

    }


    public List<IRule> getRules() {
        return this.rules;
    }
}
