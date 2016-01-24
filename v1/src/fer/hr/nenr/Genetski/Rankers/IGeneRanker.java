package fer.hr.nenr.Genetski.Rankers;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 3.1.2016..
 */
public interface IGeneRanker {
    double scoreAndWriteGene(IGene gene);
    double scoreGene(IGene gene);
}
