package fer.hr.nenr.GenNeuronNetwork.MutAndCros;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 23.1.2016..
 */
public class SinglePointCross implements NeuronCross {
    @Override
    public List<Double> cross(List<Double> second, List<Double> first) {

        List<Double> outs = new LinkedList<>();
        for(int i = 0; i<first.size(); i++){

            if(i*2<first.size()){
                outs.add(first.get(i));
            }else{
                outs.add(second.get(i));
            }
        }
        return outs;

    }
}
