package fer.hr.nenr.SailorMoon;

import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.Operations;

import fer.hr.nenr.SailorMoon.MISO.DekoderPack.COADekoder;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.DeNormer;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.IDekoder;
import fer.hr.nenr.SailorMoon.MISO.IIntSystem;

import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.AkcDBv2;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.AkcDBv2.*;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.Rule;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.SmjerDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.SmjerDBv2;
import fer.hr.nenr.SailorMoon.MISO.MinSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.FilledLogicDBv2.Lijevo;
import static fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.FilledLogicDBv2.blizu;
import static fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.FilledLogicDBv2.jakoBlizu;

/**
 * Created by Ivan on 10.11.2015..
 */
public class Test {

    public static void main(String[] args) {


        testSystem(500,5,1000,1000,10,1);


    }

    private static void testSystem(int L,int D,int LK,int DK,int V,int S){


        int akcel,kormilo;

        HashMap<String,Integer> map= new HashMap<>();

        IIntSystem akc = new MinSystem(new AkcDBv2(),new COADekoder());
        IIntSystem korm = new MinSystem(new SmjerDBv2(),new COADekoder());

        map.put("L",L);
        map.put("D",D);
        map.put("LK",LK);
        map.put("DK",DK);
        map.put("V",V);
        map.put("S",S);

                // fuzzy magic ...
                //Moraju biti int
        akcel = DeNormer.denormAkc(akc.resolve(map));//akceleracija
        kormilo = DeNormer.denormKut(korm.resolve(map));//Moraju biti int+lijevo - desno [-90,90]
        System.out.println(akcel + " " + kormilo);
        System.out.flush();


    }

    public static void testRule(HashMap<String,IFuzzySet> mapUlaz){

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
        IRule rule = new Rule(map,Lijevo());
        IFuzzySet result =  rule.procces(mapUlaz,Operations.zadehAnd(),Operations.zadehAnd(),Operations.zadehOr());
        IDekoder dekoder= new COADekoder();

        System.out.println(DeNormer.denormAkc(dekoder.dekode(result)));
    }

}
