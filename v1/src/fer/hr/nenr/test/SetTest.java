package fer.hr.nenr.test;

import fer.hr.nenr.DomainPack.*;
import fer.hr.nenr.FuzzySetPack.*;

/**
 * Created by Ivan on 18.10.2015..
 */
public class SetTest {
    public static void main(String[] args) {
        IDomain d = Domain.intRange(0, 11); // {0,1,...,10}
        IFuzzySet set1 = new MutableFuzzySet(d)
                .set(DomainElement.of(0), 1.0)
                .set(DomainElement.of(1), 0.8)
                .set(DomainElement.of(2), 0.6)
                .set(DomainElement.of(3), 0.4)
                .set(DomainElement.of(4), 0.2);
        System.out.println("Set 1:\n"+set1);
        IDomain d2 = Domain.intRange(-5, 6); // {-5,-4,...,4,5}
        IFuzzySet set2 = new CalculatedFuzzySet(
                d2,
                StandardFuzzySets.lambdaFunction(
                        d2.indexOfElement(DomainElement.of(-4)),
                        d2.indexOfElement(DomainElement.of( 0)),
                        d2.indexOfElement(DomainElement.of( 4))
                )
        );
        System.out.println("Set 2:\n"+set2);
    }
}
