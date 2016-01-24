package fer.hr.nenr.ANFIS.Layers;

import java.util.Random;

/**
 * Created by Ivan on 5.1.2016..
 */
public class Layer1Neuron {
    private double a;
    private double b;
    private double lastValue;
    public Layer1Neuron(double lower, double upper){
        Random rand = new Random();
        a = rand.nextDouble()*(upper-lower)+lower;
        b = rand.nextDouble()*(upper-lower)+lower;
    }

    public double value(double x){
        lastValue = 1.0/(1+Math.pow(Math.E,b*(x-a)));
        return lastValue;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getLastValue() {
        return lastValue;
    }

}
