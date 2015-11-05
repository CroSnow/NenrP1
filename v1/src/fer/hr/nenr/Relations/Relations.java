package fer.hr.nenr.Relations;

import fer.hr.nenr.DomainPack.Domain;
import fer.hr.nenr.DomainPack.DomainElement;
import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.FuzzySetPack.MutableFuzzySet;

import java.util.Iterator;

/**
 * Created by Ivan on 27.10.2015..
 */
public class Relations {
    ///Radi se o binarnim relacijama.
    ///u(x,y)=u(y,x)
    public static boolean isSymmetric(IFuzzySet relation){
        if(relation.getDomain().getNumberOfComponents()!=2){
            System.out.println("In is Symmetric, relation is not binary");
            return  false;
        }
        IDomain mainDomain = relation.getDomain();
        IDomain xDomain= mainDomain.getComponent(0);
        IDomain yDomain= mainDomain.getComponent(1);
        Iterator<DomainElement> itX = xDomain.iterator();
        while (itX.hasNext()){
            DomainElement xElement=itX.next();
            Iterator<DomainElement> itY= yDomain.iterator();
            while (itY.hasNext()){
                DomainElement yElement = itY.next();
                DomainElement XY = DomainElement.join(xElement, yElement);
                DomainElement YX = DomainElement.join(yElement,xElement);
                if(Math.abs(relation.getValueAt(XY)-relation.getValueAt(YX))>10E-9){
                    return false;
                }
            }
        }

        return true;
    }
    //u(x,x)=1
    public static boolean isReflexive(IFuzzySet relation){
        if(relation.getDomain().getNumberOfComponents()!=2){
            System.out.println("In is Reflexive, relation is not binary");
            return  false;
        }
        IDomain mainDomain = relation.getDomain();
        IDomain xDomain= mainDomain.getComponent(0);
        IDomain yDomain= mainDomain.getComponent(1);

        Iterator<DomainElement> itX = xDomain.iterator();
        while (itX.hasNext()){
            DomainElement xElement=itX.next();
            if (yDomain.indexOfElement(xElement)==-1){
                return  false;
            }

            DomainElement XX = DomainElement.join(xElement, xElement);
            if(Math.abs(relation.getValueAt(XX)-1)>10E-9){
                return false;
            }

        }

        return true;
    }

    public static boolean isMaxMinTransitive(IFuzzySet relation){
        if(!Relations.isUtimesURelation(relation)){
            System.out.println("Is not UxU");
            return  false;
        }
        IDomain domain = relation.getDomain();
        IDomain subDomain = domain.getComponent(0);
        Iterator<DomainElement>uIT = subDomain.iterator();
        while (uIT.hasNext()){
            Iterator<DomainElement> vIT= subDomain.iterator();
            DomainElement u = uIT.next();
            while (vIT.hasNext()){
                DomainElement v = vIT.next();
                double Ruv = relation.getValueAt(DomainElement.join(u, v));
                Iterator<DomainElement> wIT= subDomain.iterator();
                double max = 0;
                while(wIT.hasNext()){
                    DomainElement w = wIT.next();
                    double Ruw = relation.getValueAt(DomainElement.join(u,w));
                    double Rwv = relation.getValueAt(DomainElement.join(w,v));
                    double min = Ruw;
                    if(Rwv<min){
                        min=Rwv;

                    }
                    if(max<min){
                        max=min ;
                    }
                }
                if (Ruv<max){
                    return false;
                }

            }
        }
        return true;


    }

    public static IFuzzySet compositionOfBinaryRelations(IFuzzySet first, IFuzzySet second){

        IDomain aDomain = first.getDomain();
        IDomain bDomain = second.getDomain();
        IDomain uDomain = aDomain.getComponent(0);
        IDomain wDomain = aDomain.getComponent(1);
        IDomain vDomain = bDomain.getComponent(1);
        MutableFuzzySet rOut = new MutableFuzzySet(Domain.combine(uDomain,vDomain));

        Iterator<DomainElement>uIT = uDomain.iterator();
        while (uIT.hasNext()){
            Iterator<DomainElement> vIT= vDomain.iterator();
            DomainElement u = uIT.next();
            while (vIT.hasNext()){
                DomainElement v = vIT.next();

                Iterator<DomainElement> wIT= wDomain.iterator();
                double max = 0;
                while(wIT.hasNext()){
                    DomainElement w = wIT.next();
                    double Ruw = first.getValueAt(DomainElement.join(u,w));
                    double Rwv = second.getValueAt(DomainElement.join(w,v));
                    double min = Ruw;
                    if(Rwv<min){
                        min=Rwv;

                    }
                    if(max<min){
                        max=min ;
                    }
                }
                rOut.set(DomainElement.join(u, v), max);

            }
        }
        return rOut;
    }

    public static boolean isFuzzyEquivalence(IFuzzySet relation){
        return  isUtimesURelation(relation)
                &isReflexive(relation)
                &isSymmetric(relation)
                &isMaxMinTransitive(relation);

    }

    public static boolean isUtimesURelation(IFuzzySet relation){
        IDomain domain = relation.getDomain();
        if (domain.getNumberOfComponents()!=2){
            return false;
        }
        IDomain xDom = domain.getComponent(0);
        IDomain yDom = domain.getComponent(1);

        Iterator<DomainElement> xIt = xDom.iterator();
        while(xIt.hasNext()){
            DomainElement element = xIt.next();
            if(yDom.indexOfElement(element)<0){
                return  false;
            }
        }
        Iterator<DomainElement> yIt = yDom.iterator();
        while(yIt.hasNext()){
            DomainElement element = yIt.next();
            if(xDom.indexOfElement(element)<0){
                return  false;
            }
        }
        return  true;


    }

}
