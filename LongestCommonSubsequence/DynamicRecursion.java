package LongestCommonSubsequence;

import java.util.HashSet;
public class DynamicRecursion {

    public static int[][] generateMatrix(String X, String Y) {
        int[][] matrix = new int[X.length()+1][Y.length()+1];
        for(int i = 0 ; i < matrix.length; i++)
            matrix[i][0] = 0;
        for(int i = 0 ; i < matrix[0].length; i++)
            matrix[0][i] = 0;
        generateRec(matrix, X, Y, 1,1);
        return matrix;
    }

    public static void generateRec(int[][] matrix, String X, String Y, int i , int j) {
        if(i == matrix.length)
            return;
        if(j == matrix[0].length) {
            generateRec(matrix, X, Y, i + 1, 1);
        }
        else {
            if (X.charAt(i - 1) == Y.charAt(j - 1))
                matrix[i][j] = matrix[i - 1][j - 1] + 1;
            else
                matrix[i][j] = Math.max(matrix[i][j - 1], matrix[i - 1][j]);

            generateRec(matrix, X, Y, i, j + 1);
        }
    }

    public static String dynamicRec(int[][] matrix, String X, String Y, int i, int j, int length) {
        if(length == 0)
            return "";

        if(X.charAt(i-1) == Y.charAt(j-1))
            return dynamicRec(matrix,X,Y,i-1,j-1,length-1) + X.charAt(i-1);

        if(matrix[i][j-1] > matrix[i-1][j])
            return dynamicRec(matrix,X,Y,i,j-1,length);

        return dynamicRec(matrix,X,Y,i-1,j,length);
    }

    public static String dynamic(String X, String Y) {
        int[][] matrix = generateMatrix(X,Y);
        int n = X.length(), m = Y.length();
        return dynamicRec(matrix, X, Y, n, m, matrix[n][m]);
    }

    public static void getAllRec(int[][] matrix, String X, String Y, int i , int j, HashSet<String> set) {
        if(i == 0 || j == 0)
            return;

        int n = X.length(), m = Y.length();
        if(matrix[i][j] == matrix[n][m]) {
            set.add(dynamicRec(matrix,X,Y,i,j,matrix[n][m]));

            getAllRec(matrix,X,Y,i-1,j,set);
            getAllRec(matrix,X,Y,i,j-1,set);
            getAllRec(matrix,X,Y,i-1,j-1,set);
        }
    }

    public static HashSet<String> getAllLCS(String X, String Y) {
        int[][] matrix = generateMatrix(X,Y);
        int n = X.length(), m = Y.length();
        HashSet<String> set = new HashSet<>();
        getAllRec(matrix, X, Y, n, m, set);
        return set;
    }

    public static void main(String[] args) {
        String X = "abcbdab", Y = "bdcaba";
        System.out.println(dynamic(X,Y)); // bcba
        HashSet<String> set = getAllLCS(X,Y);
        for (String str : set) {
            System.out.print(str + " , ");
        }
    }
}
