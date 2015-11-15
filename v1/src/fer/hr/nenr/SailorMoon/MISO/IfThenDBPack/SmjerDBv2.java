package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.Rule;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 14.11.2015..
 */
public class SmjerDBv2 extends FilledLogicDBv2 {
    private List<IRule> rules = new LinkedList<IRule>();

    public SmjerDBv2(){
        super();
        makeRules();

    }

    @Override
    public List<IRule> getRules() {
        return this.rules;
    }

    private void makeRules(){
        this.turnLeft();
        this.turnRight();
        this.turnSharpLeft();
        this.turnSharpRight();

    }

    private void turnLeft(){
        HashMap<String,List<IFuzzySet>> map = new HashMap<>();
        List<IFuzzySet> list = new LinkedList<IFuzzySet>() ;
        list.add(blizu());
        list.add(jakoBlizu());
        map.put("D",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("L",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("LK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,Lijevo()));

        map = new HashMap<>();
        list = new LinkedList<IFuzzySet>() ;
        list.add(blizu());
        list.add(jakoBlizu());
        map.put("DK",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("L",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("LK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,Lijevo()));

        map= new HashMap<>();
        list= new LinkedList<>();



    }

    private void turnRight(){
        HashMap<String,List<IFuzzySet>> map = new HashMap<>();
        List<IFuzzySet> list = new LinkedList<IFuzzySet>() ;
        list.add(blizu());
        list.add(jakoBlizu());
        map.put("L",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("D",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("DK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,Desno()));

        map = new HashMap<>();
        list = new LinkedList<IFuzzySet>() ;

        list.add(blizu());
        list.add(jakoBlizu());
        map.put("LK",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("D",list);

        list= new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("DK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,Desno()));


    }

    private void turnSharpLeft(){
        HashMap<String,List<IFuzzySet>> map = new HashMap<>();
        List<IFuzzySet> list = new LinkedList<IFuzzySet>() ;

        list.add(jakoBlizu());
        map.put("D",list);

        list= new LinkedList<>();
        list.add(daleko());
        map.put("L",list);

        list= new LinkedList<>();
        list.add(daleko());
        map.put("LK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,JakoLijevo()));

        map = new HashMap<>();
        list = new LinkedList<IFuzzySet>() ;

        list.add(jakoBlizu());
        map.put("DK",list);

        list= new LinkedList<>();
        list.add(daleko());

        map.put("L",list);

        list= new LinkedList<>();
        list.add(daleko());
        map.put("LK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,JakoLijevo()));

        list.add(daleko());
        map.put("LK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,JakoLijevo()));
    }

    private void turnSharpRight(){
        HashMap<String,List<IFuzzySet>> map = new HashMap<>();
        List<IFuzzySet> list = new LinkedList<IFuzzySet>() ;

        list.add(jakoBlizu());
        map.put("L",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        list= new LinkedList<>();
        list.add(daleko());
        map.put("D",list);

        list= new LinkedList<>();
        list.add(daleko());

        map.put("DK",list);

        rules.add(new Rule(map,JakoDesno()));

        map = new HashMap<>();
        list = new LinkedList<IFuzzySet>() ;
        list.add(blizu());
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        map.put("LK",list);

        list= new LinkedList<>();
        list.add(daleko());

        map.put("D",list);

        list= new LinkedList<>();
        list.add(daleko());
        map.put("DK",list);

        rules.add(new Rule(map,JakoDesno()));

        list.add(daleko());
        map.put("DK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(dobarSmijer());
        map.put("S",list);
        rules.add(new Rule(map,JakoDesno()));

    }

    public void wrongPath(){
        HashMap<String,List<IFuzzySet>> map = new HashMap<>();
        List<IFuzzySet> list = new LinkedList<>();
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("DK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(losSmijer());
        map.put("S",list);
        rules.add(new Rule(map,JakoDesno()));

        map=new HashMap<>();
        list = new LinkedList<IFuzzySet>() ;
        list.add(Operations.unaryOperation(jakoBlizu(),Operations.zadehNot()));
        map.put("LK",list);
        list = new LinkedList<IFuzzySet>();
        list.add(jakoBlizu());
        map.put("DK",list);
        list = new LinkedList<IFuzzySet>() ;
        list.add(losSmijer());
        map.put("S",list);
        rules.add(new Rule(map,JakoLijevo()));
    }
}
