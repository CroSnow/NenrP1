package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.FuzzySetPack.StandardFuzzySets;
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
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.jakoBlizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Desno(),impl);
                return Y;
            }
        });


        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.jakoBlizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.JakoDesno(),impl);
                return Y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.jakoBlizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Desno(),impl);
                return Y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("L"),FilledLogicDB.jakoBlizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return Y;
            }
        });

        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.jakoBlizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(x,FilledLogicDB.JakoLijevo(),impl);
                return Y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.jakoBlizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return Y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.blizu(),tNorm);
                IFuzzySet Y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Desno(),impl);
                return Y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.blizu(),tNorm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Desno(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("L"),FilledLogicDB.blizu(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule() {
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.blizu(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return y;
            }
        });

    }
    private void daleko(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction norm){
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("L"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Desno(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.Desno(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("LK"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.JakoDesno(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.NemaSkretanja(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(StandardFuzzySets.reverseSet(x),FilledLogicDB.NemaSkretanja(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.Lijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.JakoLijevo(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("D"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.NemaSkretanja(),impl);
                return y;
            }
        });
        rules.add(new IRule(){
            @Override
            public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {

                IFuzzySet x = Operations.binaryOperation(map.get("DK"),FilledLogicDB.daleko(),tNorm);
                IFuzzySet y= Operations.binaryOperation(x,FilledLogicDB.NemaSkretanja(),impl);
                return y;
            }
        });
    }

    @Override
    public List<IRule> getRules() {
        return this.rules;
    }
}
