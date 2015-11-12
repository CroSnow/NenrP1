package fer.hr.nenr.SailorMoon;

import fer.hr.nenr.SailorMoon.MISO.DekoderPack.COADekoder;
import fer.hr.nenr.SailorMoon.MISO.DekoderPack.DeNormer;
import fer.hr.nenr.SailorMoon.MISO.IIntSystem;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.AkcDB;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.SmjerDB;
import fer.hr.nenr.SailorMoon.MISO.MinSystem;


import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by Ivan on 10.11.2015..
 */
public class SailorBoy {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int L=0,D=0,LK=0,DK=0,V=0,S=0,akcel,kormilo;
        String line = null;
        HashMap<String,Integer> map= new HashMap<>();
        /**
         * init sustava
         */
        IIntSystem akc= new MinSystem(new AkcDB(),new COADekoder());
        IIntSystem korm=new MinSystem(new SmjerDB(),new COADekoder());
        while(true){
            if((line = input.readLine())!=null){
                if(line.charAt(0)=='K') break;
                Scanner s = new Scanner(line);
                //interval od 0 do 1300
                L = s.nextInt();//Udaljenost broda od lijeve obale
                D = s.nextInt();//Udaljenost broda od desne obale
                LK = s.nextInt();//Udaljenost broda od obale naprijed lijevo pod kutem od 45
                DK = s.nextInt();//Udaljenost broda od obale naprijed desno pod kutem od 45
                V = s.nextInt();//Iznos brzine broda
                S = s.nextInt();//pravi smjer (1-da/0-ne)
            }
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
}
