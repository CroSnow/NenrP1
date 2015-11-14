package fer.hr.nenr.FuzzySetPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;

/**
 * Created by Ivan on 14.11.2015..
 */
public class ConstantFuzzySet extends MutableFuzzySet {
    public ConstantFuzzySet(IDomain domain,double constant) {
        super(domain);
        for(DomainElement element:domain){
            this.set(element,constant);
        }
    }


}
