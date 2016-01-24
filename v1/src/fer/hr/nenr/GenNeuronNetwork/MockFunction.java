package fer.hr.nenr.GenNeuronNetwork;

import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public class MockFunction implements NeuronFunction {
    private int place;
    public MockFunction(int place){
        this.place = place;
    }


    @Override
    public int getWeightCount() {
        return 0;
    }

    @Override
    public double calculate(List<Double> inputs, List<Double> weigts) {
        return inputs.get(place);
    }
}
