package GameNumber;

import java.util.Arrays;

public class Dynamic {


    public static int[] dynamic(int[] arr) {

        int[][] mat = new int[arr.length][arr.length];

        for(int i = 0; i < arr.length; i++) {
            mat[i][i] = arr[i];
        }
        for(int i = arr.length - 2 ; i >= 0 ; i--) {
            for(int j = i + 1 ; j < arr.length; j++) {
                mat[i][j] = Math.max(mat[i][i] - mat[i+1][j] , mat[j][j] - mat[i][j-1]);
            }
        }
        return game(mat);
    }

    public static int[] game(int[][] matrix) {
        int player1 = 0, player2 = 0, games = 0;
        int left = 0, right = matrix.length-1;
        String p1_path = "" , p2_path = "";
        while (games != matrix.length) {

            if(left == right) {
                player2 += matrix[left][left];
                break;
            }

            if (matrix[left][right] == matrix[left][left] - matrix[left + 1][right]) {
                if(games % 2 == 0) { // Player1 turn
                    player1 += matrix[left][left];
                    p1_path += matrix[left][left] + " ";
                }
                else  { // Player2 turn
                    player2 += matrix[left][left];
                    p2_path += matrix[left][left] + " ";
                }
                left++;
            }
            else {
                if(games % 2 == 0) { // Player1 turn
                    player1 += matrix[right][right];
                    p1_path += matrix[right][right] + " ";
                }
                else {// Player2 turn
                    player2 += matrix[right][right];
                    p2_path += matrix[right][right] + " ";

                }
                right--;
            }
            games++;
        }
        return new int[] {player1,player2};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dynamic(new int[] {1,3,6,1,3,6})));
        System.out.println(Arrays.toString(dynamic(new int[] {5,4,1,5,6,4})));
        System.out.println(Arrays.toString(dynamic(new int[] {4,1,5,9})));
    }

}
