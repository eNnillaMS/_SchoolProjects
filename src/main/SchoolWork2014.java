package main;
import java.util.Scanner;
public class SchoolWork2014{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("00: Weekly Salary Calculator");
        System.out.println("01: Change Calculator");
        System.out.println("02: Simpleton's Taxes");
        System.out.println("03: SIN Validator (0.3mil SIN/s; est.dur 50min)");
        //TODO  System.out.println("04: Chapter 8 Excercise Menu");
        System.out.print("\nEnter the project you would like to view: ");
        int choice = input.nextInt();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
        Ch12B56 inst = new Ch12B56();
        Ch8.Ch8 chap8 = new Ch8.Ch8();
        
        switch (choice){
            case 0:
                inst.WSC();
                break;
            case 1:
                inst.Change();
                break;
            case 2:
                inst.Simpleton();
                break;
            case 3:
                inst.SINs();
                break;
            case 4:
                chap8.menu();
                break;
            default:
                System.out.println("Invalid selection. Quitting.");
        }
    }
}