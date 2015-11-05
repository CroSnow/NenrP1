package fer.hr.nenr.FuzzySetPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;

/**
 * Created by Ivan on 18.10.2015..
 */
public interface IFuzzySet {

    public IDomain getDomain();
    public double getValueAt(DomainElement element);

}
