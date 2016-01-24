package fer.hr.nenr.GenNeuronNetwork.PlayOnTheGround;

import fer.hr.nenr.GenNeuronNetwork.Dataset;
import fer.hr.nenr.GenNeuronNetwork.NetworkPopulation;
import fer.hr.nenr.GenNeuronNetwork.NeuronNetwork;


import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 21.1.2016..
 */
public class PlayGround1 {
    public static void main(String[]args) {

        Dataset db = Dataset.loadFromFile("zad7-dataset.txt");
        List<Integer> dims = new LinkedList<>();
        dims.add(2);
        dims.add(8);
        //dims.add(4);
        dims.add(3);
        NetworkPopulation pop = new NetworkPopulation(dims,30,0.8,0.02,5,0.2);
        pop.train(1000000,10E-7,db,true,true,false);
        int size = db.getSize();
        double acc = 0;
        for(int i = 0; i < size ; i++){
            List<Double> realOuts = db.getNextOut();
            List<Double> ins = db.getNextIn();
            db.pointerPlusPlus();
            List<Double> predicts = pop.predict(ins);
            Boolean same = true;
            for(int outSize = 0; outSize<realOuts.size();outSize+=1){
                if(Math.abs(predicts.get(outSize)-realOuts.get(outSize))>10E-6){
                    same = false;
                }
            }
            if(same == false){
                System.out.print("*KRIVI* ");
            }else{
                acc += 1;
            }
            System.out.println("In = "+ins.toString()+" Real Out = "+realOuts.toString()+" My Out = "+predicts.toString());

        }
        System.out.println("Accuracy = "+(acc/(double)size));

    }

}
