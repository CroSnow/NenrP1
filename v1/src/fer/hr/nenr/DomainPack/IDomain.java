package fer.hr.nenr.DomainPack;

/**
 * Created by Ivan on 16.10.2015..
 */
public interface IDomain extends Iterable<DomainElement> {
    public int getCardinality();
    public IDomain getComponent(int index);
    public int getNumberOfComponents();
    public int indexOfElement(DomainElement el);
    public DomainElement elementForIndex(int index);

}
