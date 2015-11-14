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
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("S"),FilledLogicDB.dobarSmijer(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(x,FilledLogicDB.Ubrzaj(),impl);
                return Y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("S"),FilledLogicDB.losSmijer(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(x,FilledLogicDB.Uspori(),impl);
                return Y;
            }
        });


        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.jakoBrz(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.UsporiJako(),impl);
                return Y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.miruje(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.UbrzajJako(),impl);
                return Y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.spor(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Ubrzaj(),impl);
                return Y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("V"),FilledLogicDB.brz(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Uspori(),impl);
                return Y;
            }
        });


    }

    @Override
    public List<IRule> getRules() {

        return rules;
    }
}
