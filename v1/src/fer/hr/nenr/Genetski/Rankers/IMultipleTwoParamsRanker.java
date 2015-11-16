package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface IMultipleTwoParamsRanker {

    double scoreGene(IGene gene, List<Double> X, List<Double> Y,List<Double> Z);
    double scoreAndWriteGene(IGene gene, List<Double> X, List<Double> Y,List<Double> Z);
}
