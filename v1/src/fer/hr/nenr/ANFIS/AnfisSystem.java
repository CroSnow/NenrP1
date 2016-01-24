package fer.hr.nenr.ANFIS;

import fer.hr.nenr.ANFIS.Layers.*;
import fer.hr.nenr.FuzzySetPack.FunctionPack.IBinaryFunction;
import javafx.geometry.Point2D;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ivan on 5.1.2016..
 */
public class AnfisSystem {

    private List<Layer1Neuron> layer1A = new LinkedList<>();
    private List<Layer1Neuron> layer1B= new LinkedList<>();
    private List<Layer2Neuron> layer2= new LinkedList<>();
    private List<Layer3Neuron> layer3= new LinkedList<>();
    private List<Layer4Neuron> layer4= new LinkedList<>();

    List<Double> oldA= new LinkedList<>();
    List<Double> oldB = new LinkedList<>();
    List<Double> oldC = new LinkedList<>();
    List<Double> oldD = new LinkedList<>();
    List<Double> oldP = new LinkedList<>();
    List<Double> oldQ = new LinkedList<>();
    List<Double> oldR = new LinkedList<>();

    LinkedList<Double> a= new LinkedList<>();
    LinkedList<Double> b = new LinkedList<>();
    LinkedList<Double> c = new LinkedList<>();
    LinkedList<Double> d = new LinkedList<>();
    LinkedList<Double> p = new LinkedList<>();
    LinkedList<Double> q = new LinkedList<>();
    LinkedList<Double> r = new LinkedList<>();

    private Layer5Neuron layer5;

    public AnfisSystem(int premiseCount, double lower,double upper,IBinaryFunction norm) {
        for(int i = 0; i<premiseCount; i++){
            layer1A.add(new Layer1Neuron(lower,upper));
            layer1B.add(new Layer1Neuron(lower,upper));
        }
        for (int i = 0; i<premiseCount; i++){
            layer2.add(new Layer2Neuron(layer1A.get(i),layer1B.get(i),norm));
        }

        for (int i = 0; i<layer2.size(); i++){
            layer3.add(new Layer3Neuron(layer2.get(i)));
            layer4.add(new Layer4Neuron(layer3.get(i),lower,upper));
        }
        layer5 = new Layer5Neuron(layer4);

    }

    public double calculate(double x, double y){
        for (Layer1Neuron l :layer1A){
            l.value(x);
        }
        for (Layer1Neuron l :layer1B){
            l.value(y);
        }
        double sum = 0;
        for(Layer2Neuron l: layer2){
            sum += l.calculate();
        }
        for(Layer3Neuron l: layer3){
            l.calculate(sum);
        }
        for (Layer4Neuron l:layer4){
            l.calculate(x,y);
        }

        return layer5.calculate();
    }

