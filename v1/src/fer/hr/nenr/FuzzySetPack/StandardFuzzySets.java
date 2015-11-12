package fer.hr.nenr.FuzzySetPack;

import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IIntUnaryFunction;

/**
 * Created by Ivan on 18.10.2015..
 */
public class StandardFuzzySets {
    public StandardFuzzySets(){}

    public static IIntUnaryFunction lFunction(int first, int second ){
        return new IIntUnaryFunction() {
            double l=Math.abs(second-first);
            @Override
            public double valueAt(int index) {
                if(index<first){
                    return 1.0;
                }
                if(index<second){
                    double diff = second-index;
                    return diff/l;
                }
                return 0.0;
            }
        };

    }
    public static IIntUnaryFunction gammaFunction(int first, int second ){
        return new IIntUnaryFunction() {
            double l=Math.abs(second-first);
            @Override
            public double valueAt(int index) {
                if(index<first){
                    return 0.0;
                }
                if(index<second){
                    double diff = index-first;
                    return diff/l;
                }
                return 1.0;
            }
        };
    }
    public static IIntUnaryFunction lambdaFunction(int low, int peek , int high){
        return new IIntUnaryFunction(){
            double left = Math.abs(peek -low);
            double right = Math.abs(peek -high);
            @Override
            public double valueAt(int index) {
                if(peek>index){
                    double diff = index-low;
                    if(diff>0){
                        return diff/left;
                    }
                    return 0;
                }else{
                    double diff = high-index;
                    if(diff>0){
                        return diff/right;
                    }
                }

                return 0;
            }
        };
    }

    public static IFuzzySet reverseSet (IFuzzySet set){
        MutableFuzzySet reverse= new MutableFuzzySet(set.getDomain());
        IDomain domain= set.getDomain();
        for (DomainElement element:domain){
            reverse.set(element,set.getValueAt(domain.elementForIndex(domain.getCardinality()-domain.indexOfElement(element)-1)));
        }
        return reverse;
    }


}
