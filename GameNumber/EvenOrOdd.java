package GameNumber;
import java.util.Arrays;

public class EvenOrOdd {

    public static String chooseBiggest(int[] arr) {
        int even = 0, odd = 0;

        for(int i = 0 ; i < arr.length ; i++) {
            if(i%2 == 0)
                even += arr[i];
            else
                odd += arr[i];
        }

        if(even > odd)
            return "even";
        else
            return "odd";
    }

    public static int[] game(int[] arr) {
        String playerOneTurn = chooseBiggest(arr);


        return arr;
    }


    public static void main(String[] args) {

        int[] arr = {5, 7, 8, 4, 9, 14, 3, 52, 16, 2};
        System.out.println(Arrays.toString(game(arr)));
    }
}
