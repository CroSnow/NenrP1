package fer.hr.nenr.Genetski.GeneTown;

import fer.hr.nenr.Genetski.Functions.Ovca;
import fer.hr.nenr.Genetski.Functions.SkoroOvca;
import fer.hr.nenr.Genetski.Rankers.BasicFunctionGeneRanker;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.Crossers.meanCros;
import fer.hr.nenr.Genetski.Selectors.ISelector;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;
import fer.hr.nenr.Genetski.Selectors.Mutator.Mutator;
import fer.hr.nenr.Genetski.Selectors.Roulet;
import fer.hr.nenr.Genetski.Selectors.Turnir;
import fer.hr.nenr.Genetski.System.GeneSystem;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public class Test4 {
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
        double epsilon = 10E-6;
        double h = 150;
        double l = -50;
        ICross cross= new meanCros();
        IMutator mutator = new Mutator(0.01,l/2.0,h/2.0,l,h);
        ISelector selector = new Roulet(mutator,cross,true);
        ISelector turnir= new Turnir(mutator,cross);
        GeneSystem geneSystem = new GeneSystem(selector,new BasicFunctionGeneRanker());
        List<Integer> pops =new LinkedList<>();

        pops.add(30);
        pops.add(50);
        pops.add(100);
        List<List<Double>> all = new LinkedList<>();
        int maxI = 0;
        for (int pop : pops) {

            System.out.println("F3");
            geneSystem.train(10000, epsilon, pop, 2, l, h, new Ovca(), false, 500000);
            all.add(geneSystem.getHistroy());
            if(maxI<geneSystem.getHistroy().size()){
                maxI=geneSystem.getHistroy().size();
            }
        }
        PrintWriter writer = new PrintWriter("boxPlot.txt", "UTF-8");
        writer.println("30,50,100");
        for(int i = 0; i<maxI;i++){
            String line ="";
            for(int j=0 ; j< pops.size();j++){
                if(j!=0){
                    line+=",";
                }
                List<Double> hist = all.get(j);
                if(hist.size()>i){
                    line+=hist.get(i).toString();
                }
            }
            writer.println(line);
        }

        writer.close();
    }
}
