package fer.hr.nenr.ANFIS.Test;

import fer.hr.nenr.ANFIS.ANFISFunction;
import fer.hr.nenr.ANFIS.AnfisSystem;
import fer.hr.nenr.FuzzySetPack.Operations;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Ivan on 7.1.2016..
 */
public class Test3 {
    public static void main(String[] args){
        AnfisSystem system = new AnfisSystem(4,-1,1, Operations.mandProd());
        system.train(0.001,500000,10E-4,new ANFISFunction(),-4,4,1,-4,4,1,true,false,"");
        double start = -4;
        double end = 4;
        double step = 0.1;
        ANFISFunction fun = new ANFISFunction();
        FileWriter writer = null;
        try {
            writer = new FileWriter("AnfisPogreska.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(double x = start;x<=end;x+= step){
            for(double y = start;y<=end;y+= step){
                double realOut = fun.valueAt(x,y);
                double myOut = system.calculate(x,y);
                double diff = myOut-realOut;
                try {
                    writer.write(x+" "+y+" "+diff+"\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        try {
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
