package fer.hr.nenr.Genetski.Selectors.Crossers;

import java.math.BigInteger;
import java.util.Random;

/**
 * Created by Ivan on 3.1.2016..
 */
public class randBinCross extends  binCross {
    public randBinCross(int precision) {
        super(precision);
    }

    @Override
    double newWeight(String first, String second) {
        String newW = "";
        Random rand = new Random();
        for (int i = 0; i<first.length();i++) {
            if (rand.nextDouble() > 0.5) {
                if (i < first.length()) {
                    newW += first.charAt(i);
                } else {
                    newW += second.charAt(i);
                }
            } else {
                if (i < second.length()) {
                    newW += second.charAt(i);
                } else {
                    newW += first.charAt(i);
                }
            }
        }
        return Double.longBitsToDouble(new BigInteger(newW, 2).longValue());
    }

}
