package fer.hr.nenr.GenNeuronNetwork;

import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public interface NeuronFunction {
    int getWeightCount();
    double calculate(List<Double> inputs,List<Double> weigts);

}
