package fer.hr.nenr.Genetski.Genes;

import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface IGene {
    double result(double x,double y);
    double getScore();
    public List<Double> getWeights();
    void setScore(double score);
    IGene copy();
    IGene newGene(List<Double> weights);
    double getFitness();
}
