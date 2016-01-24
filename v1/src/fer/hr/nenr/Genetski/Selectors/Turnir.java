package fer.hr.nenr.Genetski.Selectors;

import fer.hr.nenr.Genetski.Genes.IGene;
import fer.hr.nenr.Genetski.Populations.IPopulation;
import fer.hr.nenr.Genetski.Populations.Population;
import fer.hr.nenr.Genetski.Selectors.Crossers.ICross;
import fer.hr.nenr.Genetski.Selectors.Mutator.IMutator;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 16.11.2015..
 */
public class Turnir implements ISelector {
    private IMutator mutator;
    private ICross crosser;
    public Turnir(IMutator mutator,ICross crosser){
        this.mutator=mutator;
        this.crosser=crosser;
    }
    @Override
    public IPopulation selectGenes(IPopulation population) {
        List<IGene>all= new LinkedList<>(population.getGenes());
        LinkedList<IGene> subSelected = new LinkedList();
        List<IGene> selected = new LinkedList<>();
        List<Integer> selectedInt = new LinkedList<>();
        Random rand = new Random();
        while(selected.size()<all.size()){
            selectedInt=new LinkedList<>();
            for(int i =0;i<3;i++){

                int randSelected = rand.nextInt(all.size());
                selectedInt.add(randSelected);
                while(selectedInt.contains(randSelected)){
                    randSelected = rand.nextInt(all.size());
                }
            }
            int wortsI=0;
            IGene worst=all.get(selectedInt.get(0)).copy();
            if(worst.getScore()<all.get(selectedInt.get(1)).getScore()){
                subSelected.add(worst.copy());
                wortsI=1;
                worst=all.get(selectedInt.get(1)).copy();
            }else{
                subSelected.add(all.get(selectedInt.get(1)).copy());
            }

            if(worst.getScore()<all.get(selectedInt.get(2)).getScore()){
                subSelected.add(worst.copy());
                worst=all.get(selectedInt.get(2)).copy();
                wortsI=2;
            }else{
                subSelected.add(all.get(selectedInt.get(2)).copy());
            }
            all.remove(wortsI);
            all.add(this.crosser.cross(subSelected.get(0),subSelected.get(1)));

            for(IGene one:all){
                selected.add(mutator.mutate(one));
                if(selected.size()==all.size()){
                    break;
                }
            }

        }
        return new Population(selected,population.getFunction());
    }
}
