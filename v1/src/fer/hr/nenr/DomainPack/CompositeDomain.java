package fer.hr.nenr.DomainPack;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 16.10.2015..
 */
public class CompositeDomain extends Domain {
    private IDomain[] domains;
    public CompositeDomain(IDomain[] domains){
        super();
        this.domains=domains;
    }
    @Override
    public int getCardinality() {
        int card = 1;
        for (IDomain dom : domains){
            card*=dom.getCardinality();
        }
        return card;
    }

    @Override
    public IDomain getComponent(int index) {
        if( index >= this.getNumberOfComponents() || index<0){
            System.out.println("Index wrong format for composite, index = "+index);
            return null;
        }
        return this.domains[index];
    }

    @Override
    public int getNumberOfComponents() {
        return this.domains.length;
    }

    @Override
    public Iterator iterator() {
        Iterator<DomainElement> it = new Iterator<DomainElement>() {
            private boolean firstUse = true;
            private int currentIndex = 0;
            private int card = getCardinality();
            private List<Iterator<DomainElement>> iterators ;
            private List<DomainElement> elements;
            private int curentIt = 0;
            private DomainElement current;


            private void init(){
                iterators = new LinkedList<Iterator<DomainElement>>();
                elements = new LinkedList<DomainElement>();

                for (IDomain dom : domains){

                    iterators.add(dom.iterator());
                    elements.add(iterators.get(iterators.size()-1).next());


                }
                DomainElement[] array = new DomainElement[elements.size()];
                for (int i = 0; i < elements.size(); i++) {
                    array[i] = elements.get(i); // Watch out for NullPointerExceptions!
                }
                this.current = DomainElement.join(array);

                curentIt=iterators.size()-1;
            }

            private DomainElement getCurrent(){
                return current;
            }
            private void resetIterators(int index){

                for (int i  = index ; i < iterators.size() ;i++){

                    iterators.set(i, domains[i].iterator());
                    elements.set(i, iterators.get(i).next());

                }
            }

            private boolean calculateNext(){
                if(curentIt>=iterators.size()){
                    return false;
                }
                if(iterators.get(curentIt).hasNext()){
                    elements.set(curentIt,iterators.get(curentIt).next());
                    DomainElement[] array = new DomainElement[elements.size()];
                    for (int i = 0; i < elements.size(); i++) {
                        array[i] = elements.get(i); // Watch out for NullPointerExceptions!
                    }
                    this.current = DomainElement.join(array);
                    return true;
                }
                else{
                    this.resetIterators(curentIt);

                    if(curentIt>0){
                        curentIt--;
                        calculateNext();
                    }
                    if(curentIt<iterators.size()) {
                        curentIt++;
                    }


                }
                return true;
            }

            @Override
            public boolean hasNext() {

                return (currentIndex < card);
            }

            @Override
            public DomainElement next() {
                if (firstUse){
                    this.init();
                    firstUse = false;

                }
                else{
                    this.calculateNext();
                }

                currentIndex++;
                return  this.getCurrent();
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
