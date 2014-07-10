package Ch10.Ex4Analysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Ex4 {
    List<Integer> Nums = new ArrayList<>();
    public void main(){
        Scanner in = new Scanner(System.in);
        int last;
        do {
            System.out.println("Enter any whole number between 1 and 50 (0 to quit): ");
            last = in.nextInt();
            if (last >= 1 && last <= 50) Nums.add(last);
            else if (last != 0) System.out.println("Invalid entry, try again.");
        } while (last != 0);
        if (!Nums.isEmpty()){
            System.out.println("The average of your numbers is: " + average());
            System.out.println("The largest of your numbers is: " + largest());
            System.out.println("The range of your numbers is: " + range());
            System.out.println("The median of your numbers is: " + com());
            System.out.println(graph());
        } else System.out.println("You didn't enter any numbers!! Quitting.");
    }
    public double average(){
        int total = 0, count = 0;
        for (Integer i : Nums){
            total += i;
            count ++;
        }
        return (total / count);
    }
    public int largest(){
        int big = 0;
        for (Integer i : Nums) if (i > big) big = i;
        return big;
    }
    public String range(){
        int small = 99;
        for (Integer i : Nums) if (i < small) small = i;
        return (small + " - " + largest());
    }
    public int com(){
        Map<Integer, Integer> nuMap = new HashMap<>();
        for (Integer i : Nums){
            if (nuMap.containsKey(i)) nuMap.put(i, nuMap.get(i) + 1);
            else nuMap.put(i, 1);
        }
        Map.Entry<Integer, Integer> big = null;
        for (Map.Entry<Integer, Integer> e : nuMap.entrySet()){
            if (big == null || e.getValue() > big.getValue()) big = e;
        }
        return big.getKey();
    }
    public String graph(){
        String output;
        int[] c = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        for (Integer i : Nums){
            if (i >= 1 && i <= 5) c[0]++;
            else if (i >= 6 && i <= 10) c[1]++;
            else if (i >= 11 && i <= 15) c[2]++;
            else if (i >= 16 && i <= 20) c[3]++;
            else if (i >= 21 && i <= 25) c[4]++;
            else if (i >= 26 && i <= 30) c[5]++;
            else if (i >= 31 && i <= 35) c[6]++;
            else if (i >= 36 && i <= 40) c[7]++;
            else if (i >= 41 && i <= 45) c[8]++;
            else if (i >= 46 && i <= 50) c[9]++;
        }
        return (" 1 -  5 :  " + s(c[0]) + "\n 6 - 10 :  " + s(c[1]) + "\n11 - 15 :  " + s(c[2]) +
                "\n16 - 20 :  " + s(c[3]) + "\n21 - 25 :  " + s(c[4]) + "\n26 - 30 :  " + s(c[5]) + 
                "\n31 - 35 :  " + s(c[6]) + "\n36 - 40 :  " + s(c[7]) + "\n41 - 45 :  " + s(c[8]) + 
                "\n46 - 50 :  " + s(c[9]));
    }
    public String s(int i){
        String o = "";
        for (int j = 0; j < i; j++) o += "*";
        return o;
    }
}
