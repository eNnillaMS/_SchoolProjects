package Ch8.Ex1MySavings;
public class PiggyBank {
    private double value = 0.00;
    
    public PiggyBank(){
        value = 0.00;
    }
    
    public double getValue(){
        return value;
    }
    public double addPenny(){
        value += 0.01;
        return value;
    }
    public double addNickel(){
        value += 0.05;
        return value;
    }
    public double addDime(){
        value += 0.10;
        return value;
    }
    public double addQuarter(){
        value += 0.25;
        return value;
    }
    public double remove(double d){
        value -= d;
        return value;
    }
}