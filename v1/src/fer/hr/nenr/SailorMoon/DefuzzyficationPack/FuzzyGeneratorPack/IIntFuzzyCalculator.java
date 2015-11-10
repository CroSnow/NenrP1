package fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack;

import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.MutableFuzzySet;

/**
 * Created by Ivan on 10.11.2015..
 */
public interface IIntFuzzyCalculator {

    IFuzzySet fillSet(MutableFuzzySet set,int value);
}
