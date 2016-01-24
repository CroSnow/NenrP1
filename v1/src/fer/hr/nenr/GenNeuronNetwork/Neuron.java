package fer.hr.nenr.GenNeuronNetwork;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public class Neuron {
    private List<Double> weights = new LinkedList<>();
    private NeuronFunction fun ;
    public Neuron(NeuronFunction fun){
        this.fun = fun;
    }

    public double calculate(List<Double> inputs){
        return fun.calculate(inputs,weights);
    }

    public int getWeightCount(){
        return this.fun.getWeightCount();
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
    }

}
