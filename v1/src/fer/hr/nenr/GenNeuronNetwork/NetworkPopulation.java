package fer.hr.nenr.GenNeuronNetwork;

import fer.hr.nenr.GenNeuronNetwork.MutAndCros.*;

import java.util.*;

/**
 * Created by Ivan on 23.1.2016..
 */
public class NetworkPopulation {

    private final int populationsSize;
    private final List<Integer> dimensions;
    private final double guassMutChance;
    private NeuronMutator[] mutators = new  NeuronMutator[2];
    private NeuronCross[] crosses = new NeuronCross[3];
    private List<NeuronNetwork> networks = new LinkedList<>();
    private NeuronNetwork best = null;
    private boolean newBest = false;
    private double meanError = 0;
    private double accFittnes = 0;

    public NetworkPopulation(List<Integer> dimensions, int populationSize ,double guassMutChance, double mutationChance, double mutator1StdDev, double mutator2StdDev  ){
        this.dimensions = dimensions;
        this.populationsSize = populationSize;
        this.guassMutChance = guassMutChance;
        mutators[0] = new ReplaceMutate(mutationChance,mutator1StdDev);
        mutators[1] = new GuassMutate(mutationChance,mutator2StdDev);
        crosses[0] = new MeanCross();
        crosses[1] = new RandomCross();
        crosses[2] = new WeightetCross();
        this.createStartingPopulation();

    }


    private void createStartingPopulation(){
        while (networks.size()<populationsSize) {
            networks.add(new NeuronNetwork(dimensions));
        }
    }

    public NeuronNetwork train(int maxIter,double eps,Dataset db,boolean elim,boolean elite,boolean verbose){
        Random rand = new Random();
        this.calculateErrors(db,elim);
        for(int i = 0;i<maxIter;i++){

            if(this.best.getError()<eps){
                System.out.print("Break at "+i+" ");
                break;
            }
            if(elim){
                for(int j = 0; j<populationsSize;j++) {
                    this.eliminate(db);
                }
            }else {
                this.calculateErrors(db,elim);
                this.nextGenerations(elite);
            }
            if(verbose) {
                if(newBest) {
                    System.out.println("new best = " + this.best.toString() + "\n in iteration = " + i + " with error = " + this.best.getError());
                    newBest = false;
                }
            }
        }
        System.out.println("**DONE**\ntrain best = "+this.best.toString()+"\n with error = "+this.best.getError());
        return this.best;
    }
    private void eliminate(Dataset db){
        Random rand = new Random();
        int first = rand.nextInt(this.populationsSize);
        int second = rand.nextInt(this.populationsSize);
        while(first == second){
            second = rand.nextInt(this.populationsSize);
        }
        int third = rand.nextInt(this.populationsSize);
        while(first ==third || second == third){
            third = rand.nextInt(this.populationsSize);
        }
        NeuronCross cross = this.crosses[rand.nextInt(3)];

        int worst = first;
        int better1 = second;
        int better2 = third;

        if (networks.get(worst).getFittnes()>networks.get(second).getFittnes()){
            worst = second;
            better1 = first;
        }
        if(networks.get(worst).getFittnes()>networks.get(third).getFittnes()){
            better2 = worst;
            worst = third;
        }
        NeuronNetwork newNetwork = new NeuronNetwork(this.dimensions);
        List<Double> newWeigts = cross.cross(this.networks.get(better1).getWeights(),this.networks.get(better2).getWeights());
        NeuronMutator mutator = this.mutators[0];
        if(rand.nextDouble()<this.guassMutChance){
            mutator = this.mutators[1];
        }
        newNetwork.setWeights(mutator.mutate(newWeigts));

        //newNetwork.setWeights(newWeigts);


        newNetwork.calcError(db);
        if(this.best.getFittnes()<newNetwork.getFittnes()){
            this.best = newNetwork.copy();
            this.newBest = true;
        }

        this.networks.set(worst,newNetwork);

/*
       for(NeuronNetwork network:networks){
            NeuronMutator mutator = this.mutators[0];
            if(rand.nextDouble()<this.guassMutChance){
                mutator = this.mutators[1];
            }
            List<Double> weights = mutator.mutate(network.getWeights());
            network.setWeights(weights);
        }
*/

    }
    private void nextGenerations(boolean elite){
        Random rand = new Random();
        List<NeuronNetwork> newNetwork = new LinkedList<>();
        if(elite) {
            newNetwork.add(this.networks.get(0));
        }
        while(newNetwork.size()<populationsSize){
            int pos1 = this.spinTheWheel();
            int pos2 = this.spinTheWheel();
            while(pos1!=pos2){
                pos2 = this.spinTheWheel();
            }
            NeuronCross cross = this.crosses[rand.nextInt(3)];
            NeuronMutator mutator = this.mutators[0];
            if(rand.nextDouble()<this.guassMutChance){
                mutator = this.mutators[1];
            }
            NeuronNetwork first = this.networks.get(pos1);
            NeuronNetwork second = this.networks.get(pos2);
            List<Double> newWeigts = cross.cross(first.getWeights(),second.getWeights());
            newWeigts = mutator.mutate(newWeigts);
            NeuronNetwork network = new NeuronNetwork(dimensions);
            network.setWeights(newWeigts);
            newNetwork.add(network);

        }
        this.networks = newNetwork;

    }
    private int spinTheWheel(){
        Random rand = new Random();
        double luckyOne = rand.nextDouble()*this.accFittnes;
        int i = 0;
        while(this.networks.get(i).getFittnes()<luckyOne){
            luckyOne -= this.networks.get(i).getFittnes();
            i += 1;
        }
        return i;
    }
    private void calculateErrors(Dataset db,boolean elim){
        this.meanError = 0;
        this.accFittnes = 0;
        for(NeuronNetwork network:this.networks){
            network.calcError(db);
            this.meanError += network.getError();
            this.accFittnes += network.getFittnes();
            if(best == null){
                this.best = network.copy();
                this.newBest = true;
            }else{
                if(this.best.getFittnes()<network.getFittnes()){
                    this.best = network.copy();
                    this.newBest = true;
                }
            }
        }
        if(!elim) {
            Collections.sort(this.networks, new Comparator<NeuronNetwork>() {
                @Override
                public int compare(NeuronNetwork o1, NeuronNetwork o2) {
                    if (o1.getFittnes() > o2.getFittnes()) {
                        return -1;
                    }
                    if (o1.getFittnes() < o2.getFittnes()) {
                        return 1;
                    }
                    return 0;
                }
            });
        }
        this.meanError /= (double)this.populationsSize;


    }

    public List<Double> predict(List<Double> ins){
        List<Double> bestPredicts = best.calculateForLayer(ins);
        List<Double> out = new LinkedList<>();
        for(Double d :bestPredicts){
            if(d>0.5){
                out.add(1.0);
            }else{
                out.add(0.0);
            }

        }
        return out;
    }



}
