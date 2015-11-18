package fer.hr.nenr.Genetski.System;

import fer.hr.nenr.Genetski.Genes.IGene;
import fer.hr.nenr.Genetski.Populations.IPopulation;
import fer.hr.nenr.Genetski.Populations.Population;
import fer.hr.nenr.Genetski.Rankers.IMultipleTwoParamsRanker;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.ISelector;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;

import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public class GeneSystem {
    ISelector selector;
    IMultipleTwoParamsRanker ranker;
    IPopulation population;

    public GeneSystem(ISelector selector,IMultipleTwoParamsRanker ranker){
        this.ranker=ranker;
        this.selector=selector;

    }

    public IGene train(List<Double>X,List<Double>Y,List<Double>Z,int iterations,double epsilon,int popSize){
        Boolean first=true;
        IGene best = null;
        this.population= Population.generetaRandomPopulation(popSize,5,-4,4);
        for(int i=0;i<iterations;i++){
            for(IGene gene:this.population.getGenes()) {
                ranker.scoreAndWriteGene(gene, X, Y, Z);
            }
            if(first){
                best = population.getBest().copy();
                first=false;
                System.out.println("Best: "+best+" with score of "+best.getScore()+" in iteration: "+i);

            }
            if(Double.compare(best.getScore(),(population.getBest().getScore()))>0){
                best = population.getBest().copy();
                System.out.println("Best: "+best+" with score of "+best.getScore()+" in iteration: "+i);
            }
            if (best.getScore()<epsilon){
                return best;
            }
            this.population=selector.selectGenes(this.population);
        }
        return best;
    }
}
