package fer.hr.nenr.ANFIS.Layers;

import java.util.List;

/**
 * Created by Ivan on 5.1.2016..
 */
public class Layer5Neuron {
    private List<Layer4Neuron> all;
    private double lastValue;

    public Layer5Neuron(List<Layer4Neuron> all){
        this.all= all;
    }
    public double calculate(){
        lastValue = 0;
        for(Layer4Neuron prev:all){
            lastValue +=prev.getLastValue();
        }
        return lastValue;
    }

    public double getLastValue() {
        return lastValue;
    }
}
