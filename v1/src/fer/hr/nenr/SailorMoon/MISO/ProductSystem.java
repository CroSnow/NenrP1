package fer.hr.nenr.SailorMoon.MISO;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.IDekoder;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.ILogicDB;

import java.util.HashMap;

/**
 * Created by Snow on 12/11/15.
 */
public class ProductSystem extends IntSystemMISO {

    private static IBinaryFunction tNorm=Operations.mandProd();
    private static IBinaryFunction sNorm=Operations.zadehOr();
    private static IBinaryFunction impl=Operations.mandProd();


    public ProductSystem(ILogicDB db, IDekoder dekoder) {
        super(db,dekoder);
    }

    @Override
    public int resolve(HashMap<String, Integer> map) {
        IFuzzySet L=duljinaKoder.code(map.get("L"));
        IFuzzySet D=duljinaKoder.code(map.get("D"));
        IFuzzySet LK=duljinaKoder.code(map.get("LK"));
        IFuzzySet DK=duljinaKoder.code(map.get("DK"));
        IFuzzySet S=smjerKoder.code(map.get("S"));
        IFuzzySet V=brzinaKoder.code(map.get("V"));

        HashMap<String,IFuzzySet> fuzzyMap=new HashMap<>();
        fuzzyMap.put("L",L);
        fuzzyMap.put("D",D);
        fuzzyMap.put("LK",LK);
        fuzzyMap.put("DK",DK);
        fuzzyMap.put("S",S);
        fuzzyMap.put("V",V);

        return super.resolve(fuzzyMap,tNorm,sNorm,impl);
    }
}
