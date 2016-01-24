package fer.hr.nenr.GenNeuronNetwork;

import fer.hr.nenr.Genetski.Functions.IFunction;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 21.1.2016..
 */
public class NeuronNetwork {
    private List<List<Double>> results = new LinkedList<>();
    private List<Double> weights = new LinkedList<>();
    private List<List<Neuron>> neurons = new LinkedList<>();
    private static double LOWER_LIMIT = -4;
    private static double UPPER_LIMIT= 4;
    private double error = 0;
    private double fittnes = 0;
    private int weightCnt;
    private List<Integer> dimension;

    public NeuronNetwork(List<Integer> dimension){
        int prevDimensions = dimension.get(0);
        List<Neuron> layer = new LinkedList<>();
        for(int i = 0;i<prevDimensions;i++){
            NeuronFunction fun = new MockFunction(i);
            layer.add(new Neuron(fun));
        }
        this.neurons.add(layer);
        this.dimension = dimension;

        layer = new LinkedList<>();
        int layerSize = dimension.get(1);
        NeuronFunction fun = new Tip1Function(prevDimensions);
        for (int i = 0;i <layerSize;i++){
            layer.add(new Neuron(fun));
        }
        prevDimensions = layerSize;
        this.neurons.add(layer);

        layer = new LinkedList<>();
        for(int i = 2 ; i<dimension.size();i++){
            layerSize = dimension.get(i);
            layer = new LinkedList<>();
            fun = new Tip2Function(prevDimensions);
            for(int l = 0;l<layerSize;l++){
                layer.add(new Neuron(fun));
            }
            this.neurons.add(layer);
            prevDimensions = layerSize;
        }
        this.calculateWeightCount();
        this.initRandomWeigts();

    }
    private void calculateWeightCount(){
        this.weightCnt = 0;
        for (List<Neuron> layer :this.neurons){
            for(Neuron neuron :layer){
                this.weightCnt += neuron.getWeightCount();
            }
        }
    }

    private void initRandomWeigts(){
        Random rand = new Random();
        for (int i = 0; i<this.weightCnt;i++){
            this.weights.add(rand.nextDouble()*(UPPER_LIMIT-LOWER_LIMIT)+LOWER_LIMIT);
        }
        this.applyWeights();

    }
    private void applyWeights(){
        int weigtPos = 0;
        for(List<Neuron> layer:neurons){
            for(Neuron neuron :layer){
                neuron.setWeights(this.weights.subList(weigtPos,weigtPos+neuron.getWeightCount()));
                weigtPos+=neuron.getWeightCount();
            }
        }

    }
    public List<Double> calculateForLayer(List<Double> inputs){
        results = new LinkedList<>();
        results.add(inputs);
        List<Double>  outs = new LinkedList<>();
        List<Double> ins = new LinkedList<>(inputs);
        for(List<Neuron> layer :neurons){
            outs = new LinkedList<>();
            for (Neuron n :layer){
                outs.add(n.calculate(ins));
            }
            results.add(outs);
            ins = new LinkedList<>(outs);
        }
        return outs;
    }

    public void calcError(Dataset db){
        int size = db.getSize();
        double sum = 0;
        for (int i = 0; i <size;i++){
            List<Double> ins = db.getNextIn();
            List<Double> realOut = db.getNextOut();
            db.pointerPlusPlus();
            List<Double> myOut = this.calculateForLayer(ins);
            for(int j = 0; j<realOut.size();j++){
                sum+=Math.pow(myOut.get(j)-realOut.get(j),2);
            }
        }
        this.error = sum/size;
        this.fittnes = 1.0/error;
    }



    public int ParametersNeeded(){
        return this.weightCnt;
    }

    public List<List<Double>> getResults() {
        return results;
    }

    public void setResults(List<List<Double>> results) {
        this.results = results;
    }

    public List<Double> getWeights() {
        return weights;
    }

    public void setWeights(List<Double> weights) {
        this.weights = weights;
        this.applyWeights();
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    public double getFittnes() {
        return fittnes;
    }

    public void setFittnes(double fittnes) {
        this.fittnes = fittnes;
    }

    public int getWeightCnt() {
        return weightCnt;
    }

    public void setWeightCnt(int weightCnt) {
        this.weightCnt = weightCnt;
    }

    public String toString(){
        String out = "[";
        for(int i = 0; i < this.weightCnt-1;i++){
            out += this.weights.get(i).toString()+",";
        }
        out += this.weights.get(this.weightCnt-1).toString()+"]";
        return out;
    }

    public NeuronNetwork copy(){
        NeuronNetwork copied = new NeuronNetwork(dimension);
        copied.setWeights(this.weights);
        copied.setError(this.error);
        copied.setFittnes(this.fittnes);
        return copied;
    }
}
