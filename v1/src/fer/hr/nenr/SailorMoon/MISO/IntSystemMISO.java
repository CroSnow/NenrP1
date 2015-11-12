package fer.hr.nenr.SailorMoon.MISO;

import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.DomainPack.SimpleDomain;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IUnaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.Relations.Relations;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack.IIntFuzzyCalculator;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack.OneCalculator;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyKoder;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.IDekoder;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.ILogicDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan on 10.11.2015..
 */
public abstract class IntSystemMISO implements IIntSystem {

    protected ILogicDB db;
    protected IDekoder dekoder;
    protected IDomain standardDomain= new SimpleDomain(0,100);
    protected IIntFuzzyCalculator omjer13jedan= new OneCalculator(13);
    protected IIntFuzzyCalculator smjerMult=new OneCalculator((float) (1.0/70));
    protected IIntFuzzyCalculator brzinaStoper = new OneCalculator(2);
    protected FuzzyKoder duljinaKoder = new FuzzyKoder(this.standardDomain,omjer13jedan);
    protected FuzzyKoder smjerKoder = new FuzzyKoder(this.standardDomain,smjerMult);
    protected FuzzyKoder brzinaKoder= new FuzzyKoder(this.standardDomain,brzinaStoper);

    public IntSystemMISO(ILogicDB db,IDekoder dekoder){
        this.db=db;
        this.dekoder=dekoder;
    }

    protected int resolve(HashMap<String, IFuzzySet> map, IBinaryFunction tNorm, IBinaryFunction sNorm, IBinaryFunction impl){
        List<IRule> rules=this.db.getRules();
        Boolean first=true;
        IFuzzySet set= null;
        for (IRule rule : rules){
            if(first){

                first=false;
                set=rule.procces(map,impl,tNorm);
            }
            else{
                set=Operations.binaryOperation(set,rule.procces(map,impl,tNorm),sNorm);
            }
        }
        return this.dekoder.dekode(set);
    }


}
