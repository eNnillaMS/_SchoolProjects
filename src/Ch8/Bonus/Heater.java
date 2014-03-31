package Ch8.Bonus;
public class Heater {
    private double temperature;
    private final double min;
    private final double max;
    private double increment;
    public Heater(double newMin, double newMax){
        temperature = 15;
        increment = 5;
        min = newMin;
        max = newMax;
    }
    public void warmer(){
        temperature += increment;
        if (temperature > max) temperature = max;
    }
    public void cooler(){
        temperature -= increment;
        if (temperature < min) temperature = min;
    }
    public double getTemperature(){
        return temperature;
    }
    public void setIncrement(double newIncrement){
        if (newIncrement > 0) increment = newIncrement;
        else System.out.println("Error! New increment must be greater than zero.");
    }
}
