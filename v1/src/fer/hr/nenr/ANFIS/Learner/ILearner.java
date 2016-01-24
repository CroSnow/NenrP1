package fer.hr.nenr.ANFIS.Learner;

import fer.hr.nenr.ANFIS.NeuronNetwork.INetwork;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public interface ILearner {

    public void learnNetwork(HashMap<List<Double>, Integer> data, INetwork network);
    public void learnNetwork2(HashMap<List<Double>, List<Double>> data, INetwork network);
}
