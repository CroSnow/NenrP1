package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import com.sun.xml.internal.stream.StaxXMLInputSource;
import fer.hr.nenr.FuzzySetPack.CalculatedFuzzySet;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.FuzzySetPack.StandardFuzzySets;
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

                IFuzzySet x = Operations.binaryOperation(map.get("S"),FilledLogicDB.dobarSmijer(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Ubrzaj(),impl);
                return y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("S"),FilledLogicDB.losSmijer(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Uspori(),impl);
                return y;
            }
        });


        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.jakoBrz(),norm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.UsporiJako(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.miruje(),norm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.UbrzajJako(),impl);
                return y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.spor(),norm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Ubrzaj(),impl);
                return y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.brz(),norm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Uspori(),impl);
                return y;
            }
        });


    }

    @Override
    public List<IRule> getRules() {

        return rules;
    }
}