    public void train(double learningFactor, int maxLoopCnt,double eps,IBinaryFunction fun, double xs, double xe, double xStep, double ys, double ye, double yStep,boolean stohastic,boolean traverse,String file){
        if(stohastic){
            learningFactor = learningFactor/(((xe-xs)/xStep)*((ye-ys)/yStep));
        }
        FileWriter writer = null;
        if(file != ""){
            try {
                writer = new FileWriter(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        this.calculateStartWeigts();
        for(int i = 0; i<maxLoopCnt;){
            double error = 0;
            a = new LinkedList<>();
            b = new LinkedList<>();
            c = new LinkedList<>();
            d = new LinkedList<>();
            p = new LinkedList<>();
            q = new LinkedList<>();
            r = new LinkedList<>();
            for(double x = xs;x<xe;x+=xStep) {
                for(double y = ys;y<ye;y+=yStep) {
                    double realOut = fun.valueAt(x,y);
                    double out = this.calculate(x,y);
                    //System.out.println("Pravi = "+realOut);
                    //System.out.println("Moj = "+out);
                    error += Math.pow(out-realOut,2)/2.0;
                    if (stohastic==false){
                        this.grad(x,y,realOut,out,learningFactor);
                        this.changeWeighs();
                        i++;
                        if(i>=maxLoopCnt){
                            System.out.println("Error = "+error);
                            if(file != ""){
                                try {
                                    writer.flush();
                                    writer.close();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                            return;
                        }
                    }else{
                        this.stohastic(x,y,realOut,out,learningFactor);
                    }

                }
            }
            if(stohastic) {
                for (int j = 0; j < a.size(); j++) {
                    a.set(j, a.get(j) + oldA.get(j));
                    b.set(j, b.get(j) + oldB.get(j));
                    c.set(j, c.get(j) + oldC.get(j));
                    d.set(j, d.get(j) + oldD.get(j));
                }
                for (int j = 0; j < p.size(); j++) {
                    p.set(j, p.get(j) + oldP.get(j));
                    q.set(j, q.get(j) + oldQ.get(j));
                    r.set(j, r.get(j) + oldR.get(j));

                }
                this.changeWeighs();
                i++;
                if (i >= maxLoopCnt) {
                    error = error/(((xe-xs)/xStep)*((ye-ys)/yStep));
                    System.out.println("Error = "+error);
                    if(file != ""){
                        try {
                            writer.flush();
                            writer.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    return;
                }
            }
            error = error/(((xe-xs)/xStep)*((ye-ys)/yStep));
            if(error<eps){
                System.out.println("Error = "+error);
                if(file != ""){
                    try {
                        writer.flush();
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                return;
            }
            else{
                if(traverse) {
                    System.out.println("Error = " + error + " in iteration = " + i);
                }
                if(file != ""){
                    try {
                        writer.write(i+" "+error+"\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }


        }
    }

    private void changeWeighs(){
        oldA=a;
        oldB=b;
        oldC=c;
        oldD=d;
        oldP=p;
        oldQ=q;
        oldR=r;
        for(int i = 0; i<layer1A.size();i++){

            Layer1Neuron neuron = layer1A.get(i);
            neuron.setA(a.get(i));
            neuron.setB(b.get(i));

            neuron = layer1B.get(i);
            neuron.setA(c.get(i));
            neuron.setB(d.get(i));
        }
        int i = 0;
        for(Layer4Neuron neuron:layer4){

            neuron.setP(p.get(i));
            neuron.setQ(q.get(i));
            neuron.setR(r.get(i));
            i++;
        }
    }

    private void calculateStartWeigts(){
        for(Layer1Neuron neuron:layer1A){
            oldA.add(neuron.getA());
            oldB.add(neuron.getB());
        }

        for(Layer1Neuron neuron:layer1B){
            oldC.add(neuron.getA());
            oldD.add(neuron.getB());
        }

        for(Layer4Neuron neuron:layer4){
            oldQ.add(neuron.getQ());
            oldP.add(neuron.getP());
            oldR.add(neuron.getR());
        }
    }

    private void grad(Double x,Double y,Double realOut,Double out,Double learningFactor){
        a = new LinkedList<>();
        b = new LinkedList<>();
        c = new LinkedList<>();
        d = new LinkedList<>();
        p = new LinkedList<>();
        q = new LinkedList<>();
        r = new LinkedList<>();
        this.stohastic(x,y,realOut,out,learningFactor);
        for (int j = 0; j<a.size();j++){
            a.set(j,a.get(j)+oldA.get(j));
            b.set(j,b.get(j)+oldB.get(j));
            c.set(j,c.get(j)+oldC.get(j));
            d.set(j,d.get(j)+oldD.get(j));
        }
        for (int j = 0; j<p.size();j++){
            p.set(j,p.get(j)+oldP.get(j));
            q.set(j,q.get(j)+oldQ.get(j));
            r.set(j,r.get(j)+oldR.get(j));

        }
    }

    private void stohastic(Double x,Double y,Double realOut,Double out,Double learningFactor){
        if(a.size() == 0){
            for (int j = 0; j<oldA.size();j++){
                a.add(0.0);
                b.add(0.0);
                c.add(0.0);
                d.add(0.0);
            }
            for (int j = 0; j<oldP.size();j++){
                p.add(0.0);
                q.add(0.0);
                r.add(0.0);
            }
        }

        double sum = this.thirdSum();
        double kvaSum = sum*sum;
        List<Double> part= part();

        for (int i = 0; i <a.size();i++){
            double tempA = learningFactor*(realOut-out)*(part.get(i)/kvaSum)*layer1B.get(i).getLastValue()*oldB.get(i)*
                    layer1A.get(i).getLastValue()*(1-layer1A.get(i).getLastValue());
            double tempB =  learningFactor*(realOut-out)*(part.get(i)/kvaSum)*layer1B.get(i).getLastValue()*(x-oldA.get(i))*
                    layer1A.get(i).getLastValue()*(1-layer1A.get(i).getLastValue());
            double tempC = learningFactor*(realOut-out)*(part.get(i)/kvaSum)*layer1A.get(i).getLastValue()*oldD.get(i)*
                    layer1B.get(i).getLastValue()*(1-layer1B.get(i).getLastValue());
            double tempD =  learningFactor*(realOut-out)*(part.get(i)/kvaSum)*layer1A.get(i).getLastValue()*(y-oldC.get(i))*
                    layer1B.get(i).getLastValue()*(1-layer1B.get(i).getLastValue());

           /* double tempA = learningFactor*(realOut-out)*(part.get(i)/kvaSum)*oldB.get(i)*
                    layer1A.get(i).getLastValue()*(1-layer1A.get(i).getLastValue());
            double tempB =  learningFactor*(realOut-out)*(part.get(i)/kvaSum)*(x-oldA.get(i))*
                    layer1A.get(i).getLastValue()*(1-layer1A.get(i).getLastValue());
            double tempC = learningFactor*(realOut-out)*(part.get(i)/kvaSum)*oldD.get(i)*
                    layer1B.get(i).getLastValue()*(1-layer1B.get(i).getLastValue());
            double tempD =  learningFactor*(realOut-out)*(part.get(i)/kvaSum)*(y-oldC.get(i))*
                    layer1B.get(i).getLastValue()*(1-layer1B.get(i).getLastValue());*/

            a.set(i,a.get(i)+tempA);
            b.set(i,b.get(i)-tempB);
            c.set(i,c.get(i)+tempC);
            d.set(i,d.get(i)-tempD);
        }

        for (int i = 0; i <p.size();i++){
            double tempP = learningFactor*(realOut-out)*(layer2.get(i).getLastValue()/sum)*x;
            double tempQ = learningFactor*(realOut-out)*(layer2.get(i).getLastValue()/sum)*y;
            double tempR = learningFactor*(realOut-out)*(layer2.get(i).getLastValue()/sum);

            p.set(i,p.get(i)+tempP);
            q.set(i,q.get(i)+tempQ);
            r.set(i,r.get(i)+tempR);
        }
    }

    private List<Double> part(){
        LinkedList<Double> part = new LinkedList<>();
        for(Layer2Neuron w:layer2){
            part.add(0.0);
        }
        for( int i = 0;i <layer2.size(); i ++){
            for(int j = 0; j<layer2.size();j++){
                if(i != j){
                    //part.set(i,part.get(i)+layer2.get(j).getLastValue());
                    part.set(i,part.get(i)+layer2.get(j).getLastValue()*(layer4.get(i).getZ()-layer4.get(j).getZ()));
                }
            }
        }
        return part;
    }
    private double thirdSum(){
        double sum = 0;
        for(Layer2Neuron w:layer2){
            sum+=w.getLastValue();
        }
        return sum;
    }

    public void logSystem(double from, double end , double step,String filename){
        List<List<Point2D>> all = new LinkedList<>();
        for (int i = 0; i < 2*layer1A.size();i++){
            all.add(new LinkedList<>());
            all.add(new LinkedList<>());
        }
        for (double x = from; x<end;x+=step ){
            int j = 0;
            for(int i = 0; i<2*layer1A.size();i+=2){
                all.get(i).add(new Point2D(x,layer1A.get(j).value(x)));
                all.get(i+1).add(new Point2D(x,layer1B.get(j).value(x)));
                j++;
            }
        }
        try {
            FileWriter writer = new FileWriter(filename);
            for(List<Point2D>list:all){
                for(Point2D point: list){
                    writer.write(point.getX()+","+point.getY()+"    ");
                }
                writer.write("\n");
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
