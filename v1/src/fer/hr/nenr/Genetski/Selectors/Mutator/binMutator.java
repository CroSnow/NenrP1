package fer.hr.nenr.Genetski.Selectors.Mutator;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by Ivan on 3.1.2016..
 */
public class binMutator implements IMutator {
    private final double chance;
    private int precision;

    public binMutator(double chance,int precision) {
        this.chance = chance;
        this.precision = precision;
    }
    @Override
    public IGene mutate(IGene old) {
        List<Double> weights= old.getWeights();
        List<Double> newWeights= new LinkedList<>();
        Random rand = new Random();
        for(double weight:weights){
            double newWeight=weight;
            double mutChance= rand.nextDouble();
            if( mutChance<this.chance){
                newWeight = this.binMutate(newWeight);
            }
            newWeights.add(newWeight);
        }
        return old.newGene(newWeights);
    }

    private double binMutate(Double weight){
        String newW = "";
        BigDecimal num = new BigDecimal(weight);
        String oldW = Long.toBinaryString(Double.doubleToRawLongBits(num.setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue()));
        Random rand = new Random();
        for (int i = 0; i< oldW.length();i++) {
            if(rand.nextDouble()>chance){
                newW += oldW.charAt(i);
            }
            else{
                if('0' == oldW.charAt(i)){
                    newW+= '1';
                }else{
                    newW+= '0';
                }
            }
        }
        return Double.longBitsToDouble(new BigInteger(newW, 2).longValue());

    }
}
