package fer.hr.nenr.ANFIS.Layers;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;

import java.util.List;

/**
 * Created by Ivan on 5.1.2016..
 */
public class Layer3Neuron {
    private Layer2Neuron prev;
    private double lastValue;

    public Layer3Neuron(Layer2Neuron prev){
        this.prev = prev;

    }
    public double calculate(Double all){
        this.lastValue = prev.getLastValue()/all;
        return this.lastValue;
    }

    public double getLastValue() {
        return lastValue;
    }
}
