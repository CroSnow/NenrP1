package fer.hr.nenr.GenNeuronNetwork;

import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public class Tip2Function implements NeuronFunction {
    private int dimension;
    public Tip2Function(int dimension){
        this.dimension = dimension;
    }
    @Override
    public int  getWeightCount() {
        return dimension+1;
    }

    @Override
    public double calculate(List<Double> inputs, List<Double> weigts) {
        double sum = 0;
        for (int i = 0;i<inputs.size();i++){
            sum += weigts.get(i)*inputs.get(i);
        }

        sum += weigts.get(weigts.size()-1);
        return 1.0/(1.0+Math.pow(Math.E,-sum));
    }
}
