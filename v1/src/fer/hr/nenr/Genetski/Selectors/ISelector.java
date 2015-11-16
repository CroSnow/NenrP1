package fer.hr.nenr.Genetski.Selectors;

import fer.hr.nenr.Genetski.Genes.IGene;
import fer.hr.nenr.Genetski.Populations.IPopulation;

import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface ISelector {

    public IPopulation selectGenes(IPopulation population);
}
