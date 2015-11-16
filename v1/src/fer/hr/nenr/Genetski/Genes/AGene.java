package fer.hr.nenr.Genetski.Genes;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public abstract class AGene implements  IGene{
    protected List<Double> weights= new LinkedList<>();
    private double score;

    public AGene(List<Double> weights){
        this.weights=new LinkedList<>(weights);

    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {

        this.weights = weights;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AGene aGene = (AGene) o;

        return !(getWeights() != null ? !getWeights().equals(aGene.getWeights()) : aGene.getWeights() != null);

    }

    @Override
    public int hashCode() {
        return getWeights() != null ? getWeights().hashCode() : 0;
    }


    @Override
    public String toString() {
        String ret="Weights~";
        for (int i=0;i<weights.size();i++){
            ret+=" B"+i+" = "+weights.get(i)+";";
        }

        return ret;
    }

}
