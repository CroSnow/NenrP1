package fer.hr.nenr.Genetski.GeneTown;

import fer.hr.nenr.Genetski.Functions.Function3;
import fer.hr.nenr.Genetski.Functions.Ovca;
import fer.hr.nenr.Genetski.Functions.Rosenbrock;
import fer.hr.nenr.Genetski.Functions.SkoroOvca;
import fer.hr.nenr.Genetski.Rankers.BasicFunctionGeneRanker;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.Crossers.binMean;
import fer.hr.nenr.Genetski.Selectors.Crossers.meanCros;
import fer.hr.nenr.Genetski.Selectors.Crossers.multCross;
import fer.hr.nenr.Genetski.Selectors.ISelector;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;
import fer.hr.nenr.Genetski.Selectors.Mutator.Mutator;
import fer.hr.nenr.Genetski.Selectors.Roulet;
import fer.hr.nenr.Genetski.Selectors.Turnir;
import fer.hr.nenr.Genetski.System.GeneSystem;

/**
 * Created by Ivan on 3.1.2016..
 */
public class Test1 {

    public static void main(String[] args){
        double epsilon = 10E-6;
        double h = 150;
        double l = -50;
        ICross cross= new meanCros();
        IMutator mutator = new Mutator(0.55,l/2.0,h/2.0,l,h);
        ISelector selector = new Roulet(mutator,cross,false);
        ISelector turnir= new Turnir(mutator,cross);
        GeneSystem geneSystem = new GeneSystem(selector,new BasicFunctionGeneRanker());
        System.out.println("F1");
        geneSystem.train(500000,epsilon,50,2,l,h,new Rosenbrock(),true,25000000);

        System.out.println("F2");

        mutator =new Mutator(0.2,l/2.0,h/2.0,l,h);
        selector = new Roulet(mutator,cross,false);
        geneSystem.train(500000,epsilon,50,5,l,h,new Function3(),true,25000000);
        System.out.println("F3");
        mutator = new Mutator(0.4,l/2.0,h/2.0,l,h);
        selector = new Roulet(mutator,cross,false);
        geneSystem.train(500000,epsilon,50,2,l,h,new Ovca(),true,25000000);
        System.out.println("F4");

        mutator = new Mutator(0.3,l/2.0,h/2.0,l,h);
        selector = new Roulet(mutator,cross,false);
        geneSystem.train(500000,epsilon,50,2,l,h,new SkoroOvca(),true,25000000);

    }
}
