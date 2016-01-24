package fer.hr.nenr.GenNeuronNetwork;

import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public class Tip1Function implements NeuronFunction {
    private int weightCount = 0;
    public Tip1Function(int prevSize){
        this.weightCount = prevSize*2;
    }
    @Override
    public int  getWeightCount() {
        return this.weightCount;
    }

    @Override
    public double calculate(List<Double> inputs, List<Double> weigts) {
        double sum = 0;
        for (int i = 0; i <inputs.size();i++){
            sum +=Math.abs((inputs.get(i)-weigts.get(i*2))/weigts.get(i*2+1));
        }
        sum += 1;
        return 1.0/sum;
    }
}
