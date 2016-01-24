package fer.hr.nenr.ANFIS.Test;

import fer.hr.nenr.ANFIS.ANFISFunction;
import fer.hr.nenr.ANFIS.AnfisSystem;
import fer.hr.nenr.FuzzySetPack.Operations;

/**
 * Created by Ivan on 7.1.2016..
 */
public class Test1 {
    public static void main(String[] args){
        AnfisSystem system1 = new AnfisSystem(2,-1,1, Operations.mandProd());
        System.out.println("Broj pravila = 2");
        system1.train(0.001,100000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"");

        AnfisSystem system2 = new AnfisSystem(3,-1,1, Operations.mandProd());
        System.out.println("Broj pravila = 3");
        system2.train(0.001,100000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"");

        int pravila = 4;
        System.out.println("Broj pravila = "+pravila);
        AnfisSystem system3 = new AnfisSystem(pravila,-1,1, Operations.mandProd());
        system3.train(0.001,100000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"");
    }

}
