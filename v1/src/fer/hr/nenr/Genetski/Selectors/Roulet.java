package fer.hr.nenr.Genetski.Selectors;

import fer.hr.nenr.Genetski.Genes.IGene;
import fer.hr.nenr.Genetski.Populations.IPopulation;
import fer.hr.nenr.Genetski.Populations.Population;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;

import java.util.*;

/**
 * Created by Ivan on 18.11.2015..
 */
public class Roulet implements ISelector {
    private final IMutator mutator;
    private final ICross crosser;
    private boolean elite;

    public Roulet (IMutator mutator, ICross crosser,boolean elite){
        this.mutator=mutator;
        this.crosser=crosser;
        this.elite=elite;
    }

    @Override
    public IPopulation selectGenes(IPopulation population) {
        List<IGene> old = new LinkedList<>(population.getGenes());
        List<IGene> newPop = new LinkedList<>();
        if(this.elite){
            newPop.add(population.getBest().copy());
        }
        Random rand = new Random();
        double sumFit=population.getWholeFittnes();


        Collections.sort(old, new Comparator<IGene>() {
            @Override
            public int compare(IGene o1, IGene o2) {
                if (o1.getScore()<o2.getScore())
                    return -1;
                else if(o1.getScore()>o2.getScore()){
                    return 1;
                }
                else return 0;
            }
        });


        while(newPop.size()<old.size()){
            double randFit=rand.nextDouble()*sumFit;
            IGene first = this.chose(old,randFit);
            randFit=rand.nextDouble()*sumFit;
            IGene second = this.chose(old,randFit);
            newPop.add(crosser.cross(first,second));

        }
        List<IGene> selected= new LinkedList<>();
        for(IGene gen:newPop){
            selected.add(mutator.mutate(gen));
        }
        return new Population(selected);
    }
    private IGene chose(List<IGene> sorted,double value){
        int I =0;
        for(IGene gen: sorted){

            if(gen.getFitness()>value){

                return  gen;
            }
            else {
                value=value-gen.getFitness();
            }
        }
        System.err.println("Chose za roulet nesto cudnoga");
        return sorted.get(sorted.size()-1);

    }
}
