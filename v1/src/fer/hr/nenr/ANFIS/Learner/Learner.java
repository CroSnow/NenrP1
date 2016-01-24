package fer.hr.nenr.ANFIS.Learner;

import fer.hr.nenr.ANFIS.NeuronNetwork.INetwork;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public abstract class Learner implements ILearner  {
    protected double faktor;
    protected double eps;
    protected int maxIter;
    public Learner(double faktor, double eps, int maxIter){
        this.faktor = faktor;
        this.eps = eps;
        this.maxIter = maxIter;
    }
    protected Double calculateTotalError(INetwork network, List<Double> vektor, List<Double> real){
        List<Double> results = network.iteration(vektor);

        double totalError = 0;
        for (int i = 0; i<results.size();i++){
            totalError += Math.pow(results.get(i)-real.get(i),2);
        }
        return totalError;

    }
    public void learnNetwork(HashMap<List<Double>, Integer> data, INetwork network) {
        HashMap<List<Double>,List<Double>> changed = new HashMap<>();
        int size = network.getDimension().get(network.getDimension().size()-1);
        for (List<Double> vektor : data.keySet()){
            List<Double> result = new LinkedList<>();
            for (int i = 0;i<size;i++){
                if(i == data.get(vektor)){
                    result.add(1.0);
                }else{
                    result.add(0.0);
                }
            }
            changed.put(vektor,result);

        }
        this.learnNetwork2(changed,network);

    }

    public LinkedList<Double[][]> createErrorStructure(List<Integer> dimensions){
        LinkedList<Double[][]> allErrors = new LinkedList<>();
        Double[][] prvi = new Double[dimensions.get(0)][2];
        for (Double[] row: prvi)
            Arrays.fill(row, 0.0);

        allErrors.add(prvi);
        for (int i = 1; i<dimensions.size();i++){
            int brojNeuronaUsloju = dimensions.get(i);
            int brojNueoranUslojuPrije = dimensions.get(i-1);
            Double[][] trenutniErrori = new Double[brojNeuronaUsloju][brojNueoranUslojuPrije+1];
            for (Double[] row: trenutniErrori)
                Arrays.fill(row, 0.0);

            allErrors.add(trenutniErrori);
        }
        return allErrors;
    }

    public void changeWeights(double faktor, LinkedList<Double[][]> deltas,List<Integer> dimensions,INetwork network){
        for (int layer = dimensions.size()-1;layer>0;layer--){//za svaki sloj
            int LayerSize = dimensions.get(layer);
            int LayerSizeBefore = dimensions.get(layer-1);
            Double[][] localDeltas = deltas.get(layer);
            for (int j = 0; j<LayerSize;j++){//za svaki neuron
                for (int i = 0; i<=LayerSizeBefore;i++){//za svaku tezinu
                    network.addToWeight(layer,j,i,localDeltas[j][i]*faktor);
                }
            }
        }
        //Posebno za pocetni sloj
        Double[][] localDeltas = deltas.get(0);
        for (int j = 0;j< dimensions.get(0);j++){
            for (int i = 0;i<2;i++){
                network.addToWeight(0,j,i,localDeltas[j][i]*faktor);
            }
        }
    }
    public double calculateError(LinkedList<Double[][]> all){
        double totalError = 0;
        for(Double[][] matrix : all){
            for (Double[] line :matrix){
                for(Double value :line){
                    totalError += Math.abs(value);
                }
            }
        }
        return totalError;
    }
    public void PrintError(LinkedList<Double[][]> all){

        for(Double[][] matrix : all){
            System.out.println("Layer");
            for (Double[] line :matrix){
                System.out.println("");
                for(Double value :line){
                    System.out.print("|"+value+"|");
                }
                System.out.println("");
            }
        }

    }
}
