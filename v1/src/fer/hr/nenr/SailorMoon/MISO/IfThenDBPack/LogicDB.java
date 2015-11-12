package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.CalculatedFuzzySet;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.FuzzySetPack.StandardFuzzySets;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.IDekoder;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.Rule;

import javax.imageio.event.IIOReadUpdateListener;
import java.util.List;

/**
 * Created by Ivan on 10.11.2015..
 * Pravila
 * Skreni jako desno
 * Skreni desno
 * Skreni jako lijevo
 * Skreni lijevo
 * ne skreni
 */
public abstract class LogicDB implements ILogicDB {
    private IDomain domain;
    public LogicDB(IDomain domain){
        this.domain=domain;
    }

    public IFuzzySet l(int l,int h){
        return (new CalculatedFuzzySet(this.domain, StandardFuzzySets.lFunction(l,h)));
    }

    public IFuzzySet triangle(int l, int p, int h){
        return (new CalculatedFuzzySet(this.domain,StandardFuzzySets.lambdaFunction(l,p,h)));
    }

    public IFuzzySet gamma(int l,int h){
        return (new CalculatedFuzzySet(this.domain,StandardFuzzySets.gammaFunction(l,h)));
    }

    public IFuzzySet losSmijer(){
        return (new CalculatedFuzzySet(this.domain,StandardFuzzySets.lFunction((int)Math.round(this.domain.getCardinality()/2.0),
                (int)Math.round(this.domain.getCardinality()/2.0))));
    }

    public IFuzzySet dobarSmijer(){
        return (new CalculatedFuzzySet(this.domain,StandardFuzzySets.gammaFunction((int)Math.round(this.domain.getCardinality()/2.0),
                (int)Math.round(this.domain.getCardinality()/2.0))));
    }






}
