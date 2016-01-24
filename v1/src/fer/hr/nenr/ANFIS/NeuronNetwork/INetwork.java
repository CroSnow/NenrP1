package fer.hr.nenr.ANFIS.NeuronNetwork;

import fer.hr.nenr.ANFIS.Learner.ILearner;

import java.util.HashMap;
import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public interface INetwork {
    void learn(HashMap<List<Double>, Integer> data, ILearner learner);
    void learn2(HashMap<List<Double>, List<Double>> data, ILearner learner);
    void resetErrors();
    void singleLearn(List<Double> data, List<Double> results);
    void backProp();
    List<Double> iteration(List<Double> vektor);
    int test(List<Double> vektor);
    List<List<INeuron>> getNeurons();
    List<Integer> getDimension();
    double getTotalError();
    List<List<Double>> apsolute(List<Double> vektor);
    void addToWeight(int layer, int i, int j, double toAdd);
    double getWeight(int layer, int i, int j);
}
