package fer.hr.nenr.ANFIS.Layers;

import java.util.Random;

/**
 * Created by Ivan on 5.1.2016..
 */
public class Layer4Neuron {
    private double lastValue;
    private Layer3Neuron prev;
    private Double p;
    private Double q;
    private Double r;
    private double z;

    public Layer4Neuron(Layer3Neuron prev,Double lower, Double upper){
        this.prev = prev;
        Random rand = new Random();
        p = rand.nextDouble()*(upper-lower)+lower;
        q = rand.nextDouble()*(upper-lower)+lower;
        r = rand.nextDouble()*(upper-lower)+lower;
    }

    public double calculate(Double x, Double y){
        this.z = (this.p*x+this.q*y+this.r);
        this.lastValue = prev.getLastValue()*z;
        return this.lastValue;
    }

    public double getLastValue() {
        return lastValue;
    }

    public Double getP() {
        return p;
    }

    public void setP(Double p) {
        this.p = p;
    }

    public Double getQ() {
        return q;
    }

    public void setQ(Double q) {
        this.q = q;
    }

    public Double getR() {
        return r;
    }

    public void setR(Double r) {
        this.r = r;
    }

    public double getZ() {
        return z;
    }
}
