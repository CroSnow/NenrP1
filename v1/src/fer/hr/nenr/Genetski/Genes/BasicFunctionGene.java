package fer.hr.nenr.Genetski.Genes;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 16.11.2015..
 */
public class BasicFunctionGene extends  AGene {
    public BasicFunctionGene(List<Double> weights) {
        super(weights);
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
        return new BasicFunctionGene(new LinkedList<>(weights));
    }

    @Override
    public IGene newGene(List<Double> weights) {
        return new BasicFunctionGene(weights);
    }

    public static BasicFunctionGene createStartGene(int weightCnt,double low, double high){
        List<Double> weights = new LinkedList<>();
        Random rand = new Random();

        for (int i =0; i<weightCnt;i++){
            weights.add(rand.nextDouble()*(high-low)+low);

        }
        return  new BasicFunctionGene(weights);
    }

    public static BasicFunctionGene createDefStartGene(){
        return createStartGene(5,-4,4);
    }
}
