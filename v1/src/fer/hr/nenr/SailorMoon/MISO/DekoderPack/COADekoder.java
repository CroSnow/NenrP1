package fer.hr.nenr.SailorMoon.MISO.DekoderPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;

/**
 * Created by Ivan on 10.11.2015..
 */
public class COADekoder implements IDekoder {

    @Override
    public int dekode(IFuzzySet set) {
        float up=0;
        float down= 0;
        IDomain domain=set.getDomain();
        for(DomainElement element : domain){
            up+=element.getComponentValue(0)*set.getValueAt(element);
            down+=set.getValueAt(element);
        }
        return Math.round(up/down);
    }
}
