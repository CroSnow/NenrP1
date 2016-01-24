package fer.hr.nenr.ANFIS;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;

/**
 * Created by Ivan on 6.1.2016..
 */
public class ANFISFunction implements IBinaryFunction {
    @Override
    public double valueAt(double x, double y) {
        double cosKva = Math.pow(Math.cos(x/5.0),2);
        return (Math.pow(x-1,2)+Math.pow(y+2,2)-5*x*y+3)*cosKva;
    }
}
