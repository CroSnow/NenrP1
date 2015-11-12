package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.DomainPack.SimpleDomain;
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
    private static IDomain domain= SimpleDomain.intRange(0,100);


    public static IFuzzySet l(int l,int h){
        return (new CalculatedFuzzySet(domain, StandardFuzzySets.lFunction(l,h)));
    }

    public static IFuzzySet triangle(int l, int p, int h){
        return (new CalculatedFuzzySet(domain,StandardFuzzySets.lambdaFunction(l,p,h)));
    }

    public static IFuzzySet gamma(int l,int h){
        return (new CalculatedFuzzySet(domain,StandardFuzzySets.gammaFunction(l,h)));
    }

    public static IFuzzySet losSmijer(){
        return (new CalculatedFuzzySet(domain,StandardFuzzySets.lFunction((int)Math.round(domain.getCardinality()/2.0),
                (int)Math.round(domain.getCardinality()/2.0))));
    }

    public static IFuzzySet dobarSmijer(){
        return (new CalculatedFuzzySet(domain,StandardFuzzySets.gammaFunction((int)Math.round(domain.getCardinality()/2.0),
                (int)Math.round(domain.getCardinality()/2.0))));
    }






}
