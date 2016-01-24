package fer.hr.nenr.GenNeuronNetwork.MutAndCros;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 24.1.2016..
 */
public class WeightetCross implements NeuronCross {
    @Override
    public List<Double> cross(List<Double> second, List<Double> first) {
        List<Double> outs = new LinkedList<>();
        Random rand = new Random();
        Double a;
        for(int i =0; i<first.size();i++){
            a = rand.nextDouble();
            outs.add((a)*first.get(i)+(1-a)*second.get(i));
        }
        return outs;
    }
}
