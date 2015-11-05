package fer.hr.nenr.DomainPack;

import java.util.Iterator;

/**
 * Created by Ivan on 16.10.2015..
 */
public class SimpleDomain extends Domain {
    private int first;
    private int last;
    public SimpleDomain(int first, int last){
        super();
        this.first=first;
        this.last=last;

    }
    @Override
    public int getCardinality() {
        return Math.abs(last-first);
    }

    @Override
    public IDomain getComponent(int index) {

        return null;
    }

    @Override
    public int getNumberOfComponents() {
        return 0;
    }

    @Override
    public Iterator<DomainElement> iterator() {
        Iterator<DomainElement> it = new Iterator<DomainElement>() {

            private int currentIndex = getFirst();

            @Override
            public boolean hasNext() {
                return currentIndex < getLast();
            }

            @Override
            public DomainElement next() {
                return  DomainElement.of(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;

    }

    public int getLast() {
        return last;
    }

    public int getFirst() {
        return first;
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
