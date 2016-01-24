package fer.hr.nenr.ANFIS.Test;

import fer.hr.nenr.ANFIS.ANFISFunction;
import fer.hr.nenr.ANFIS.AnfisSystem;
import fer.hr.nenr.FuzzySetPack.Operations;

/**
 * Created by Ivan on 6.1.2016..
 */
public class letsHopeItWorksTest {
    public static void main(String[] args){
        AnfisSystem system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.001,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,true,"");
    }
}
