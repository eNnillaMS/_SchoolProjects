package Bonus;
public class Lockers {
    public void main(){
        boolean[] Lockers = new boolean[201];
	for (boolean a:Lockers) a = false;
	for (int stud = 1; stud <= 200; stud++){
            for (int i = 1; i <= 200; i++){
                    if (i % stud == 0) Lockers[i] = !Lockers[i];
            }
	}
        for (boolean b:Lockers){
            if (b) System.out.println("Open");
            else System.out.println("Closed");
        }
    }
}
