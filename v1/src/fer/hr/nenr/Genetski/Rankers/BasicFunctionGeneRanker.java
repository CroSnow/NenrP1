package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 3.1.2016..
 */
public class BasicFunctionGeneRanker implements IGeneRanker {
    private  int scale = 1;
    @Override
    public double scoreAndWriteGene(IGene gene) {
        double score = Math.pow(gene.result(),2)*scale;
        gene.setScore(score);
        return score;
    }

    @Override
    public double scoreGene(IGene gene) {
        return gene.result();
    }
    public IGeneRanker setScale(int scale){
        this.scale = scale;
        return this;
    }
}
