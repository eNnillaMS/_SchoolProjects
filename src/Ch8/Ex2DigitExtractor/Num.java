package Ch8.Ex2DigitExtractor;
public class Num {
    private String Number;
    
    public Num(int num){
        Number = String.valueOf(num);
    }
    
    public int length(){
        return Number.length();
    }
    public String Whole(){
        return Number;
    }
    public String Ones(){
        return Number.substring(2, 3);
    }
    public String Tens(){
        return Number.substring(1, 2);
    }
    public String Hundreds(){
        return Number.substring(0, 1);
    }
}