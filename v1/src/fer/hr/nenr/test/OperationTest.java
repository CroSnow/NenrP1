package fer.hr.nenr.test;

import fer.hr.nenr.DomainPack.*;
import fer.hr.nenr.FuzzySetPack.*;

/**
 * Created by Ivan on 18.10.2015..
 */
public class OperationTest {
    public static void main(String[] args) {
        IDomain d = Domain.intRange(0, 11);
        IFuzzySet set1 = new MutableFuzzySet(d)
                .set(DomainElement.of(0), 1.0)
                .set(DomainElement.of(1), 0.8)
                .set(DomainElement.of(2), 0.6)
                .set(DomainElement.of(3), 0.4)
                .set(DomainElement.of(4), 0.2);
        System.out.println("Set 1:\n"+set1);
        IFuzzySet notSet1 = Operations.unaryOperation(set1, Operations.zadehNot());
        System.out.println("notSet 1:\n"+notSet1);
        IFuzzySet union = Operations.binaryOperation(set1, notSet1, Operations.zadehOr());
        System.out.println("Set1 union notSet1:\n"+union);
        IFuzzySet hinters = Operations.binaryOperation(set1, notSet1, Operations.hamacherTNorm(1.0));
        System.out.println("Set1 intersection with notSet1 using parameterised Hamacher T norm with parameter 1.0\n:"+hinters);
    }

}
