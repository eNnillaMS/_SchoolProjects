package Ch10.Ex5Mastermind;
import java.util.Random;
import java.util.Scanner;
public class Ex5 {
    private int[] sys, usr;
    private Scanner in = new Scanner(System.in);
    public void main(){
        int a, b;
        do {
            System.out.print("Enter the number of pegs (1-10): ");
            a = in.nextInt();
            if (a >= 1 && a <= 10) {
                sys = new int[a];
                usr = new int[a];
            } else System.out.println("Number must be between 1 and 10! Try again!\n");
        } while (a < 1 && a > 10);
        do {
            System.out.print("Enter the number of colors (1-9): ");
            b = in.nextInt();
            Random rand = new Random();
            if (b >= 1 && b <= 9) for (int c = 0; c < sys.length; c++) sys[c] = rand.nextInt(b - 1) + 1;
            else System.out.println("Number must be between 1 and 9! Try again!\n");
        } while (b < 1 && b > 9);
        System.out.println("");
        int win = 0, gC = 0, p = 0, c = 0;
        do {
            System.out.println("Guess " + gC + ":");
            for (int d = 0; d < usr.length; d++){
                System.out.print("Color for peg " + (d + 1) + ": ");
                usr[d] = in.nextInt();
            }
            for (int e = 0; e < sys.length; e++){
                if (sys[e] == usr[e]) p++;
                if (intC(usr, sys[e])) c++;
            }
            System.out.println("You have " + p + " peg(s) correct and " + c + " color(s) correct.\n");
            if (p == sys.length) win = 1; 
            p = 0; c = 0; gC++;
        } while(win == 0);
        System.out.println("You have broken the code in " + gC + " guesses.");
    }
    private boolean intC(int[] f, int g){
        for (int h = 0; h < f.length; h++) if (f[h] == g) return true;
        return false;
    }
}
