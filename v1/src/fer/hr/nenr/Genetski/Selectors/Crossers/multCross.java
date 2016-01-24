package fer.hr.nenr.Genetski.Selectors.Crossers;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 3.1.2016..
 */
public class multCross implements ICross {
    @Override
    public IGene cross(IGene first, IGene second) {
        List<Double> firstWeights=first.getWeights();
        List<Double> secondWeights=second.getWeights();
        List<Double> newWeights=new LinkedList<>();
        for(int i=0;i<firstWeights.size();i++){
            newWeights.add((Math.sqrt(Math.abs(firstWeights.get(i)*secondWeights.get(i)))*Math.signum(firstWeights.get(i)+secondWeights.get(i))));
        }
        return first.newGene(newWeights);
    }
}
