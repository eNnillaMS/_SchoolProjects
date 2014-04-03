package Ch8.Ex1MySavings;
import java.util.Scanner;
public class Ex1_HIWHD {
    public void main(){
        Scanner s = new Scanner(System.in);
        PiggyBank_HIWHD pb = new PiggyBank_HIWHD();
        boolean cont = true;
        while (cont){
            System.out.println("1. Show total in bank.");
            System.out.println("2. Add a penny.");
            System.out.println("3. Add a nickel.");
            System.out.println("4. Add a dime.");
            System.out.println("5. Add a quarter.");
            System.out.println("6. Take money out of the bank.");
            System.out.println("Enter 0 to exit.");
            System.out.print("Enter your choice: ");
            switch (s.nextInt()){
                default:
                case 1:
                    System.out.println("You have: $" + pb.value);
                    break;
                case 2:
                    pb.value += 0.01;
                    System.out.println("You now have: $" + pb.value);
                    break;
                case 3:
                    pb.value += 0.05;
                    System.out.println("You now have: $" + pb.value);
                    break;
                case 4:
                    pb.value += 0.10;
                    System.out.println("You now have: $" + pb.value);
                    break;
                case 5:
                    pb.value += 0.25;
                    System.out.println("You now have: $" + pb.value);
                    break;
                case 6:
                    System.out.print("Enter an amount to remove: ");
                    pb.value -= s.nextDouble();
                    System.out.println("You now have: $" + pb.value);
                    break;
                case 0:
                    cont = false;
            }
        }
    }
}
