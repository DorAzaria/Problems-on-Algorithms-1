package GameNumber;

import java.util.Arrays;

public class Greedy {

    public static int[] game(int[] arr) {
        int player1 = 0, player2 = 0, games = 0;
        int left_corner = 0, right_corner = arr.length-1;

        while (games != arr.length) {

            if(games % 2 == 0) {
                if(arr[left_corner] > arr[right_corner]) {
                    player1 += arr[left_corner];
                    left_corner++;
                }else {
                    player1 += arr[right_corner];
                    right_corner--;
                }
            }
            else {
                if(arr[left_corner] > arr[right_corner]) {
                    player2 += arr[left_corner];
                    left_corner++;
                }else {
                    player2 += arr[right_corner];
                    right_corner--;
                }
            }
            games++;
        }

        return new int[] {player1,player2};
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 8, 4, 9, 14, 3, 52, 16, 2};
        System.out.println(Arrays.toString(game(arr)));
    }
}
