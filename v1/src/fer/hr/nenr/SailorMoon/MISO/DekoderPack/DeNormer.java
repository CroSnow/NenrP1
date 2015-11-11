package fer.hr.nenr.SailorMoon.MISO.DekoderPack;

/**
 * Created by Ivan on 11.11.2015..
 */
public class DeNormer {

    public static  int denormAkc(int akc){
        return akc -50;
    }

    public static int denormKut(int kut){
        return (int)Math.round((kut -50)*(1.8));
    }
}
