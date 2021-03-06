package Ch8.Ex1MySavings;
import java.util.Scanner;
public class Ex1 {
    public void main(){
        Scanner s = new Scanner(System.in);
        PiggyBank pb = new PiggyBank();
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
                    System.out.println("You have: $" + pb.getValue());
                    break;
                case 2:
                    System.out.println("You now have: $" + pb.addPenny());
                    break;
                case 3:
                    System.out.println("You now have: $" + pb.addNickel());
                    break;
                case 4:
                    System.out.println("You now have: $" + pb.addDime());
                    break;
                case 5:
                    System.out.println("You now have: $" + pb.addQuarter());
                    break;
                case 6:
                    System.out.print("Enter an amount to remove: ");
                    System.out.println("You now have: $" + pb.remove(s.nextDouble()));
                    break;
                case 0:
                    cont = false;
            }
        }
    }
}
