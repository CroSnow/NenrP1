package fer.hr.nenr.Genetski.GeneTown;

import fer.hr.nenr.Genetski.Functions.Function3;
import fer.hr.nenr.Genetski.Functions.Ovca;
import fer.hr.nenr.Genetski.Functions.Rosenbrock;
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

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public class Test2 {
    public static void main(String[] args){
        double epsilon = 10E-6;
        double h = 150;
        double l = -50;
        ICross cross= new meanCros();
        IMutator mutator = new Mutator(0.01,l/2.0,h/2.0,l,h);
        ISelector selector = new Roulet(mutator,cross,true);
        ISelector turnir= new Turnir(mutator,cross);
        GeneSystem geneSystem = new GeneSystem(selector,new BasicFunctionGeneRanker());
        List<Integer> dims =new LinkedList<>();
        dims.add(1);
        dims.add(3);
        dims.add(6);
        dims.add(10);
        for (int dim : dims) {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ DIM = "+dim+"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("F3");
            geneSystem.train(10000, epsilon, 30, dim, l, h, new Ovca(), false, 500000);
            System.out.println("F4");
            geneSystem.train(10000, epsilon, 30, dim, l, h, new SkoroOvca(), false, 500000);
        }
    }
}
