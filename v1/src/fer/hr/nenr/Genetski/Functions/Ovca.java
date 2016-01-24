package fer.hr.nenr.Genetski.Functions;

import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public class Ovca extends AFunction {
    @Override
    public double calculate(List<Double> X) {
        double sum = 0;
        for (int i = 0; i<X.size();i++){
            sum+= Math.pow(X.get(i),2);
        }
        double result = Math.pow(Math.sin(Math.sqrt(sum)),2)-0.5;
        result = 0.5+ result/(Math.pow((1+0.001*sum),2));
        return result;
    }
}
