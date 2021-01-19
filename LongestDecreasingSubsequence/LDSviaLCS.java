package LongestDecreasingSubsequence;
import java.util.Arrays;

public class LDSviaLCS {

    public static int[] LCS(int[] X) {
        int[] temp_Y = new int[X.length];

        for(int i = 0; i < X.length; i++)
            temp_Y[i] = X[i];

        Arrays.sort(temp_Y);

        int[] Y = new int[X.length];

        for(int i = X.length-1; i >= 0 ; i--) {
            Y[X.length-1-i] = temp_Y[i];
        }

        int[][] matrix = new int[X.length+1][Y.length+1];
        generateMatrix(matrix,X,Y,1,1);

        int i = matrix.length - 1;
        int j = matrix.length - 1;
        int end = matrix[i][j];
        int start = 0;
        int[] solution = new int[end];

        while(start < end) {
            if(X[i-1] == Y[j-1]) {
                solution[end-start-1] = X[i-1];
                i--;
                j--;
                start++;
            }
            else if(matrix[i-1][j] >= matrix[i][j-1]) {
                i--;
            }
            else {
                j--;
            }
        }

        return solution;
    }

    public static void generateMatrix(int[][] matrix, int[] X, int[] Y, int i, int j) {
        if(i == matrix.length)
            return;
        if(j == matrix.length) {
            System.out.println();
            generateMatrix(matrix,X,Y,i+1,1);
        } else {
            if(X[i-1] == Y[j-1]) {
                matrix[i][j] = matrix[i-1][j-1] + 1;
            }else {
                matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
            }
            System.out.print(matrix[i][j] + " ");
            generateMatrix(matrix,X,Y,i,j+1);
        }
    }
    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 101, 100, 1};
        System.out.println(Arrays.toString(LCS(arr)));
        // prints [7, 6, 5, 4, 3, 2, 1]
    }
}
