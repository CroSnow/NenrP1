package fer.hr.nenr.Genetski.Genes;

import fer.hr.nenr.Genetski.Functions.IFunction;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 31.12.2015..
 */
public class openFunctionGene extends AGene {
    private IFunction function;
    public openFunctionGene(List<Double> weights, IFunction function) {
        super(weights);
        this.function = function;
    }

    @Override
    public double result(double x, double y) {
        return 0;
    }

    @Override
    public IGene copy() {
        openFunctionGene gen= new openFunctionGene(new LinkedList<>(weights),function);
        gen.setScore(this.getScore());
        return gen;
    }

    @Override
    public IGene newGene(List<Double> weights) {
        return new openFunctionGene(weights,function);
    }


    public double result() {
        return 0;
    }
}
