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
public class System {
    ISelector selector;
    IMultipleTwoParamsRanker ranker;
    IPopulation population;

    public System(ISelector selector,IMultipleTwoParamsRanker ranker){
        this.ranker=ranker;
        this.selector=selector;

    }

    public void train(List<Double>X,List<Double>Y,List<Double>Z,int iterations){
        Boolean first=true;
        this.population= Population.generetaRandomPopulation(100,5,-4,4);
        for(int i=0;i<iterations;i++){
            for(IGene gene:this.population.getGenes()) {
                ranker.scoreAndWriteGene(gene, X, Y, Z);
            }
            if(first){
                IGene best=population.getBest();

            }
            this.population=selector.selectGenes(this.population);
        }
    }
}
