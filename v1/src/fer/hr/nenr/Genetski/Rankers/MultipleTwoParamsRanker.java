package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public class MultipleTwoParamsRanker implements  IMultipleTwoParamsRanker {
    private ISingleTwoParamsRanker ranker;
    public MultipleTwoParamsRanker(ISingleTwoParamsRanker ranker){
        this.ranker=ranker;
    }

    @Override
    public double scoreGene(IGene gene, List<Double> X, List<Double> Y,List<Double> Z) {
        double sum=0;
        for (int i = 0;i<X.size();i++){
            sum+=this.ranker.scoreGene(gene,X.get(i),Y.get(i),Z.get(i));
        }
        return sum/X.size();
    }

    @Override
    public double scoreAndWriteGene(IGene gene, List<Double> X, List<Double> Y,List<Double> Z) {
        double score = this.scoreGene(gene,X,Y,Z);
        gene.setScore(score);
        return score;
    }
}
