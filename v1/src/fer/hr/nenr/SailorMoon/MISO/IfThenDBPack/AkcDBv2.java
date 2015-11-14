package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.Rule;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 14.11.2015..
 */
public class AkcDBv2 extends FilledLogicDBv2 {
    private List<IRule> rules= new LinkedList<>();

    public AkcDBv2(){
        super();
        makeRules();
    }

    private void makeRules(){
        HashMap<String,List<IFuzzySet>> map = new HashMap<>();
        List<IFuzzySet> list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);

        list= new LinkedList<>();
        list.add(spor());
        list.add(miruje());
        map.put("V",list);

        rules.add(new Rule(map,UbrzajJako()));
        map = new HashMap<>();

        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);

        list= new LinkedList<>();
        list.add(spor());
        list.add(miruje());
        list.add(normalna());

        rules.add(new Rule(map,Ubrzaj()));

        map.put("V",list);

        map = new HashMap<>();

        list = new LinkedList<>();
        list.add(jakoBrz());

        map.put("V",list);
        rules.add(new Rule(map,Uspori()));

        map = new HashMap<>();

        list = new LinkedList<>();
        list.add(brz());

        map.put("V",list);
        rules.add(new Rule(map,NeMijenjajAkc()));
    }
    public List<IRule> getRules() {
        return this.rules;
    }
}
