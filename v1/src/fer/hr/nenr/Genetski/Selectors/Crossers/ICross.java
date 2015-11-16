package fer.hr.nenr.Genetski.Selectors.Crossers;

import fer.hr.nenr.Genetski.Genes.IGene;

/**
 * Created by Ivan on 16.11.2015..
 */
public interface ICross {
    public IGene cross(IGene first,IGene second);
}
