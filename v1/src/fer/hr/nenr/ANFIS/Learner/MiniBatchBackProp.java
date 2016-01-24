package fer.hr.nenr.ANFIS.Learner;

import fer.hr.nenr.ANFIS.NeuronNetwork.INetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public class MiniBatchBackProp extends Learner{
    public MiniBatchBackProp(double faktor, double eps, int maxIter){
        super(faktor, eps, maxIter);
    }



    @Override
    public void learnNetwork2(HashMap<List<Double>, List<Double>> data, INetwork network) {

        List<Integer> dimension = network.getDimension();
        int lastDimension = dimension.get(dimension.size()-1);

        int N = data.keySet().size();
        double multFaktor = faktor/(2*lastDimension);
        LinkedList<List<List<Double>>>allSortedByKlass = this.sortData(data,lastDimension);
        for(int iter = 0; iter<this.maxIter;){
            //System.out.println("~~~~~ iteration = "+iter+" ~~~~~");
            //System.out.println(network);
            LinkedList<Double> totalsErrors= new LinkedList<>();
            LinkedList<Double[][]> allErrors = this.createErrorStructure(dimension);
            double trainError = 0;
            for(int step = 0 ; step < 2 ; step ++) {
                iter++;
                for (int klass = 0; klass < lastDimension; klass++) {
                    List<List<Double>> allFromKlass = allSortedByKlass.get(klass);
                    int ostatak = iter%allFromKlass.size();
                    List<Double> vektor = allFromKlass.get(ostatak);

                    List<Double> result = data.get(vektor);
                    List<List<Double>> returns = network.apsolute(vektor);

                    boolean outsFlag = true;
                    List<Double> derivationsForBefore = new LinkedList<>();
                    for (int layer = dimension.size() - 1; layer > 0; layer--) {

                        int izlI = dimension.get(layer - 1);
                        int izlJ = dimension.get(layer);


                        List<Double> YK1 = returns.get(layer + 1);
                        List<Double> YK = returns.get(layer);


                        List<Double> derivations = new LinkedList<>();
                        Double[][] layerErrors = allErrors.get(layer);
                        if (outsFlag) {
                            outsFlag = false;
                            for (int j = 0; j < izlJ; j++) {
                                // Racunanje derivacije za svaki IZLAZ odnosno NEURON (izlazni)
                                derivations.add(YK1.get(j) * (1 - YK1.get(j)) * (result.get(j) - YK1.get(j)));
                            }
                            derivationsForBefore = new LinkedList<>();
                            derivationsForBefore.addAll(derivations);

                        } else {
                            //Racunanje derivacije za ostale slojeve
                            for (int j = 0; j < izlJ; j++) {
                                double localDer = 0;
                                for (int o = 0; o < derivationsForBefore.size(); o++) {
                                    localDer += derivationsForBefore.get(o) * network.getWeight(layer + 1, o, j);
                                }


                                derivations.add(YK1.get(j) * (1 - YK1.get(j)) * localDer);
                            }
                            derivationsForBefore = new LinkedList<>();
                            derivationsForBefore.addAll(derivations);
                        }

                        for (int j = 0; j < izlJ; j++) {
                            for (int i = 0; i < izlI; i++) {
                                layerErrors[j][i] += derivations.get(j) * YK.get(i);
                            }
                            layerErrors[j][izlI] += derivations.get(j);

                        }
                        //System.out.println(derivations);
                        allErrors.set(layer, layerErrors);
                        trainError += this.calculateTotalError(network, vektor, data.get(vektor));

                    }
                    //prvi sloj se netreba dirat....
                   /* int izlI = dimension.get(0);
                    int izlJ = dimension.get(0);
                    List<Double> YK1 = returns.get(1);
                    List<Double> YK = returns.get(0);
                    List<Double> derivations = new LinkedList<>();
                    Double[][] layerErrors = allErrors.get(0);
                    for (int j = 0; j < izlJ; j++) {
                        double localDer = 0;
                        for (int o = 0; o < derivationsForBefore.size(); o++) {
                            localDer += derivationsForBefore.get(o) * network.getWeight(1, o, j);
                        }
                        derivations.add(YK1.get(j) * (1 - YK1.get(j)) * localDer);
                    }
                    for (int j = 0; j < izlJ; j++) {
                        for (int i = 0; i < 1; i++) {
                            derivations.get(j);
                            YK.get(i);

                            layerErrors[j][i] += derivations.get(j) * YK.get(i);

                        }
                        layerErrors[j][1] += derivations.get(j);

                    }
                    allErrors.set(0, layerErrors);
                    */
                    //this.PrintError(allErrors);

                }
            }
            //System.out.println(trainError);
            //if (trainError < eps) {
            //   return;
            // }
            this.changeWeights(multFaktor, allErrors, dimension, network);


        }
    }

    public LinkedList<List<List<Double>>> sortData(HashMap<List<Double>, List<Double>> data,int dimension){
        //broj klasa

        LinkedList<List<List<Double>>> all = new LinkedList();
        //za svaku klasu napravi praznu listu
        for (int i = 0; i <dimension; i++){
            List<List<Double>> allVektors = new LinkedList<List<Double>>();
            all.add(allVektors);
        }
        //za svaki vektor u data setu razvrstaj u listu koju pripada
        for (List<Double> vektor : data.keySet()){
            int klass = 0;
            List<Double> result = data.get(vektor);
            for (int i = 0 ; i<result.size(); i++){
                if(Math.abs(result.get(i))>10E-6){
                    klass = i;
                    break;
                }
            }

            List<List<Double>> allVektors =  all.get(klass);
            allVektors.add(vektor);
            all.set(klass,allVektors);
        }
        return  all;
    }
}
