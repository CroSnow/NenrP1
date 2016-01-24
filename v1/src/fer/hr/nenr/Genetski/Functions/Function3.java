package fer.hr.nenr.Genetski.Functions;

import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public class Function3 extends AFunction {
    @Override
    public double calculate(List<Double> X) {
        double sum = 0;
        for (int i = 0; i<X.size();i++){
            sum+= Math.pow(X.get(i)-i,2);
        }
        return sum;
    }
}
