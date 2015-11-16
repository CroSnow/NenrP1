package fer.hr.nenr.Genetski.Selectors.Mutator;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface IMutator {
    IGene mutate(IGene old);
}
