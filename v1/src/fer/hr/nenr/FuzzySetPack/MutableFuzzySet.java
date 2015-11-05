package fer.hr.nenr.FuzzySetPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;

/**
 * Created by Ivan on 18.10.2015..
 */
public class MutableFuzzySet implements IFuzzySet {
    private double[] memberships;
    private IDomain domain;
    public  MutableFuzzySet (IDomain domain){
        memberships = new double[domain.getCardinality()];
        this.domain=domain;

    }

    public MutableFuzzySet set(DomainElement element,double value){
        int index = domain.indexOfElement(element);
        memberships[index]=value;
        return this;
    }
    @Override
    public IDomain getDomain() {
        return this.domain;
    }

    @Override
    public double getValueAt(DomainElement element) {
        int index = domain.indexOfElement(element);

        return memberships[index] ;
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
