package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.ConstantFuzzySet;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;

import javax.management.relation.Relation;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by Ivan on 10.11.2015..
 */
public class Rule  implements IRule{
    private HashMap<String,List<IFuzzySet>> mapRules;
    private IFuzzySet y;
    public Rule(HashMap<String,List<IFuzzySet>> map,IFuzzySet y){
        this.mapRules=map;
        this.y=y;
    }


    @Override
    public IFuzzySet procces(HashMap<String, IFuzzySet> map, IBinaryFunction impl, IBinaryFunction tNorm,IBinaryFunction sNorm) {
        Set<String> keyset= mapRules.keySet();
        List<Double> values=new LinkedList<>();
        IDomain domain = null;
        for(String key :keyset){
            List<IFuzzySet> subList= mapRules.get(key);
            IFuzzySet ruleFuzzySet=subList.get(0);
            domain= ruleFuzzySet.getDomain();
            for(int i=1;i<subList.size();i++){
                ruleFuzzySet=Operations.binaryOperation(ruleFuzzySet,subList.get(i),sNorm);
            }
            IFuzzySet inputSet=map.get(key);
            for(DomainElement element:domain){
                if(inputSet.getValueAt(element)!=0){
                    values.add(tNorm.valueAt(inputSet.getValueAt(element),ruleFuzzySet.getValueAt(element)));
                }
            }

        }
        boolean first = true;
        double value=0;
        for (double val : values){
            if(first){
                first=false;
                value=val;
            }else{
                value=tNorm.valueAt(value,val);
            }
        }
        IFuzzySet left = new ConstantFuzzySet(domain,value);
        return Operations.binaryOperation(left,y,tNorm);
    }
}
