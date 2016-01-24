package fer.hr.nenr.ANFIS.Test;

import fer.hr.nenr.ANFIS.ANFISFunction;
import fer.hr.nenr.ANFIS.AnfisSystem;
import fer.hr.nenr.FuzzySetPack.Operations;

/**
 * Created by Ivan on 7.1.2016..
 */
public class Test2 {
    public static void main(String[] args){

        int pravila = 4;
        System.out.println("Broj pravila = "+pravila);
        AnfisSystem system3 = new AnfisSystem(pravila,-1,1, Operations.mandProd());
        system3.train(0.001,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"");
        system3.logSystem(-4,4,0.1,"pripadnost.txt");
    }
}
