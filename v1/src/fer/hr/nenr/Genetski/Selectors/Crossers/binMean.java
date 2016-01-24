package fer.hr.nenr.Genetski.Selectors.Crossers;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Ivan on 8.1.2016..
 */
public class binMean extends  binCross {
    public binMean(int precision) {
        super(precision);
    }

    @Override
    double newWeight(String first, String second) {
        String newW = "";
        Random r = new Random();
        char R;
        int minL = first.length();
        if(minL>second.length()){
            minL = second.length();
        }
        for (int i = 0; i < minL; i++){
            if(r.nextDouble()<0.5){
                R= '0';
            }else {
                R='1';
            }
            newW+=or(and(first.charAt(i),second.charAt(i)),and(R,xor(first.charAt(i),second.charAt(i))));
        }
        return  Double.longBitsToDouble(new BigInteger(newW, 2).longValue());
    }

    private char and (char first, char second){
        if(first =='0'||second=='0'){
            return '0';
        }
        return '1';
    }

    private char or (char first, char second){
        if(first =='1'||second =='1'){
            return '1';
        }
        return '0';
    }

    private char xor (char first, char second){
        if((first=='1'&&second=='1')||(first=='0'&&second=='0')){
            return '0';
        }
        return '1';
    }
}
