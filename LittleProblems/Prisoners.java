package LittleProblems;
import java.util.Random;

public class Prisoners {
    //lamp is known
    public static boolean prisoners(int n) {
        Random rand = new Random();
        boolean[] prisoners = new boolean[n];
        for (int i = 0; i < n; i++) {
            prisoners[i] = false;
        }
        int counter = 0;
        boolean lamp = true;
        while (counter < n) {
            int prisoner = rand.nextInt(n);
            if (prisoner == 0) {
                if (!prisoners[prisoner]) {
                    prisoners[prisoner] = true;
                    counter++;
                }
                if (!lamp) {
                    counter++;
                    lamp = true;
                }
            } else {
                if (!prisoners[prisoner] && lamp) {
                    lamp = false;
                    prisoners[prisoner] = true;
                }
            }

        }
        for (boolean prisoner : prisoners) {
            if (!prisoner) {
                return false;
            }

        }
        return true;
    }
    //lamp isn't known
    public static boolean prisoners2(int n){
        Random rand = new Random();
        int prisoners[] = new int[n];
        for(int prisoner: prisoners){
            prisoner = 0;
        }
        int counter = 0;
        boolean lamp = rand.nextBoolean();
        while(counter < 2*n-1){
            int prisoner = rand.nextInt(n);
            if(prisoner == 0 && !lamp){
                lamp = true;
                counter++;
                if(prisoners[prisoner] == 0){
                    prisoners[prisoner]++;


                }

            }
            else{
                if (prisoners[prisoner] < 2 && lamp){
                    prisoners[prisoner] ++;
                    lamp = false;
                }
            }

        }
        for(int prisoner : prisoners){
            if (prisoner == 0){return false;}
        }
        return true;
    }

    public static void main(String[] args) {
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.print(prisoners2(rand.nextInt(1000))+" ");
        }
    }

}
