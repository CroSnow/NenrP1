package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 16.11.2015..
 */
public class SingleTwoParamsQuadRanker extends ASingleTwoParamsRanker {
    @Override
    public double scoreGene(IGene gene, double x, double y, double z) {
        return Math.pow(gene.result(x, y)-z,2);
    }
}
