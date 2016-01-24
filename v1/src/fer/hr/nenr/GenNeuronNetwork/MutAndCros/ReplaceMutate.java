package fer.hr.nenr.GenNeuronNetwork.MutAndCros;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 23.1.2016..
 */
public class ReplaceMutate implements NeuronMutator{

    private final double chance;
    private final double var;

    public ReplaceMutate(double chance, double var){
        this.chance = chance;
        this.var = var;
    }

    @Override
    public List<Double> mutate(List<Double> weights) {
        Random rand = new Random();
        List<Double> outs = new LinkedList<Double>();
        for (double w :weights){
            double plus = w;
            double gotChance = rand.nextDouble();
            if(gotChance<chance){
                plus = rand.nextGaussian()*this.var;
            }
            outs.add(plus);
        }
        return outs;
    }
}