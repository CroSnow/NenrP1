package fer.hr.nenr.FuzzySetPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IIntUnaryFunction;

/**
 * Created by Ivan on 18.10.2015..
 */
public class CalculatedFuzzySet implements IFuzzySet {
    private IDomain domain;
    private IIntUnaryFunction function;
    public CalculatedFuzzySet(IDomain domain,IIntUnaryFunction function){
        this.domain=domain;
        this.function=function;
    }
    @Override
    public IDomain getDomain() {
        return this.domain;
    }

    @Override
    public double getValueAt(DomainElement element) {
        int index = this.domain.indexOfElement(element);

        return this.function.valueAt(index) ;
    }
    public String toString(){
        String set="";
        for (int i = 0;i<domain.getCardinality();i++){
            DomainElement element= domain.elementForIndex(i);
            set+="d("+element+")="+this.getValueAt(element)+"\n";
        }

        return set;
    }


}
