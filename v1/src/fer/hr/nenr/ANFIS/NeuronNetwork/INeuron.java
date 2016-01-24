package fer.hr.nenr.ANFIS.NeuronNetwork;

import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public interface INeuron {

    double calculate(List<Double> inputs);
    void addChildren(List<INeuron> children);
    double activate(double sum);
    double getError();
    void setError(double error);
    void calculateError();
    void backProp(double faktor);
    double getWeight(int i);
    double addToWeight(int i, double sum);


}
