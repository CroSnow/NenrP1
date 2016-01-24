package fer.hr.nenr.GenNeuronNetwork.MutAndCros;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 23.1.2016..
 */
public class MeanCross implements NeuronCross{
    @Override
    public List<Double> cross(List<Double> second, List<Double> first) {
        List<Double> outs = new LinkedList<>();
        for(int i =0; i<first.size();i++){
            outs.add((first.get(i)+second.get(i))/2.0);
        }
        return outs;
    }
}
