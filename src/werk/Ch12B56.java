package werk;
import java.util.Scanner;
public class Ch12B56 {
    static Scanner input = new Scanner(System.in);
    public static void WSC (){
        System.out.println("Welcome to the Weekly Salary and Pay Slip Calculator!");
        System.out.print("Please enter your family name: ");
        String nameLast = input.nextLine();
        System.out.print("Please enter your first name: ");
        String nameFirst = input.nextLine();
        System.out.print("How much money do you make each hour?: $");
        double hourlyRate = input.nextDouble();
        System.out.print("How many whole hours have you worked this week?: ");
        int hours = input.nextInt();
        if (hours > 40){
            hours = hours - 40;
            hours = hours * 2;
            hours = hours + 40;
        }
        System.out.println("Please enter a letter between A and E based on your placement on the following chart.");
        System.out.println("    A:  No Tax Deductions      D:  29% Deductions");
        System.out.println("    B:  10% Deductions         E:  35% Deductions");
        System.out.print  ("    C:  20% Deductions                                 Your category: ");
        double tax;
        switch(input.next()){
            case "B":
            case "b":
                tax = 0.90;
                break;
            case "C":
            case "c":
                tax = 0.80;
                break;
            case "D":
            case "d":
                tax = 0.71;
                break;
            case "E":
            case "e":
                tax = 0.65;
                break;
            default:
                tax = 0;
        }
        System.out.print("Finally, would you like to make a 20$ weekly donation to the United Way Charity fund? (y/n): ");
        int donation;
        switch(input.next()){
            case "y":
            case "Y":
                donation = -20;
                break;
            default:
                donation = 0;
        }
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Name: " + nameLast + ", " + nameFirst);
        double gross = hours * hourlyRate;
        System.out.println("Gross pay:         $" + gross);
        System.out.print  ("Deductions:        ");
        if (tax != 0){
            double taxLoss = gross - (gross * tax);
            System.out.println("$" + taxLoss + "    (Taxes)");
        }
        if (tax !=0 && donation != 0) System.out.print("                   ");
        if (donation != 0) System.out.println("$20    (Donation)");
        double net = gross * tax + donation;
        System.out.println("Net Weekly Pay:    $" + net);
    }
    public static void Change (){
        System.out.print("Please enter the amount of change in cents you have (<100): ");
        int num = input.nextInt();
        if (num < 100){
            String output = num + " cents changes to ";
            int count = 0;
            while (num / 25 > 0){
                num -= 25;
                count++;
            }
            if (count > 0) output += count + " Quarter";
            if (count > 1) output += "s";
            if (count > 0 && num > 0) output += ", ";
            count = 0;
            while (num / 10 > 0){
                num -= 10;
                count++;
            }
            if (count > 0) output += count + " Dime";
            if (count > 1) output += "s";
            if (count > 0 && num > 0) output += ", ";
            count = 0;
            while (num / 5 > 0){
                num -= 5;
                count++;
            }
            if (count > 0) output += count + " Nickel";
            if (count > 1) output += "s";
            if (count > 0 && num > 0) output += ", ";
            count = 0;
            while (num / 1 > 0){
                num -= 1;
                count++;
            }
            if (count == 1) output += count + " Penny";
            if (count > 1) output += count + " Pennies";
            int lastComma = output.lastIndexOf(", ");
            if (lastComma >= 0) output = output.substring(0, lastComma + 1) + " and" + output.substring(lastComma + 1);
            System.out.println(output);
        } else {
            System.out.println("I did note that it had to be less than 100, didn't I? Quitting...");
        }
    }
    public static void Simpleton (){
        System.out.println("Welcome to the Simpleton Tax Calculator!");
        System.out.print("What is your annual salary?: $");
        double income = input.nextDouble();
        System.out.print("How much do you pay for your home annually?: $");
        double housingCost = input.nextDouble();
        System.out.print("How many children do you have?: ");
        int totalChildren = input.nextInt();
        System.out.print("How many of your children are in school?: ");
        int schoolChildren = input.nextInt();
        int noSchoolKids = totalChildren - schoolChildren;
        
        double tax = 0;
        //If housing cost is less than 8000, first 10000 income is nontaxable
        if (housingCost <= 8000) income -= 10000;
        tax += income * 0.18;
        if (housingCost < 6000 && totalChildren > 2 && schoolChildren > 0) tax -= (500 * noSchoolKids) + (1000 * schoolChildren);
        if (tax > 2000) tax *= 1.15;
        
        if (tax >= 0) System.out.println("\nTax payable: $" + tax);
        else System.out.println("\nRefund availible: $" + (tax * -1));
    }
    public static void SINs (){
        System.out.println("The list of valid Social Insurance Numbers includes: ");
        for (int i = 0; i <= 999999999; i++){
            String number = String.valueOf(i);
            while (number.length() < 9){
                number = "0" + number;
            }
            int[] n = new int[9];
            for (int j = 0; j < 9; j++){
                n[j] = Integer.valueOf(number.substring(j, j + 1));
            }
            String test = String.valueOf(n[0] + (n[1] * 2) + n[2] + (n[3] * 2) + n[4] + (n[5] * 2) + n[6] + (n[7] * 2));
            int lastNum = Integer.valueOf(test.substring(test.length() - 1));
            if (10 - lastNum == n[8]){
                System.out.print(number + ", ");
            }
        }
    }
}
