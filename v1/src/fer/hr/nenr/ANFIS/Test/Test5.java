package fer.hr.nenr.ANFIS.Test;

import fer.hr.nenr.ANFIS.ANFISFunction;
import fer.hr.nenr.ANFIS.AnfisSystem;
import fer.hr.nenr.FuzzySetPack.Operations;

/**
 * Created by Ivan on 7.1.2016..
 */
public class Test5 {
    public static void main(String[] args){
        AnfisSystem system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.05,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"AnfisGreskaPoEpohaStohaVelika.txt");
        system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.05,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,false,false,"AnfisGreskaPoEpohaNotStohaVelika.txt");
/*
        system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.001,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"AnfisGreskaPoEpohaSohaPrikladna.txt");
        system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.001,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,false,false,"AnfisGreskaPoEpohaNotStohaPrikladna.txt");

        system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.00005,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"AnfisGreskaPoEpohaSohaMala.txt");
        system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.00005,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,false,false,"AnfisGreskaPoEpohaNotStohaMala.txt");*/
    }
}
