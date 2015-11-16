package fer.hr.nenr.Genetski.Populations;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface IPopulation {
    List<IGene> getGenes();
    IGene getBest();
}
