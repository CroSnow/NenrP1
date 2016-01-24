package fer.hr.nenr.ANFIS.NeuronNetwork;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 11.12.2015..
 */
public class Neuron implements INeuron {
    LinkedList<Double> weights = new LinkedList<>();
    List<INeuron> parents = new LinkedList<>();
    List<INeuron> children = new LinkedList<>();
    private boolean first = false;
    double sum = 0;
 //   double net = 0;

    double error = 0;
    double ressult = 0;
    private double derivation;


    public Neuron(List<INeuron> parents){
        this.parents = parents;
        int parentSize = parents.size();
        if(parentSize == 0){
            parentSize = 1;
        }
        this.weights = Neuron.initWeights(parentSize+1,1);
        Random rand = new Random();
   //     this.net = 8*rand.nextDouble()-4;

    }
    public Neuron(List<INeuron> parents,boolean first){
        this.parents = parents;
        int parentSize = parents.size();
        if(parentSize == 0){
            parentSize = 1;
        }
        this.first = first;
        this.weights = Neuron.initWeights(parentSize+1,1);
        Random rand = new Random();
        //     this.net = 8*rand.nextDouble()-4;

    }
    public Neuron(){
        this.weights = Neuron.initWeights(1,1);
    }


    @Override
    public double calculate(List<Double> inputs) {
        if(first){
            return inputs.get(0);
        }
        sum = 0;

        for (int i = 0; i<inputs.size();i++){

            sum += inputs.get(i)*weights.get(i);
        }
        sum +=weights.get(inputs.size());
        this.sum += sum;
        this.ressult = activate(sum);
        this.derivation = sum*(1-sum);
        return this.ressult;
    }

    @Override
    public void addChildren(List<INeuron> children) {
        this.children = children;
    }

    @Override
    public double activate(double sum) {
        return 1.0/(1.0+Math.pow(Math.E,-sum));
    }

    private static LinkedList<Double> initWeights(int size,double b){
        LinkedList<Double> weights = new LinkedList<>();
        Random rand = new Random();
        for ( int i = 0; i<size; i++){
            double weight = (rand.nextDouble()*2*b)-b;
            weights.add(weight);
        }
        return  weights;
    }

    @Override
    public double getError() {
        return error;
    }

    @Override
    public void setError(double error) {
        this.error = error;
    }

    @Override
    public void calculateError() {
        for (int i = 0; i< children.size(); i++){
            INeuron child = children.get(i);
            double local = this.error*this.weights.get(i);
            child.setError(child.getError()+local);
        }

    }

    @Override
    public void backProp(double faktor) {
        if(children.size()==0){
            for (int i = 0; i<this.weights.size()-1;i++){
                Double weight = weights.get(i);

                weight += this.derivation*faktor*this.error;
                weights.set(i,weight);
            }
            double  weight = weights.get(weights.size()-1);
            weight += this.derivation*faktor*this.error;
            weights.set(weights.size()-1,weight);
        }

    }

    @Override
    public double getWeight(int i) {
        return this.weights.get(i);
    }

    @Override
    public double addToWeight(int i, double sum) {
        if(this.first){
            return 1;
        }
        this.weights.set(i,weights.get(i)+sum);
        return this.getWeight(i);
    }

    @Override
    public String toString() {
        String out = "[ ";
        for (double w :weights){
            out += " I "+w ;
        }
        out+="]";
        return out;
    }
}
