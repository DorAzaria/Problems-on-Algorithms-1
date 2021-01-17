package LargestSquareOfOnes;

public class ThreeMatrices {

    public static int solution(int[][] A) {
        printMatrix(A);
        int[][] D = generateD(A);
        printMatrix(D);
        return getBiggest(D);
    }


    public static void printMatrix(int[][] mat) {

        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    //Rows
    public static int[][] generateB(int[][] A) {
        int[][] B = new int[A.length][A[0].length];

        for(int i = 0 ; i < A.length; i++) {
            B[i][0] = A[i][0];
        }
        for(int i=0; i < A.length; i++) {
            for(int j=1; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    B[i][j] = B[i][j-1] + 1;
                }
            }
        }

        return B;
    }

    //Columns
    public static int[][] generateC(int[][] A) {
        int[][] C = new int[A.length][A[0].length];

        for(int i = 0 ; i < A[0].length; i++) {
            C[0][i] = A[0][i];
        }
        for(int i=1; i < A.length; i++) {
            for(int j=0; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    C[i][j] = C[i-1][j] + 1;
                }
            }
        }
        return C;
    }

    // solution matrix
    public static int[][] generateD(int[][] A) {
        int[][] B = generateB(A); // rows
        int[][] C = generateC(A); // columns
        int[][] D = new int[A.length][A[0].length];

        for(int i = 0 ; i < A.length; i++) {
            D[i][0] = A[i][0];
        }
        for(int i = 0 ; i < A[0].length; i++) {
            D[0][i] = A[0][i];
        }
        for(int i=1; i < A.length; i++) {
            for(int j=1; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    D[i][j] = min(B[i][j],C[i][j],D[i-1][j-1] +1) ;
                }
            }
        }
        return D;
    }

    public static int min(int b, int c, int d) {
        int min = b;
        if(min > c) min = c;
        if(min > d) min = d;
        return min;
    }

    public static int getBiggest(int[][] D) {
        int max = 0;

        for(int i = 0 ; i < D.length; i++) {
            for(int j = 0 ; j < D[0].length; j++) {
                if(D[i][j] > max)
                    max = D[i][j];
            }
        }

        return max;
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
