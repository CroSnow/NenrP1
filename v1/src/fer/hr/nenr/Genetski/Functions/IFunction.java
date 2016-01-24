package fer.hr.nenr.Genetski.Functions;

import java.util.List;

/**
 * Created by Ivan on 31.12.2015..
 */
public interface IFunction {
    double calculate(List<Double> X);
    double calculateAndCount(List<Double> X);
    int getCount();
}
