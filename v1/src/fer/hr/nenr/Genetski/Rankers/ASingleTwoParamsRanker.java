package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 16.11.2015..
 */
public abstract class ASingleTwoParamsRanker implements ISingleTwoParamsRanker{

    @Override
    public double scoreAndWriteGene(IGene gene, double x, double y, double z){
        double score=this.scoreGene(gene,x,y,z);
        gene.setScore(score);
        return score;
    }
}
