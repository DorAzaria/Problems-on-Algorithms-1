package LCS_LongestCommonSubsequence;

public class DynamicInduction {

    public static int[][] generateMatrix(String X, String Y) {

        int[][] matrix = new int[X.length() + 1][Y.length() + 1];
        for(int i = 0 ; i < matrix.length; i++)
            matrix[i][0] = 0;
        for(int i = 0 ; i < matrix[0].length; i++)
            matrix[0][i] = 0;

        for(int i = 1 ; i < matrix.length ; i++) {
            for(int j = 1 ; j < matrix[0].length; j++) {

                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i][j-1],matrix[i-1][j]);
                }
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return matrix;
    }

    public static String dynamic(String X, String Y) {
        String ans = "";
        int[][] matrix = generateMatrix(X,Y);
        int length = matrix[X.length()][Y.length()];
        int i = X.length(), j = Y.length();
        while(length > 0) {
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                ans = X.charAt(i-1) + ans;
                i--;
                j--;
                length--;
            } else if(matrix[i][j-1] > matrix[i-1][j]) {
                j--;
            } else {
                i--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String X = "abcbdab", Y = "bdcaba";
        System.out.println(dynamic(X,Y)); // bcba
    }
}
