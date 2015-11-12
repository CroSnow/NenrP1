package fer.hr.nenr.SailorMoon;

import fer.hr.nenr.SailorMoon.MISO.DekoderPack.COADekoder;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.DeNormer;
import fer.hr.nenr.SailorMoon.MISO.IIntSystem;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.AkcDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.SmjerDB;
import fer.hr.nenr.SailorMoon.MISO.MinSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ivan on 10.11.2015..
 */
public class Test {

    public static void main(String[] args) {
        testSystem(10,10,10,10,10,1);


    }

    private static void testSystem(int L,int D,int LK,int DK,int V,int S){


        int akcel,kormilo;

        HashMap<String,Integer> map= new HashMap<>();
            /**
             * init sustava
             */
        IIntSystem akc = new MinSystem(new AkcDB(),new COADekoder());
        IIntSystem korm = new MinSystem(new SmjerDB(),new COADekoder());

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

}
