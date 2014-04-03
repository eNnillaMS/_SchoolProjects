package Ch8.Ex2DigitExtractor;
import java.util.Scanner;
public class Ex2 {
    public void main(){
        Scanner s = new Scanner(System.in);
        Num num = null;
        boolean get = false;
        while (!get){
            System.out.print("Enter an integer (3 digits): ");
            num = new Num(s.nextInt());
            get = (num.length() == 3);
            if (!get) System.out.print("Bad number, try again...\n");
        }
        
        boolean cont = true;
        while (cont){
            System.out.println("Show (W)hole number.");
            System.out.println("Show (O)nes place number.");
            System.out.println("Show (T)ens place number.");
            System.out.println("Show (H)undreds place number.");
            System.out.println("(Q)uit.");
            System.out.print("Enter your choice: ");
            switch (s.next().toUpperCase()){
                default:
                case "W":
                    System.out.println("The whole number is " + num.Whole());
                    break;
                case "O":
                    System.out.println("The number in the ones place is " + num.Ones());
                    break;
                case "T":
                    System.out.println("The number in the tens place is " + num.Tens());
                    break;
                case "H":
                    System.out.println("The number in the hundreds place is " + num.Hundreds());
                    break;
                case "Q":
                    cont = false;
            }
        }
    }
}