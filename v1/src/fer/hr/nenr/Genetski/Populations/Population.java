package fer.hr.nenr.Genetski.Populations;

import fer.hr.nenr.Genetski.Genes.BasicFunctionGene;
import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public class Population implements IPopulation {
    private List<IGene> genes = new LinkedList<>();

    public Population(List<IGene> genes){
        this.genes= new LinkedList<>(genes);
    }


    public static IPopulation generetaRandomPopulation(int size,int weightCnt,double low, double high){
        List<IGene> genes= new LinkedList<>();
        for (int i=0;i<size;i++){
            genes.add(BasicFunctionGene.createStartGene(weightCnt,low,high));
        }
        return new Population(genes);
    }

    @Override
    public List<IGene> getGenes() {
        return genes;
    }

    @Override
    public IGene getBest() {
        IGene best =genes.get(0);
        for(int i=0;i<genes.size();i++){
            if(genes.get(i).getScore()<best.getScore()){
                best=genes.get(i).copy();
            }
        }
        return best.copy();
    }

    public void setGenes(List<IGene> genes) {
        this.genes = genes;
    }
    public double getWholeFittnes(){
        double fittnes=0;
        for(IGene gen :this.genes){
            fittnes+=gen.getFitness();
        }
        return fittnes;
    }
}
