package fer.hr.nenr.GenNeuronNetwork.MutAndCros;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 23.1.2016..
 */
public class RandomCross implements NeuronCross{
    @Override
    public List<Double> cross(List<Double> second, List<Double> first) {
        Random rand = new Random();
        List<Double> outs = new LinkedList<>();
        for(int i = 0; i<first.size(); i++){
            double chose = rand.nextDouble();
            if(chose<0.5){
                outs.add(first.get(i));
            }else{
                outs.add(second.get(i));
            }
        }
        return outs;
    }
}
