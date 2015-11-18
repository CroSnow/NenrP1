package fer.hr.nenr.Genetski.Selectors.Crossers;

import fer.hr.nenr.Genetski.Genes.IGene;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 16.11.2015..
 */
public class meanCros implements  ICross {
    @Override
    public IGene cross(IGene first, IGene second) {
        List<Double> firstWeights=first.getWeights();
        List<Double> secondWeights=second.getWeights();
        List<Double> newWeights=new LinkedList<>();
        for(int i=0;i<firstWeights.size();i++){
            newWeights.add((firstWeights.get(i)+secondWeights.get(i))/2.0);
        }
        return first.newGene(newWeights);
    }
}
