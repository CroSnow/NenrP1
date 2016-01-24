package fer.hr.nenr.Genetski.Selectors.Crossers;

import java.math.BigInteger;

/**
 * Created by Ivan on 3.1.2016..
 */
public class secondBinCross extends  binCross {
    public secondBinCross(int precision) {
        super(precision);
    }

    @Override
    double newWeight(String first, String second) {
        String newW = "";
        int maxL = first.length();
        if(maxL<second.length()){
            maxL = second.length();
        }
        for (int i = 0; i<maxL;i++){

            if (i%2==0){
                if(i<first.length()) {
                    newW += first.charAt(i);
                }else{
                    newW += second.charAt(i);
                }
            }else{
                if(i<second.length()) {
                    newW += second.charAt(i);
                }else{
                    newW += first.charAt(i);
                }

            }
        }
        return Double.longBitsToDouble(new BigInteger(newW, 2).longValue());
    }
}
