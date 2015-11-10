package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule;

import fer.hr.nenr.DomainPack.DomainElement;

import java.util.List;

/**
 * Created by Ivan on 10.11.2015..
 */
public interface IRule {
    List<Float> procces(List<DomainElement> elements);
}
