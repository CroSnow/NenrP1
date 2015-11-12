package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan on 10.11.2015..
 */
public interface IRule {
    IFuzzySet procces(HashMap<String,IFuzzySet> map, IBinaryFunction impl,IBinaryFunction norm);

}
