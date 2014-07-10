package Ch8.Ex6GameOf21;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
public class Ex6 {
    private final boolean[][] deck = new boolean[4][13];
    private final List<Integer[]> pHand = new ArrayList<>();
    private final List<Integer[]> pHand2 = new ArrayList<>();
    private final List<Integer[]> sHand = new ArrayList<>();
    private final Scanner in = new Scanner(System.in);
    private boolean hidden = true;
    private int cash = 10000, bet, mult1 = 2, mult2 = 2;
    public void main(){
        boolean keepPlaying;
        do {
            do {
                System.out.print("\n\n\nYour money: " + cash + "\nEnter your bet: ");
                bet = in.nextInt();
            } while (!(bet <= cash && bet > 0));
            cash -= bet;
            sHand.add(drawCard());
            sHand.add(drawCard());
            pHand.add(drawCard());
            pHand.add(drawCard());
            int pScore = getScore(pHand), pScore2 = 0;
            System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand));
            System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")\n");
            System.out.print("You can: Stand(0), Hit(1), DoubleDown(2)");
            if (Objects.equals(pHand.get(0)[1], pHand.get(1)[1]) && (cash - bet) >= 0) System.out.print(", Split(3)\n");
            else System.out.print("\n");
            System.out.print("Enter your choice: ");
            switch (in.nextInt()){
                case 0: default:
                    break;
                case 1:
                    boolean stand = false;
                    while (!stand && pScore < 21 && pHand.size() < 5){
                        pHand.add(drawCard());
                        pScore = getScore(pHand);
                        if (pScore < 21){
                            System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand));
                            System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")\n");
                            System.out.print("You can: Stand(0), Hit(1)\nEnter your choice:");
                            if (in.nextInt() != 1) stand = true;
                        }
                    }
                    break;
                case 2:
                    mult1 += 1;
                    cash -= bet;
                    bet *= 2;
                    pHand.add(drawCard());
                    break;
                case 3:
                    if (Objects.equals(pHand.get(0)[1], pHand.get(1)[1]) && (cash - bet) >= 0){
                        pHand2.add(pHand.get(1));
                        pHand.remove(1);
                        pHand.add(drawCard());
                        pHand2.add(drawCard());
                        pScore = getScore(pHand);
                        pScore2 = getScore(pHand2);
                        System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand));
                        System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")");
                        System.out.println("Your Split:       " + printHand(pHand2) + "   (" + pScore2 + ")\n");
                        System.out.print("You can: Stand(0), Hit(1), DoubleDown(2)\nEnter your choice (Hand 1): ");
                        switch (in.nextInt()){
                            case 0: default:
                                break;
                            case 1:
                                boolean stand2 = false;
                                while (!stand2 && pScore < 21 && pHand.size() < 5){
                                    pHand.add(drawCard());
                                    pScore = getScore(pHand);
                                    if (pScore < 21){
                                        System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand));
                                        System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")");
                                        System.out.println("Your Split:       " + printHand(pHand2) + "   (" + pScore2 + ")\n");
                                        System.out.print("You can: Stand(0), Hit(1)\nEnter your choice (Hand 1):");
                                        if (in.nextInt() != 1) stand2 = true;
                                    }
                                }
                                break;
                            case 2:
                                mult1 *= 2;
                                cash -= bet;
                                pHand.add(drawCard());
                                pScore = getScore(pHand);
                                break;
                        }
                        System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand));
                        System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")");
                        System.out.println("Your Split:       " + printHand(pHand2) + "   (" + pScore2 + ")\n");
                        System.out.print("You can: Stand(0), Hit(1), DoubleDown(2)\nEnter your choice (Hand 2): ");
                        switch (in.nextInt()){
                            case 0: default:
                                break;
                            case 1:
                                boolean stand2 = false;
                                while (!stand2 && pScore2 < 21 && pHand2.size() < 5){
                                    pHand2.add(drawCard());
                                    pScore2 = getScore(pHand2);
                                    if (pScore2 < 21){
                                        System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand));
                                        System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")");
                                        System.out.println("Your Split:       " + printHand(pHand2) + "   (" + pScore2 + ")\n");
                                        System.out.print("You can: Stand(0), Hit(1)\nEnter your choice (Hand 2):");
                                        if (in.nextInt() != 1) stand2 = true;
                                    }
                                }
                                break;
                            case 2:
                                mult1 *= 2;
                                cash -= bet;
                                pHand2.add(drawCard());
                                break;
                        }
                    }
                    break;
            }
            dealerTurn();
            if (getScore(pHand2) == 0) System.out.print("   ");
            else System.out.print("\n");
            System.out.print("Keep playing? (1 - yes, 0 - no): ");
            keepPlaying = (in.nextInt() == 1);
            if (cash == 0) System.out.println("You are all out of money! Exiting program!");
            clearHnD();
        } while (keepPlaying && cash != 0);
    }
    private void clearHnD(){
        for (int a = 0; a < 4; a++) for (int b = 0; b < 13; b++) deck[a][b] = false;
        pHand.clear();
        pHand2.clear();
        mult1 = 2;
        mult2 = 2;
        sHand.clear();
        hidden = true;
    }
    private Integer[] drawCard(){
        boolean used;
        Integer[] card = new Integer[2];
        do {
            Random r = new Random();
            card[0] = r.nextInt(3);
            card[1] = r.nextInt(12);
            used = deck[card[0]][card[1]];
        } while (used == true);
        deck[card[0]][card[1]] = true;
        return card;
    }
    private int getScore(List<Integer[]> Hand){
        int s = 0, a = 0;
        for (Integer[] i : Hand){
            if (i[1] > 9) s += 10;
            else if (i[1] <= 9 && i[1] > 0) s += i[1] + 1;
            else if (i[1] == 0) a += 1;
        }
        for (int i = 0; i < a; i++){
            if (s + 11 <= 21) s += 11;
            else s++;
        }
        return s;
    }
    private String printHand(List<Integer[]> Hand){
        String o = "";
        for (Integer[] card : Hand){
            o += getValue(card);
            if (getValue(card).length() == 2) o += "   ";
            else o += "  ";
        }
        return o;
    }
    private String printHandH1(List<Integer[]> Hand){
        if (!hidden) return printHand(Hand);
        else {
            return "**" + printHand(Hand).substring(printHand(Hand).indexOf(" "));
        }
    }
    private String getValue(Integer[] card){
        String o = "", k;
        switch (card[0]){
            case 0: o += "\u2660"; break; //Spade
            case 1: o += "\u2665"; break; //Heart
            case 2: o += "\u2663"; break; //Club
            case 3: o += "\u2666"; break; //Diamond
        }
        switch (card[1]){
            case 0: k = "A"; break;
            case 10: k = "J"; break;
            case 11: k = "Q"; break;
            case 12: k = "K"; break;
            default: k = String.valueOf(card[1] + 1); break;
        }
        o += k;
        return o;
    }
    private void dealerTurn(){
        hidden = false;
        while (getScore(sHand) < 17){
            sHand.add(drawCard());
        }
        int pScore = getScore(pHand), pScore2 = getScore(pHand2), sScore = getScore(sHand);
        System.out.println("\n\n\nDealer's hand:    " + printHandH1(sHand) + "   (" + sScore + ")");
        System.out.println("Your Hand:        " + printHand(pHand) + "   (" + pScore + ")");
        if (pScore2 != 0) System.out.print("Your Split:       " + printHand(pHand2) + "   (" + pScore2 + ")\n\n\nHand 1: ");
        else System.out.println("");
        if (pScore > 21){
            System.out.print("You've Busted! ");
        } else if (pHand.size() == 5){
            System.out.print("5 Card Charlie!! You win! ");
            cash += bet * mult1;
        } else if(pScore == 21 && pScore != sScore){
            System.out.print("Blackjack!! You win!");
            cash += bet * (mult1 + 1);
        } else if (sScore > 21){
            System.out.print("Dealer Busted! You've won! ");
            cash += bet * mult1;
        } else if (sHand.size() == 5){
            System.out.print("5 Card Charlie!! Dealer wins! ");
        } else if(sScore == 21){
            System.out.print("Dealer Blackjack!! You lose!");
        } else if (sScore > pScore){
            System.out.print("Dealer Wins! ");
        } else if (sScore == pScore){
            System.out.print("Push! ");
            cash += bet;
        } else {
            System.out.print("You've won! ");
            cash += bet * mult1;
        }
        if (pScore2 != 0){
            System.out.print("\nHand 2: ");
            if (pScore2 > 21){
                System.out.print("You've Busted! ");
            } else if (pHand2.size() == 5){
                System.out.print("5 Card Charlie!! You win! ");
                cash += bet * mult2;
            } else if(pScore2 == 21 && pScore2 != sScore){
                System.out.print("Blackjack!! You win!");
                cash += bet * (mult2 + 1);
            } else if (sScore > 21){
                System.out.print("Dealer Busted! You've won! ");
                cash += bet * mult2;
            } else if (sHand.size() == 5){
                System.out.print("5 Card Charlie!! Dealer wins! ");
            } else if(sScore == 21){
                System.out.print("Dealer Blackjack!! You lose!");
            } else if (sScore > pScore2){
                System.out.print("Dealer Wins! ");
            } else if (sScore == pScore2){
                System.out.print("Push! ");
                cash += bet;
            } else {
                System.out.print("You've won! ");
                cash += bet * mult2;
            }
        }
    }
}