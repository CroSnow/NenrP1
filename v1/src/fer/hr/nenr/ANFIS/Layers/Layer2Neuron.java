package fer.hr.nenr.ANFIS.Layers;

import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;

/**
 * Created by Ivan on 5.1.2016..
 */
public class Layer2Neuron {
    private  Layer1Neuron A;
    private  Layer1Neuron B;
    private IBinaryFunction norm;
    private double lastValue;

    public Layer2Neuron(Layer1Neuron A,Layer1Neuron B,IBinaryFunction norm){
        this.A=A;
        this.B=B;
        this.norm=norm;
    }
    public double calculate(){
        this.lastValue = norm.valueAt(A.getLastValue(),B.getLastValue());
        return this.lastValue;
    }

    public double getLastValue() {
        return lastValue;
    }
}
