package fer.hr.nenr.SailorMoon.DefuzzyficationPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.MutableFuzzySet;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack.IIntFuzzyCalculator;

/**
 * Created by Ivan on 10.11.2015..
 */
public class FuzzyKoder implements IKoder {
    IDomain domain;
    IIntFuzzyCalculator calculator;
    public FuzzyKoder(IDomain domain,IIntFuzzyCalculator calculator){
        this.domain=domain;
        this.calculator=calculator;
    }

    /**
     * Prima vrijednost i modelira neizrazit skup
     * @param value vrijendost
     * @return pripadnost neizratom skupu na temelju vrijednosti
     */
    @Override
    public IFuzzySet code(int value) {
        MutableFuzzySet fuzzySet = new MutableFuzzySet(this.domain);

        return this.calculator.fillSet(fuzzySet,value);
    }
}
