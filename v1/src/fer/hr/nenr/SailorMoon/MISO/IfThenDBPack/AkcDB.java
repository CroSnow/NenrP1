package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Snow on 12/11/15.
 */
public class AkcDB extends FilledLogicDB {
    private List<IRule> rules;

    public AkcDB() {
        super();
        this.rules = new LinkedList<>();
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("L"),FilledLogicDB.jakoBlizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.JakoDesno(),impl);
                return y;
            }
        });
    }

    @Override
    public List<IRule> getRules() {

        return rules;
    }
}
