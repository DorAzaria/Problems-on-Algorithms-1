package GameNumber;

import java.util.Arrays;

public class Greedy {

    public static int[] game(int[] arr) {

        int player1 = 0;
        int player2 = 0;
        int j = 0, k =0;

        for(int i = 0; i < arr.length ; i++) {

            if(arr[j] > arr[arr.length-1-k]) {

                if(i % 2 == 0) { // its player1 turn
                    player1 += arr[j];
                }
                else { // its player2 turn
                    player2 += arr[j];
                }

                j++;

            }
            else { // arr[j] <= arr[arr.length-1-k]

                if(i % 2 == 0) { // its player1 turn
                    player1 += arr[arr.length-1-k];
                }
                else { // its player2 turn
                    player2 += arr[arr.length-1-k];
                }

                k++;
            }

        }

        return new int[] {player1, player2};
    }

    public static void main(String[] args) {

        int[] arr = {5, 7, 8, 4, 9, 14, 3, 52, 16, 2};
        System.out.println(Arrays.toString(game(arr)));
    }
}
