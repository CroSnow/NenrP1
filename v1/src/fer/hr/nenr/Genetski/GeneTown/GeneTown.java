package fer.hr.nenr.Genetski.GeneTown;

import fer.hr.nenr.Genetski.Genes.IGene;
import fer.hr.nenr.Genetski.Rankers.MultipleTwoParamsRanker;
import fer.hr.nenr.Genetski.Rankers.SingleTwoParamsQuadRanker;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.Crossers.meanCros;
import fer.hr.nenr.Genetski.Selectors.ISelector;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;
import fer.hr.nenr.Genetski.Selectors.Mutator.Mutator;
import fer.hr.nenr.Genetski.Selectors.Roulet;
import fer.hr.nenr.Genetski.Selectors.Turnir;
import fer.hr.nenr.Genetski.System.GeneSystem;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 17.11.2015..
 */
public class GeneTown {

    public static void main(String[] args){
        ICross cross= new meanCros();
        IMutator mutator = new Mutator(0.01,-2,2,-4,4);
        ISelector selector = new Roulet(mutator,cross,true);
        ISelector turnir= new Turnir(mutator,cross);
        //GeneSystem geneSystem = new GeneSystem(selector,new MultipleTwoParamsRanker(new SingleTwoParamsQuadRanker()));
        List<List<Double>> XYZ = parseFromFile("gen-text2.txt");
        //IGene best = geneSystem.train(XYZ.get(0),XYZ.get(1),XYZ.get(2),10000,10E-4,20);
    }


    static List<List<Double>> parseFromFile(String filename){
        BufferedReader br = null;
        List<List<Double>> XYZ = new LinkedList<>();
        List<Double> X = new LinkedList<>();
        List<Double> Y = new LinkedList<>();
        List<Double> Z = new LinkedList<>();
        try {
            br = new BufferedReader(new FileReader(filename));
            try {
                StringBuilder sb = new StringBuilder();
                String line = br.readLine();

                while (line != null) {
                    String[]split=line.split("\\t");
                    X.add(Double.parseDouble(split[0]));
                    Y.add(Double.parseDouble(split[1]));
                    Z.add(Double.parseDouble(split[2]));
                    line = br.readLine();
                }

            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XYZ.add(X);
        XYZ.add(Y);
        XYZ.add(Z);
        return XYZ;
    }
}
