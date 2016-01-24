package fer.hr.nenr.ANFIS.Learner;

import fer.hr.nenr.ANFIS.NeuronNetwork.INetwork;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 11.12.2015..
 */
public class BackPropagation extends Learner {


    public BackPropagation(double faktor,double eps,int maxIter){
        super(faktor,eps,maxIter);
    }



    @Override
    public void learnNetwork2(HashMap<List<Double>, List<Double>> data, INetwork network) {
        List<Integer> dimension = network.getDimension();

        int N = data.keySet().size();
        double multFaktor = faktor/(double)N;
        for(int iter = 0; iter<this.maxIter;iter++){
            //System.out.println("~~~~~ iteration = "+iter+" ~~~~~");
            //System.out.println(network);
            LinkedList<Double> totalsErrors= new LinkedList<>();
            LinkedList<Double[][]> allErrors = this.createErrorStructure(dimension);
            double trainError = 0;
            for(List<Double> vektor:data.keySet()){
                List<Double> result = data.get(vektor);
                List<List<Double>> returns = network.apsolute(vektor);

                boolean outsFlag = true;
                List<Double> derivationsForBefore =  new LinkedList<>();
                for (int layer = dimension.size()-1;layer>0;layer--) {

                    int izlI = dimension.get(layer-1);
                    int izlJ = dimension.get(layer);


                    List<Double> YK1 = returns.get(layer+1);
                    List<Double> YK = returns.get(layer);


                    List<Double> derivations = new LinkedList<>();
                    Double[][] layerErrors = allErrors.get(layer);
                    if(outsFlag){
                        outsFlag = false;
                        for (int j = 0; j < izlJ; j++) {
                        // Racunanje derivacije za svaki IZLAZ odnosno NEURON (izlazni)
                            derivations.add(YK1.get(j) * (1 - YK1.get(j)) * (result.get(j) - YK1.get(j)));
                        }
                        derivationsForBefore =  new LinkedList<>();
                        derivationsForBefore.addAll(derivations);

                    }else{
                        //Racunanje derivacije za ostale slojeve
                        for (int j = 0; j < izlJ; j++) {
                            double localDer = 0;
                            for (int o = 0; o<derivationsForBefore.size();o++){
                                localDer += derivationsForBefore.get(o)*network.getWeight(layer+1,o,j);
                            }


                            derivations.add(YK1.get(j) * (1 - YK1.get(j))*localDer);
                        }
                        derivationsForBefore =  new LinkedList<>();
                        derivationsForBefore.addAll(derivations);
                    }

                    for (int j = 0; j < izlJ; j++) {
                        for (int i = 0; i < izlI; i++) {
                            layerErrors[j][i] += derivations.get(j) * YK.get(i);
                        }
                        layerErrors[j][izlI] += derivations.get(j);

                    }
                    //System.out.println(derivations);
                    allErrors.set(layer,layerErrors);
                    trainError += this.calculateTotalError(network,vektor,data.get(vektor));

                }
                //pvi netreba dirat
                /*
                int izlI = dimension.get(0);
                int izlJ = dimension.get(0);
                List<Double> YK1 = returns.get(1);
                List<Double> YK = returns.get(0);
                List<Double> derivations = new LinkedList<>();
                Double[][] layerErrors = allErrors.get(0);
                for (int j = 0; j < izlJ; j++) {
                    double localDer = 0;
                    for (int o = 0; o<derivationsForBefore.size();o++){
                        localDer += derivationsForBefore.get(o)*network.getWeight(1,o,j);
                    }
                    derivations.add(YK1.get(j) * (1 - YK1.get(j))*localDer);
                }
                for (int j = 0; j < izlJ; j++) {
                    for (int i = 0; i < 1; i++) {
                        derivations.get(j);
                        YK.get(i);

                        layerErrors[j][i] += derivations.get(j) * YK.get(i);

                    }
                    layerErrors[j][1] += derivations.get(j);

                }
                allErrors.set(0,layerErrors);
                //this.PrintError(allErrors);
                */




            }

            if(trainError <eps){
                return;
            }
            this.changeWeights(multFaktor,allErrors,dimension,network);


        }
    }
}
