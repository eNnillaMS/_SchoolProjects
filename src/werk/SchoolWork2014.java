package werk;
import java.util.Scanner;
public class SchoolWork2014{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("00: Weekly Salary Calculator");
        System.out.print("Enter the project you would like to view: ");
        switch (input.nextInt()){
            case 0:
                Ch12B56.WSC();
                break;
            default:
                System.out.println("Invalid selection. Quitting.");
                break;
        }
    }
}
