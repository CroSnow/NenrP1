package fer.hr.nenr.GenNeuronNetwork.MutAndCros;

import java.util.List;

/**
 * Created by Ivan on 23.1.2016..
 */
public interface NeuronMutator {

    List<Double> mutate(List<Double> weights);


}
