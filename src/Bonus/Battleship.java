package Bonus;
import java.util.Random;
import java.util.Scanner;
public class Battleship {
    private int[][][] boards = new int[4][10][10];
    private Scanner in = new Scanner(System.in);
    Random rand = new Random();
    
    /*
    0 - Boat board Player
    1 - Shot board Player
    2 - Boat board System
    3 - Shot board System
    
    0 - Water
    1 - Aircraft Carrier (5)
    2 - Battleship (4)
    3 - Cruiser (3)
    4 - Destroyer (2)
    5 - Destroyer 2 (2)
    6 - Submarine (2)
    7 - Submarine 2 (2)
    8 - HIT
    
    0 - Water
    1 - Miss
    2 - Hit
    */
    
    public void main(){
        int[] temp;
        sopl("Welcome to the game of Battleship!");
        sopl("The game will be played on a 10x10 grid. When asked for a location,\n"
            + "you should enter a value like: \"A8\", where your ranges are A-J and\n"
            + "1-10. No other values will be allowed. When placing your ships, you will\n"
            + "enter a location for the front of the boats, and then choose between\n"
            + "availible locations for the end of the boat.\n\n");
        sop("Enter any number to continue: ");
        in.next();
        placeShips();
        int uhc = 0, shc = 0;
        String output = "";
        do {
            printMaps();
            sopl(output);
            output = "";
            sop("Enter a location to fire on: ");
            boolean wop = false;
            do {
                int[] us = convertLocation(in.next());
                if (us != null) {
                    if (boards[1][us[0]][us[1]] == 0) {
                        wop = true;
                        if (boards[2][us[0]][us[1]] != 0){
                            String a;
                            switch (boards[2][us[0]][us[1]]){
                                case 1: a = "Aircraft Carrier"; break;
                                case 2: a = "Battleship"; break;
                                case 3: a = "Cruiser"; break;
                                case 4: a = "first Destroyer"; break;
                                case 5: a = "second Destroyer"; break;
                                case 6: a = "first Submarine"; break;
                                case 7: a = "second Submarine"; break;
                                default: a = "ERR";
                            } 
                            output += "You've hit your opponent's " + a + "!\n";
                            boards[2][us[0]][us[1]] = 8;
                            boards[1][us[0]][us[1]] = 2;
                            uhc ++;
                        } else {
                            output += "You missed!\n";
                            boards[1][us[0]][us[1]] = 1;
                        }
                    } else sop("You've already fired here! Try Again!: ");
                } else sopl("Invalid location, try again!");
            } while (!wop);
            wop = false;
            do {
                int[] us = {rand.nextInt(9), rand.nextInt(9)};
                if (boards[3][us[0]][us[1]] == 0) {
                    wop = true;
                    if (boards[0][us[0]][us[1]] != 0){
                        String a;
                        switch (boards[0][us[0]][us[1]]){
                            case 1: a = "Aircraft Carrier"; break;
                            case 2: a = "Battleship"; break;
                            case 3: a = "Cruiser"; break;
                            case 4: a = "first Destroyer"; break;
                            case 5: a = "second Destroyer"; break;
                            case 6: a = "first Submarine"; break;
                            case 7: a = "second Submarine"; break;
                            default: a = "ERR";
                        } 
                        output += "Your opponent hit your " + a + "!";
                        boards[0][us[0]][us[1]] = 8;
                        boards[3][us[0]][us[1]] = 2;
                        shc ++;
                    } else {
                        output += "Computer missed!";
                        boards[3][us[0]][us[1]] = 1;
                    }
                }
            } while (!wop);
        } while (uhc != 20 && shc != 20);
        if (uhc == 20) sopl("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n CONGRATULATIONS! YOU'VE WON!");
        if (shc == 20) sopl("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n Sorry mate, you lose!");
    }
    private int[] convertLocation(String inp){
        int[] places = new int[2];
        switch(inp.toUpperCase().substring(0, 1)){
            case "A": places[0] = 0; break;
            case "B": places[0] = 1; break;
            case "C": places[0] = 2; break;
            case "D": places[0] = 3; break;
            case "E": places[0] = 4; break;
            case "F": places[0] = 5; break;
            case "G": places[0] = 6; break;
            case "H": places[0] = 7; break;
            case "I": places[0] = 8; break;
            case "J": places[0] = 9; break;
            default: places[0] = 99;
        }
        places[1] = Integer.valueOf(inp.substring(1));
        if (places[0] != 99){
            if (places[1] >= 0 && places[1] <= 9){
                return places;
            }
        }
        sopl(String.valueOf(places[0]) + " " + String.valueOf(places[1]));
        sopl(inp.toUpperCase().substring(0, 0));
        sopl(String.valueOf(Integer.valueOf(inp.substring(1))));
        return null;
    }
    private String convertBack(int a){
         switch(a){
            case 0: return "A";
            case 1: return "B";
            case 2: return "C";
            case 3: return "D";
            case 4: return "E";
            case 5: return "F";
            case 6: return "G";
            case 7: return "H";
            case 8: return "I";
            case 9: return "J";
        }
        return null;
    }
    private void printMaps(){
        String[] lines = new String[]{"Your boats:                 Your shots:", "  0 1 2 3 4 5 6 7 8 9         0 1 2 3 4 5 6 7 8 9", "  | | | | | | | | | |         | | | | | | | | | |", "A-", "B-", "C-", "D-", "E-", "F-", "G-", "H-", "I-", "J-", ""};
        for (int a = 0; a < 10; a++){
            for (int b : boards[0][a]){
                lines[a + 3] += String.valueOf(b) + " ";
            }
            lines[a + 3] += "      ";
            switch (a){
                case 0: lines[a + 3] += "A-"; break;
                case 1: lines[a + 3] += "B-"; break;
                case 2: lines[a + 3] += "C-"; break;
                case 3: lines[a + 3] += "D-"; break;
                case 4: lines[a + 3] += "E-"; break;
                case 5: lines[a + 3] += "F-"; break;
                case 6: lines[a + 3] += "G-"; break;
                case 7: lines[a + 3] += "H-"; break;
                case 8: lines[a + 3] += "I-"; break;
                case 9: lines[a + 3] += "J-"; break;
            }
        }
        for (int a = 0; a < 10; a++){
            for (int b : boards[1][a]){
                lines[a + 3] += String.valueOf(b) + " ";
            }
        }
        lines[0] += "               Boat Board Legend:";
        lines[1] += "         0: Water";
        lines[2] += "         1: Aircraft Carrier (length 5)";
        lines[3] +=  "        2: Battleship (length 4)";
        lines[4] +=  "        3: Cruiser (length 3)";
        lines[5] +=  "        4: First Destroyer (length 2)";
        lines[6] +=  "        5: Second Destroyer (length 2)";
        lines[7] +=  "        6: First Submarine (length 2)";
        lines[8] +=  "        7: Second Submarine (length 2)";
        lines[9] +=  "        8: HIT SHIP";
        lines[10] += "    Shot Board Legend:";
        lines[11] += "        0: Water";
        lines[12] += "        1: Miss";
        lines[13] += "                                                          2: Hit";
        for (String o : lines) sopl(o);
    }
    private void placeShips(){
        int[] t;
        boolean yes, y2 = false, n = true;
        String bN = "", c = "";
        int l = 6;
        for (int j = 1; j < 8; j++){
            do {
                yes = false;
                printMaps();
                switch (j){
                    case 1: bN = "Aircraft Carrier: "; break;
                    case 2: bN = "Battleship: "; break;
                    case 3: bN = "Cruiser: "; break;
                    case 4: bN = "first Destroyer: "; break;
                    case 5: bN = "second Destroyer: "; break;
                    case 6: bN = "first Submarine: "; break;
                    case 7: bN = "second Submarine: "; break;
                }
                sop("Enter a location for the nose of your " + bN);
                t = convertLocation(in.next());
                if (t != null){
                    if (boards[0][t[0]][t[1]] == 0){
                        for (int k = 1; k < l - 1; k++) if (t[1] + k >= 10 || boards[0][t[0]][t[1] + k] != 0) n = false;
                        if (n) c += "1) " + convertBack(t[0]) + (t[1] + l - 2) + "\n";
                        else n = true;
                        for (int k = 1; k < l - 1; k++) if (t[1] - k < 0 || boards[0][t[0]][t[1] - k] != 0) n = false;
                        if (n) c += "2) " + convertBack(t[0]) + (t[1] - l + 2) + "\n";
                        else n = true;
                        for (int k = 1; k < l - 1; k++) if (t[0] + k >= 10 || boards[0][t[0] + k][t[1]] != 0) n = false;
                        if (n) c += "3) " + convertBack(t[0] + l - 2) + (t[1]) + "\n";
                        else n = true;
                        for (int k = 1; k < l - 1; k++) if (t[0] - k < 0 || boards[0][t[0] - k][t[1]] != 0) n = false;
                        if (n) c += "4) " + convertBack(t[0] - l + 2) + (t[1]) + "\n";
                        else n = true;
                        do {
                            sopl(c);
                            sop("Select a location for the tail of your " + bN);
                            switch (in.nextInt()){
                                case 1:
                                    if (c.contains("1)")){
                                        for (int k = 0; k < l - 1; k++) boards[0][t[0]][t[1] + k] = j;
                                        yes = true; y2 = true;
                                    }
                                    break;
                                case 2:
                                    if (c.contains("2)")){
                                        for (int k = 0; k < l - 1; k++) boards[0][t[0]][t[1] - k] = j;
                                        yes = true; y2 = true;
                                    }
                                    break;
                                case 3:
                                    if (c.contains("3)")){
                                        for (int k = 0; k < l - 1; k++) boards[0][t[0] + k][t[1]] = j;
                                        yes = true; y2 = true;
                                    }
                                    break;
                                case 4:
                                    if (c.contains("4)")){
                                        for (int k = 0; k < l - 1; k++) boards[0][t[0] - k][t[1]] = j;
                                        yes = true; y2 = true;
                                    }
                                    break;
                                default: yes = false; y2 = false;
                            }
                            if (!yes) sopl("Invalid Entry, try again.");
                        } while (!y2);
                        y2 = false;
                        if (l != 3) l -= 1;
                        c = "";
                    } else sopl("Location is already in use!");
                } else sopl("Location is invalid!");
            } while (!yes);
        }
        y2 = false;
        n = true;
        c = "";
        l = 6;
        for (int j = 1; j < 8; j++){
            do {
                yes = false;
                t = new int[]{rand.nextInt(9), rand.nextInt(9)};
                if (boards[2][t[0]][t[1]] == 0){
                    for (int k = 1; k < l - 1; k++) if (t[1] + k >= 10 || boards[2][t[0]][t[1] + k] != 0) n = false;
                    if (n) c += "1"; else n = true;
                    for (int k = 1; k < l - 1; k++) if (t[1] - k < 0 || boards[2][t[0]][t[1] - k] != 0) n = false;
                    if (n) c += "2"; else n = true;
                    for (int k = 1; k < l - 1; k++) if (t[0] + k >= 10 || boards[2][t[0] + k][t[1]] != 0) n = false;
                    if (n) c += "3"; else n = true;
                    for (int k = 1; k < l - 1; k++) if (t[0] - k < 0 || boards[2][t[0] - k][t[1]] != 0) n = false;
                    if (n) c += "4"; else n = true;
                    do {
                        switch (rand.nextInt(3) + 1){
                            case 1:
                                if (c.contains("1")){
                                    for (int k = 0; k < l - 1; k++) boards[2][t[0]][t[1] + k] = j;
                                    yes = true; y2 = true;
                                }
                                break;
                            case 2:
                                if (c.contains("2")){
                                    for (int k = 0; k < l - 1; k++) boards[2][t[0]][t[1] - k] = j;
                                    yes = true; y2 = true;
                                }
                                break;
                            case 3:
                                if (c.contains("3")){
                                    for (int k = 0; k < l - 1; k++) boards[2][t[0] + k][t[1]] = j;
                                    yes = true; y2 = true;
                                }
                                break;
                            case 4:
                                if (c.contains("4")){
                                    for (int k = 0; k < l - 1; k++) boards[2][t[0] - k][t[1]] = j;
                                    yes = true; y2 = true;
                                }
                                break;
                            default: yes = false;  y2 = false;
                        }
                    } while (!y2);
                    y2 = false;
                    if (l != 3) l -= 1;
                    c = "";
                }
            } while (!yes);
        }
    }
    
    private void sop(String s){
        System.out.print(s);
    }
    private void sopl(String s){
        System.out.println(s);
    }
}
