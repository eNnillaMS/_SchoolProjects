package Ch8;
import java.util.Scanner;
//TODO  import Ch8.Bonus.Bonus;
import Ch8.Ex1MySavings.Ex1;
public class Ch8 {
    //TODO  Bonus Tester = new Bonus();
    Ex1 MySavings = new Ex1();
    public void menu(){
        Scanner input = new Scanner(System.in);
        System.out.println("00: Bonus Class Tests");
        System.out.println("01: Excercise 1 - My Savings");
        System.out.println("02: Excercise 2 - Digit Extractor");
        System.out.println("03: Excercise 3 - Lunch Order");
        System.out.println("04: Excercise 4 - Dice Roll Game");
        System.out.print("\nEnter the project you would like to view: ");
        int choice = input.nextInt();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (choice){
            case 0:
                //TODO  Tester.main();
                break;
            case 1:
                MySavings.main();
                break;
            default:
                System.out.println("Invalid selection. Quitting.");
        }
    }
}
