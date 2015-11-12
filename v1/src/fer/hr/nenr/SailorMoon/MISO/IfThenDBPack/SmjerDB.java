package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;
import org.omg.CORBA.IRObject;

import java.util.HashMap;
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

        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("L"),FilledLogicDB.jakoBlizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.JakoDesno(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.jakoBlizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.JakoDesno(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.jakoBlizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.JakoLijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.jakoBlizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.JakoLijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("L"),FilledLogicDB.blizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Desno(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.blizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Desno(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.blizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.blizu(),norm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return y;
            }
        });

    }

    @Override
    public List<IRule> getRules() {
        return this.rules;
    }
}
