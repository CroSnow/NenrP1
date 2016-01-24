package fer.hr.nenr.Genetski.Selectors.Crossers;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public abstract class binCross implements ICross {
    private int precision;

    public binCross(int precision){
        this.precision = precision;
    }
    @Override
    public IGene cross(IGene first, IGene second) {
        Long.toBinaryString(Double.doubleToRawLongBits(4));
        List<Double> firstWeights=first.getWeights();
        List<Double> secondWeights=second.getWeights();
        List<Double> newWeights=new LinkedList<>();
        for(int i=0;i<firstWeights.size();i++){

            newWeights.add(this.newWeight(
                    Long.toBinaryString(Double.doubleToRawLongBits( new BigDecimal(firstWeights.get(i)).setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue())),
                    Long.toBinaryString(Double.doubleToRawLongBits(new BigDecimal(secondWeights.get(i)).setScale(precision, BigDecimal.ROUND_HALF_UP).doubleValue()))));
        }
        return first.newGene(newWeights);
    }

    abstract double newWeight(String first, String second);
}
