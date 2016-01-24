package fer.hr.nenr.Genetski.Genes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import fer.hr.nenr.Genetski.Functions.*;

/**
 * Created by Ivan on 16.11.2015..
 */
public class BasicFunctionGene extends  AGene {
    private IFunction function;


    public BasicFunctionGene(List<Double> weights,IFunction function, boolean bin) {
        super(weights);
        this.function = function;
        this.bin = bin;
    }

    @Override
    public double result(double x, double y) {
        if (this.weights.size()!=5){
            throw new IllegalArgumentException("Wrong number of weights, needed 5 but this class has "+weights.size());
        }
        double exp = Math.pow(x-weights.get(4),2);
        return Math.sin(weights.get(0)+weights.get(1)*x)+weights.get(2)*Math.cos(x*(weights.get(3)+y))*(1.0/(1.0+Math.exp(exp)));
    }

    public BasicFunctionGene copy(){
        BasicFunctionGene gen= new BasicFunctionGene(new LinkedList<>(weights),this.function,this.bin);
        gen.setScore(this.getScore());
        return gen;
    }

    @Override
    public IGene newGene(List<Double> weights) {
        return new BasicFunctionGene(weights,this.function,this.bin);
    }

    @Override
    public double result() {
        return this.function.calculateAndCount(this.weights);
    }

    public static BasicFunctionGene createStartGene(int weightCnt,double low, double high,IFunction function, boolean bin){
        List<Double> weights = new LinkedList<>();
        Random rand = new Random();

        for (int i =0; i<weightCnt;i++){
            weights.add(rand.nextDouble()*(high-low)+low);

        }
        return  new BasicFunctionGene(weights,function,bin);
    }


}
