package main;
import Bonus.Lockers;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SchoolWork2014{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("00: Weekly Salary Calculator");
        System.out.println("01: Change Calculator");
        System.out.println("02: Simpleton's Taxes");
        System.out.println("03: SIN Validator (0.3mil SIN/s; est.dur 50min)");
        System.out.println("04: Chapter 8 - My Savings");
        System.out.println("05: Chapter 8 - Digit Extractor");
        System.out.println("06: Locker Kids");
        System.out.println("07: Chapter 10 - Analysis");
        System.out.println("08: Chapter 10 - Mastermind");
        System.out.println("09: Chapter 8 - Game Of 21");
        System.out.println("10: Battleship");
        System.out.print("\nEnter the project you would like to view: ");
        int choice = input.nextInt();
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        
        Ch12B56 inst = new Ch12B56();
        Ch8.Ex1MySavings.Ex1 chap81 = new Ch8.Ex1MySavings.Ex1();
        Ch8.Ex2DigitExtractor.Ex2 chap82 = new Ch8.Ex2DigitExtractor.Ex2();
        Bonus.Lockers bonus = new Lockers();
        Ch10.Ex4Analysis.Ex4 ana = new Ch10.Ex4Analysis.Ex4();
        Ch10.Ex5Mastermind.Ex5 mm = new Ch10.Ex5Mastermind.Ex5();
        Ch8.Ex6GameOf21.Ex6 go21 = new Ch8.Ex6GameOf21.Ex6();
        Bonus.Battleship bs = new Bonus.Battleship();
        
        switch (choice){
            case 0: inst.WSC(); break;
            case 1: inst.Change(); break;
            case 2: inst.Simpleton(); break;
            case 3: inst.SINs(); break;
            case 4: chap81.main(); break;
            case 5: chap82.main(); break;
            case 6: bonus.main(); break;
            case 7: ana.main(); break;
            case 8: mm.main(); break;
            case 9: go21.main(); break;
            case 10: bs.main(); break;
            case 11: filetest(); break;
            default: System.out.println("Invalid selection. Quitting.");
        }
    }
    static void filetest(){
        File o = new File("C:/Users/Heath/Desktop/derp.txt");
        File n = new File("C:/Users/Heath/Desktop/derp2.txt");
        File m = new File("C:/Users/Heath/Desktop/new.txt");
        List<Integer> p = new ArrayList<>();
        String x = o.read() + " " + n.read(), y = "";
        for (String a : x.split(" ")) p.add(Integer.valueOf(a));
        for (int i = 0; x.length() > y.length(); i++) if (p.contains(i)) y += i + " ";
        m.write(y);
    }
}