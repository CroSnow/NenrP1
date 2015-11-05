package fer.hr.nenr.DomainPack;


import java.util.Arrays;
import java.util.LinkedList;

/**
 * Created by Ivan on 16.10.2015..
 */
public class DomainElement {
    private int[] values;
    DomainElement(int[] values){
        this.values=values.clone();
    }
    public int getNumberOfComponents(){
        return this.values.length;
    }
    public int getComponentValue(int index){
        if (index >= this.getNumberOfComponents()||index < 0){
            System.out.println("Wrong index for index "+index);
            return -1;
        }
        return this.values[index];

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DomainElement that = (DomainElement) o;

        return Arrays.equals(values, that.values);

    }

    @Override
    public int hashCode() {
        return values != null ? Arrays.hashCode(values) : 0;
    }

    @Override
    public String toString(){
        if (this.getNumberOfComponents() == 1) return  Integer.toString(this.values[0]);
        String line = "(";
        for (int i = 0; i<this.getNumberOfComponents();i++){
            if (i!=0){
                line = line+",";
            }
            line += Integer.toString(this.getComponentValue(i));
        }
        line = line +")";

        return line;

    }

    public  static DomainElement of(int... values){
        return new DomainElement(values);
    }
    public static DomainElement join(DomainElement... elements){
        LinkedList<Integer> values = new LinkedList<Integer>();
        for (DomainElement el: elements){
            for (int i = el.getNumberOfComponents()-1; i>=0;i--){
                values.add(el.getComponentValue(i));
            }

        }
        int[] array = new int[values.size()];
        for (int i = 0; i < values.size(); i++) {
            array[i] = values.get(i); // Watch out for NullPointerExceptions!
        }
        return  DomainElement.of(array);
    }
}
