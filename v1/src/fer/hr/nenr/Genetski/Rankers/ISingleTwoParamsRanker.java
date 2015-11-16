package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface ISingleTwoParamsRanker {

    double scoreGene(IGene gene,double x,double y,double z);
    double scoreAndWriteGene(IGene gene,double x,double y,double z);
}
