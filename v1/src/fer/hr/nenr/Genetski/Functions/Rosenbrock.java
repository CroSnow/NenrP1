package fer.hr.nenr.Genetski.Functions;

import java.util.List;

/**
 * Created by Ivan on 31.12.2015..
 */
public class Rosenbrock extends AFunction {
    @Override
    public double calculate(List<Double> X) {
        return 100*Math.pow(X.get(1)-X.get(0)*X.get(0),2)+Math.pow(1-X.get(0),2);
    }
}
