package fer.hr.nenr.Genetski.Selectors.Mutator;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 16.11.2015..
 */
public class Mutator implements IMutator {
    double chance;
    double l;
    double h;
    double boundL;
    double boundH;
    public Mutator(double chance,double l,double h,double boundL,double boundH){
        this.chance=chance;
        this.l=l;
        this.h=h;
    }
    @Override
    public IGene mutate(IGene old) {
        List<Double> weights= old.getWeights();
        List<Double> newWeights= new LinkedList<>();
        Random rand = new Random();
        for(double weight:weights){
            double newWeight=weight;
            double mutChance= rand.nextDouble();
            if( mutChance<this.chance){
                newWeight +=rand.nextDouble()*(h-l)+l;
                if (newWeight<boundL){
                    newWeight=boundL;
                }
                if(newWeight>boundH){
                    newWeight=boundH;
                }
            }
            newWeights.add(newWeight);
        }
        return old.newGene(newWeights);
    }
}
