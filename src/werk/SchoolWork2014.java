package werk;
import java.util.Scanner;
public class SchoolWork2014{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("00: Weekly Salary Calculator");
        System.out.println("01: Change Calculator");
        System.out.println("02: Simpleton's Taxes");
        System.out.println("03: SIN Validator (0.3mil SIN/s; est.dur 50min)");
        System.out.print("\nEnter the project you would like to view: ");
        int choice = input.nextInt();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        switch (choice){
            case 0:
                Ch12B56.WSC();
                break;
            case 1:
                Ch12B56.Change();
                break;
            case 2:
                Ch12B56.Simpleton();
                break;
            case 3:
                Ch12B56.SINs();
                break;
            default:
                System.out.println("Invalid selection. Quitting.");
                break;
        }
    }
}