package fer.hr.nenr.Genetski.Functions;

import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public class SkoroOvca extends AFunction {
    @Override
    public double calculate(List<Double> X) {
        double sum = 0;
        for (int i = 0; i<X.size();i++){
            sum+= Math.pow(X.get(i),2);
        }
        double result = Math.pow(sum,0.25)*(1+Math.pow(Math.sin(50*Math.pow(sum,0.1)),2));
        return result;
    }
}
