package fer.hr.nenr.SailorMoon.MISO.SailorSystem;

import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.DomainPack.SimpleDomain;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack.IIntFuzzyCalculator;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyGeneratorPack.OneCalculator;
import fer.hr.nenr.SailorMoon.DefuzzyficationPack.FuzzyKoder;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.COADekoder;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.DeNormer;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.FilledLogicDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.ILogicDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.LogicDB;
import fer.hr.nenr.SailorMoon.MISO.IntSystemMISO;

import java.util.Base64;
import java.util.HashMap;

/**
 * Created by Ivan on 10.11.2015..
 */
public class PathSystem extends IntSystemMISO {
    private IDomain standardDomain= new SimpleDomain(0,100);
    private IIntFuzzyCalculator omjer13jedan= new OneCalculator(13);
    private IIntFuzzyCalculator smjerMult=new OneCalculator((float) (1.0/70));
    private IIntFuzzyCalculator brzinaStoper = new OneCalculator(2);
    private FuzzyKoder duljinaKoder = new FuzzyKoder(this.standardDomain,omjer13jedan);
    private FuzzyKoder smjerKoder = new FuzzyKoder(this.standardDomain,smjerMult);
    private FuzzyKoder brzinaKoder= new FuzzyKoder(this.standardDomain,brzinaStoper);
    public PathSystem() {
        super(new FilledLogicDB());

    }

    @Override
    public int resolve(HashMap<String, Integer> map) {
        int korm=0;
        IFuzzySet L=duljinaKoder.code(map.get("L"));
        IFuzzySet D=duljinaKoder.code(map.get("D"));
        IFuzzySet LK=duljinaKoder.code(map.get("LK"));
        IFuzzySet DK=duljinaKoder.code(map.get("DK"));
        IFuzzySet S=duljinaKoder.code(map.get("S"));
        IFuzzySet V=duljinaKoder.code(map.get("V"));



        //korm= COADekoder(kormSet);
        return DeNormer.denormKut(korm);
    }
}
