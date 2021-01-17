package LargestSquareOfOnes;

public class LargestSquare {

    public static int solution(int[][] A) {
        int max = 0;
        int[][] D = new int[A.length][A[0].length];

        for(int i = 0 ; i < A.length; i++) {
            D[i][0] = A[i][0];
            D[0][i] = A[0][i];
        }

        for(int i = 1 ; i < A.length; i++) {
            for(int j = 1 ; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    D[i][j] = min(D[i-1][j], D[i][j-1], D[i-1][j-1]) + 1;
                    if(D[i][j] > max)
                        max = D[i][j];
                }
            }
        }

        return max;
    }

    public static int min(int a, int b, int c) {
        int min = a;
        if(min > b) min = b;
        if(min > c) min = c;
        return min;
    }
    public static void main(String[] args) {

        int[][] A = {{1,1,0,0,0},
                {1,1,1,1,1},
                {0,1,1,1,0},
                {1,1,1,1,1},
                {0,1,0,0,0}};
        System.out.println("the biggest square is: " +solution(A));
    }
}
