package fer.hr.nenr.DomainPack;

import java.util.Iterator;

/**
 * Created by Ivan on 16.10.2015..
 */
public abstract class Domain implements IDomain {
    public Domain(){

    }
    public int indexOfElement(DomainElement element){
        int i =0;
        for (Iterator<DomainElement> iterator =  this.iterator();iterator.hasNext();){
            if (iterator.next().equals(element)){
                return i;
            }
            i++;

        }
        System.out.println("Element Not Found:"+element);
        return  -1;

    }

    public DomainElement elementForIndex(int index){

        if ((index <0)|| index>=this.getCardinality()){
            System.out.println("Wrong index for argument "+index);
            return null;
        }
        int i = 0;

        for (Iterator<DomainElement> iterator =  this.iterator();iterator.hasNext();iterator.next()){
            if (i == index){
                return iterator.next();
            }
            i++;

        }
        return  null;


    }
    public static IDomain intRange(int first, int last){
        return new SimpleDomain(first,last);
    }

    public static IDomain combine(IDomain first, IDomain second){
        IDomain[] domains = new IDomain[2];
        domains[0]=first;
        domains[1]=second;
        return new CompositeDomain(domains);


    }

    public String toString(){
        Iterator<DomainElement> it = iterator();
        String out ="{";
        while(it.hasNext()){
            out+=it.next();
            if (it.hasNext()){
                out+=", ";
            }
        }
        out +="}";
        return out;
    }

}
