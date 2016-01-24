package fer.hr.nenr.Genetski.GeneTown;

import fer.hr.nenr.Genetski.Functions.Function3;
import fer.hr.nenr.Genetski.Functions.Ovca;
import fer.hr.nenr.Genetski.Functions.Rosenbrock;
import fer.hr.nenr.Genetski.Functions.SkoroOvca;
import fer.hr.nenr.Genetski.Rankers.BasicFunctionGeneRanker;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.Crossers.meanCros;
import fer.hr.nenr.Genetski.Selectors.Crossers.secondBinCross;
import fer.hr.nenr.Genetski.Selectors.ISelector;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;
import fer.hr.nenr.Genetski.Selectors.Mutator.Mutator;
import fer.hr.nenr.Genetski.Selectors.Mutator.binMutator;
import fer.hr.nenr.Genetski.Selectors.Roulet;
import fer.hr.nenr.Genetski.Selectors.Turnir;
import fer.hr.nenr.Genetski.System.GeneSystem;

/**
 * Created by Ivan on 3.1.2016..
 */
public class Test3 {
    public static void main(String[] args){
        double epsilon = 10E-6;
        double h = 150;
        double l = -50;
        ICross cross= new meanCros();
        IMutator mutator = new Mutator(0.01,l/2.0,h/2.0,l,h);
        IMutator binMutator = new binMutator(0.001,4);
        ICross binCross = new secondBinCross(4);
        ISelector binSelector = new Roulet(binMutator,binCross,true);
        ISelector selector = new Roulet(mutator,cross,true);
        ISelector turnir= new Turnir(mutator,cross);
        GeneSystem geneSystem = new GeneSystem(selector,new BasicFunctionGeneRanker());
        GeneSystem binGeneSystem = new GeneSystem(binSelector,new BasicFunctionGeneRanker());

        System.out.println("F3");
        geneSystem.train(10000,epsilon,30,2,l,h,new Ovca(),false,500000);
        System.out.println("bin F3");
        binGeneSystem.train(10000,epsilon,30,2,l,h,new Ovca(),true,500000);
        System.out.println("F4");
        geneSystem.train(10000,epsilon,30,2,l,h,new SkoroOvca(),false,500000);
        System.out.println("bin F4");
        binGeneSystem.train(10000,epsilon,30,2,l,h,new SkoroOvca(),true,500000);

    }
}
