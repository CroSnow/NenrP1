package fer.hr.nenr.Genetski.Functions;

import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public abstract class AFunction implements IFunction {
    private int count;

    public AFunction(){
        this.count = 0;
    }

    public double calculateAndCount(List<Double> X){
        this.count+=1;
        return this.calculate(X);
    }
    public int getCount(){
        return this.count;
    }
}
