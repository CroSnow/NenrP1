package fer.hr.nenr.GenNeuronNetwork;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public class Dataset {
    private List<List<Double>> inputs = new LinkedList<>();
    private List<List<Double>> outs = new LinkedList<>();
    private int pointer = 0;
    private int size = 0;
    public Dataset(){

    }

    public List<List<Double>> getInputs() {
        return inputs;
    }

    public void setInputsAndOutputs(List<List<Double>> inputs,List<List<Double>>outs) {
        this.inputs = inputs;
        this.outs = outs;
        this.size = outs.size();
    }

    public List<List<Double>> getOuts() {
        return outs;
    }

    public void setOuts(List<List<Double>> outs) {
        this.outs = outs;
    }

    public int getPointer() {
        return pointer;
    }

    public void setPointer(int pointer) {
        this.pointer = pointer;
    }

    public int getSize() {
        return size;
    }

    public void resetPointer(){
        this.pointer = 0;
    }
    public void addToDataset(List<Double> in, List<Double> out){
        this.size += 1;
        this.outs.add(new LinkedList<Double>(out));
        this.inputs.add(new LinkedList<Double>(in));
    }
    public List<Double> getNextIn(){
        return this.inputs.get(pointer);
    }
    public List<Double> getNextOut(){
        return this.outs.get(pointer);
    }

    public int pointerPlusPlus(){
        pointer = (pointer+1)%size;
        return pointer;
    }

    public static Dataset loadFromFile(String path){
        try {
            BufferedReader reader  = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            Dataset db = new Dataset();
            while(line != null){
                String [] splited = line.split("\t");

                List<Double> in = new LinkedList<>();
                List<Double> out = new LinkedList<>();
                line = reader.readLine();
                in.add(Double.parseDouble(splited[0]));
                in.add(Double.parseDouble(splited[1]));

                out.add(Double.parseDouble(splited[2]));
                out.add(Double.parseDouble(splited[3]));
                out.add(Double.parseDouble(splited[4]));
                db.addToDataset(in,out);

            }
            return db;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
