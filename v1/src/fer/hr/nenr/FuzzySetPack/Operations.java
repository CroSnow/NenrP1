package fer.hr.nenr.FuzzySetPack;

import fer.hr.nenr.DomainPack.Domain;
import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IUnaryFunction;

import java.util.Iterator;

/**
 * Created by Ivan on 18.10.2015..
 */
public class Operations {
    private static IBinaryFunction zadehAND = new IBinaryFunction() {
        @Override
        public double valueAt(double x, double y) {
            if(y>x){
                return x;
            }
            return y;
        }
    };
    private static IBinaryFunction zadehOR = new IBinaryFunction() {
        @Override
        public double valueAt(double x, double y) {
            if (x>y){
                return  x;
            }
            return y;
        }
    };
    private static IUnaryFunction zadehNOT = new IUnaryFunction() {
        @Override
        public double valueAt(double d) {
            return 1-d;
        }
    };

    public static IFuzzySet unaryOperation(IFuzzySet set,IUnaryFunction function){
        IDomain domain = set.getDomain();
        int card = domain.getCardinality();
        MutableFuzzySet neoSet = new MutableFuzzySet(domain);
        Iterator<DomainElement> iterator = domain.iterator();
        while (iterator.hasNext()){
            DomainElement element = iterator.next();

            neoSet.set(element,function.valueAt(set.getValueAt(element)));
        }
        return  neoSet;

    }

    public static IFuzzySet binaryOperation(IFuzzySet set1,IFuzzySet set2, IBinaryFunction function){
        IDomain domain = set1.getDomain();

        int card = domain.getCardinality();
        MutableFuzzySet neoSet = new MutableFuzzySet(domain);
        Iterator<DomainElement> iterator = domain.iterator();
        while (iterator.hasNext()){
            DomainElement element = iterator.next();

            neoSet.set(element,function.valueAt(set1.getValueAt(element),set2.getValueAt(element)));
        }
        return  neoSet;
    }
    public static IUnaryFunction zadehNot(){
        return  Operations.zadehNOT;
    }
    public static IBinaryFunction zadehAnd(){
        return  Operations.zadehAND;
    }
    public static IBinaryFunction zadehOr(){
        return  Operations.zadehOR;
    }

    public static IBinaryFunction  hamacherTNorm(double value){
        return new IBinaryFunction() {
            @Override
            public double valueAt(double x, double y) {
                if (x*y<10E-9) {
                    return 0;
                }
                else {
                    return (x*y)/(value+(1-value)*(x+y-x*y));
                }
            }
        };
    }
    public static IBinaryFunction hamacherSNorm(double value){
        return new IBinaryFunction() {
            @Override
            public double valueAt(double x, double y) {
                double check = 1-(1-value)*x*y;
                if(check<10E-9){
                    return 1.0;
                }
                return (x+y-(2-value)*x*y);
            }
        };
    }

}
