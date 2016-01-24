package fer.hr.nenr.ANFIS.NeuronNetwork;

import fer.hr.nenr.ANFIS.Learner.ILearner;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public class Network implements INetwork {
    private List<Integer> dimension = new LinkedList<>();
    private List<List<INeuron>> neurons = new LinkedList<>();
    List<INeuron> old = new LinkedList<>();
    public Network (List<Integer> dimensions){
        this.dimension = dimensions;
        List<INeuron> neuron = new LinkedList<>();
        boolean first = true;
        for (int size : dimensions) {
            neuron = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                neuron.add(new Neuron(old,first));
            }
            first = false;


            for (INeuron oldNeuron : old) {
                oldNeuron.addChildren(neuron);
            }
            old = neuron;
            this.neurons.add(neuron);
        }
    }
    public void learn(HashMap<List<Double>,Integer> data, ILearner learner){
        learner.learnNetwork(data,this);

    }
    public void learn2(HashMap<List<Double>,List<Double>> data, ILearner learner){
        learner.learnNetwork2(data,this);

    }

    @Override
    public void resetErrors() {
        for (List<INeuron> subList:neurons){
            for(INeuron neuron:subList){
                neuron.setError(0);
            }
        }

    }

    @Override
    public void singleLearn(List<Double> data, List<Double> results) {
        List<Double> outs = this.iteration(data);
        List<INeuron> last = neurons.get(neurons.size()-1);
        for(int i = 0;i<outs.size();i++){
            INeuron changing = last.get(i);
            double localError = Math.pow(results.get(i)-outs.get(i),2)/2.0;
            changing.setError(changing.getError()+localError);
        }
        for (int i = outs.size()-1; i>0; i--){
            List<INeuron> changing = neurons.get(i);
            for(INeuron neuron :changing){
                neuron.calculateError();
            }
        }

    }

    @Override
    public void backProp() {

    }

    @Override
    public List<Double> iteration(List<Double> vektor) {
        List<Double> inputs = new LinkedList<Double>(vektor);
        List<Double> results = new LinkedList<Double>();
        boolean first = true;
        for (List<INeuron> neuronList :neurons){
            int i = 0;
            results = new LinkedList<Double>();
            for( INeuron neuron:neuronList){
                if (first){
                    List<Double>firstInputs =new LinkedList<>();
                    firstInputs.add(inputs.get(i));
                    i++;
                    Double result = neuron.calculate(firstInputs);
                    results.add(result);
                }else {
                    Double result = neuron.calculate(inputs);
                    results.add(result);
                }

            }
            first = false;
            inputs = results;
        }

        return results;

    }

    @Override
    public int test(List<Double> vektor) {
        List<Double> inputs = new LinkedList<Double>(vektor);
        List<Double> results = new LinkedList<Double>();
        boolean first = true;
        for (List<INeuron> neuronList :neurons){
            results = new LinkedList<Double>();
            int i = 0;
            for( INeuron neuron:neuronList){
                if (first){
                    List<Double>firstInputs =new LinkedList<>();
                    firstInputs.add(inputs.get(i));
                    i++;
                    Double result = neuron.calculate(firstInputs);
                    results.add(result);
                }else {
                    Double result = neuron.calculate(inputs);
                    results.add(result);
                }
            }
            first = false;
            inputs = results;
        }
        int maxI = 0;
        Double max  = results.get(0);
        for (int i = 1;i<results.size();i++){
            if (max<results.get(i)){
                max = results.get(i);
                maxI = i;
            }
        }
        return maxI;
    }

    public List<Integer> getDimension() {
        return dimension;
    }

    public List<List<INeuron>> getNeurons() {
        return neurons;
    }
    public double getTotalError(){
        List<INeuron> outs = this.neurons.get(neurons.size()-1);
        double sum = 0;
        for (INeuron neuron : outs){
            sum += neuron.getError();
        }
        return sum;

    }

    @Override
    public List<List<Double>> apsolute(List<Double> vektor) {
        List<Double> inputs = new LinkedList<Double>(vektor);
        List<Double> results = new LinkedList<Double>();
        boolean first = true;
        List<List<Double>> returns = new LinkedList<>();
        for (List<INeuron> neuronList :neurons){

            returns.add(inputs);
            results = new LinkedList<Double>();
            int i = 0;
            for( INeuron neuron:neuronList){
                if (first){
                    List<Double>firstInputs =new LinkedList<>();
                    firstInputs.add(inputs.get(i));
                    i++;
                    Double result = neuron.calculate(firstInputs);
                    results.add(result);
                }else {
                    Double result = neuron.calculate(inputs);
                    results.add(result);
                }
            }
            first = false;
            inputs = results;

        }
        returns.add(results);

        return returns;
    }

    @Override
    public void addToWeight(int layer ,int i, int j, double toAdd) {
        INeuron neuron = this.neurons.get(layer).get(i);
        neuron.addToWeight(j,toAdd);
    }
    public double getWeight(int layer, int i , int j){
        INeuron neuron = this.neurons.get(layer).get(i);
        return neuron.getWeight(j);
    }

    @Override
    public String toString() {
        String out = "";
        for(int layer = 0; layer < this.neurons.size(); layer++){
            out += "layer = "+layer+"\n";
            for ( INeuron neuron :this.neurons.get(layer)){
                out +=neuron.toString()+"\n";
            }
        }
        return out;
    }
}
