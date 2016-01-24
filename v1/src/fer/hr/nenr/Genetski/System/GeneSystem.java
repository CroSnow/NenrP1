package fer.hr.nenr.Genetski.System;

import fer.hr.nenr.Genetski.Functions.IFunction;
import fer.hr.nenr.Genetski.Genes.IGene;
import fer.hr.nenr.Genetski.Populations.IPopulation;
import fer.hr.nenr.Genetski.Populations.Population;
import fer.hr.nenr.Genetski.Rankers.IGeneRanker;
import fer.hr.nenr.Genetski.Rankers.IMultipleTwoParamsRanker;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.ISelector;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public class GeneSystem {
    ISelector selector;
    IGeneRanker ranker;
    IPopulation population;
    private List<Double> history;
    public GeneSystem(ISelector selector,IGeneRanker ranker){
        this.ranker=ranker;
        this.selector=selector;

    }

    public IGene train(int iterations, double epsilon, int popSize,int weightCnt,double l, double h, IFunction function, boolean bin,int fncCount){
        Boolean first=true;
        IGene best = null;
        this.history = new LinkedList<>();
        this.population= Population.generetaRandomPopulation(popSize,weightCnt,l,h,function,bin);
        for(int i=0;i<iterations;i++){
            for(IGene gene:this.population.getGenes()) {
                ranker.scoreAndWriteGene(gene);
            }
            if(first){
                best = population.getBest().copy();
                first=false;
                double ress = best.result();
                System.out.println("Result = "+ress+" Best: "+best+" with score of "+best.getScore()+" in iteration: "+i);
                this.history.add(ress);

            }
            if(Double.compare(best.getScore(),(population.getBest().getScore()))>0){
                best = population.getBest().copy();
                double ress = best.result();
                System.out.println("Result = "+ress+" Best: "+best+" with score of "+best.getScore()+" in iteration: "+i);
                this.history.add(ress);
            }
            if (best.getScore()<epsilon){
                return best;
            }
            this.population=selector.selectGenes(this.population);
            if(this.population.getFunCnt()>fncCount){
                break;
            }
        }
        return best;
    }

    public List<Double> getHistroy(){
        return this.history;
    }
}
