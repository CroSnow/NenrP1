package fer.hr.nenr.SailorMoon;

import java.io.*;
import java.util.Scanner;

/**
 * Created by Ivan on 10.11.2015..
 */
public class SailorBoy {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

        int L=0,D=0,LK=0,DK=0,V=0,S=0,akcel,kormilo;
        String line = null;
        /**
         * init sustava
         */
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

            // fuzzy magic ...
            //Moraju biti int
            akcel = 10;//akceleracija
            kormilo = 0;//Moraju biti int+lijevo - desno [-90,90]
            System.out.println(akcel + " " + kormilo);
            System.out.flush();
        }
    }
}
