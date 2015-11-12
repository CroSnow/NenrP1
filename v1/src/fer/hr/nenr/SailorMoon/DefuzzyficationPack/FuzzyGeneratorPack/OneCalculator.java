package fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack;

import fer.hr.nenr.DomainPack.Domain;
import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.MutableFuzzySet;

/**
 * Created by Ivan on 10.11.2015..
 */
public class OneCalculator implements IIntFuzzyCalculator {
    private float dimensionConv;
    public OneCalculator(float dimensionConv){
        this.dimensionConv=dimensionConv;
    }

    @Override
    public IFuzzySet fillSet(MutableFuzzySet set, int value) {
        IDomain domain = set.getDomain();
        DomainElement element= DomainElement.of((int)Math.floor((double) value / dimensionConv));
        DomainElement h= domain.elementForIndex(domain.getCardinality()-1);
        if (h.getNumberOfComponents()== 1 && h.getComponentValue(0)<element.getComponentValue(0)){
            element=h;
        }
        if(domain.indexOfElement(element)>=0){
            set.set(element,1);
        }else{
            System.err.println("Kriva vrijednost za domenu");
        }
        return set;
    }
}
