package Fibonacci;

public class fiboWithMatrix {


//////////////// O(N) \\\\\\\\\\\\\\\\\\\\\\
    /**
     * Time : O(N)
     * @param n an index
     * @return the value in this index
     */
    public static int fibMatrixN(int n) {
        if (n <= 0) {
            return 0;
        }

        int[][] fiboMatrix = { {1,1}, {1,0} };

        matrixPowerN(fiboMatrix,n);

        return fiboMatrix[0][0];
    }

    /**
     *
     * @param matrix notation of linear equations represented by matrix
     *               for the Fibonacci sequence (Fn = Fn-1 + Fn-2)
     * @param n an index
     */
    private static void matrixPowerN(int[][] matrix, int n) {

        int[][] ans = { {1,1}, {1,0} };

        for (int i = 1; i < n-1; i++) {
            matrixMultiplyN(matrix,ans);
        }

    }

    /**
     * this is a private method, so we can surely assume that
     * the multiplying is defined for this matrices.
     * @param mat1 the original matrix, { {1,1}, {1,0} } .
     * @param mat2 the copied matrix, multiplied in each call.
     */
    private static void matrixMultiplyN(int[][] mat1, int[][] mat2) {

        int x =  mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        int y =  mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        int z =  mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        int w =  mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];

        mat1[0][0] = x;
        mat1[0][1] = y;
        mat1[1][0] = z;
        mat1[1][1] = w;
    }
//////////////////////////////////////////////////////////////////////////

//////////////// O(log N) \\\\\\\\\\\\\\\\\\\\\\
    /**
     * Time : O(log N)
     * @param n an index
     * @return the value in this index
     */
    public static int fibMatrixLog(int n) {
        if (n <= 0) {
            return 0;
        }

        int[][] fiboMatrix = { {1,1}, {1,0} };

        matrixPowerLog(fiboMatrix,n-1);

        return fiboMatrix[0][0];
    }


    /**
     *
     * @param matrix notation of linear equations represented by matrix
     *               for the Fibonacci sequence (Fn = Fn-1 + Fn-2)
     * @param n an index
     */
    private static void matrixPowerLog(int[][] matrix, int n) {

        if(n == 0 || n == 1)
            return;

        int[][] ans = { {1,1}, {1,0} };

        matrixPowerLog(matrix, n/2);
        matrixMultiplyLog(matrix,matrix);

        if(n%2 != 0) {
            matrixMultiplyLog(matrix,ans);
        }

    }

    /**
     * this is a private method, so we can surely assume that
     * the multiplying is defined for this matrices.
     * @param mat1 the original matrix, { {1,1}, {1,0} } .
     * @param mat2 the copied matrix, multiplied in each call.
     */
    private static void matrixMultiplyLog(int[][] mat1, int[][] mat2) {

        int x =  mat1[0][0] * mat2[0][0] + mat1[0][1] * mat2[1][0];
        int y =  mat1[0][0] * mat2[0][1] + mat1[0][1] * mat2[1][1];
        int z =  mat1[1][0] * mat2[0][0] + mat1[1][1] * mat2[1][0];
        int w =  mat1[1][0] * mat2[0][1] + mat1[1][1] * mat2[1][1];

        mat1[0][0] = x;
        mat1[0][1] = y;
        mat1[1][0] = z;
        mat1[1][1] = w;
    }

//////////////////////////////////////////////////////////////////////////


    public static void main(String[] args) {
        System.out.println(fibMatrixN(6));
        System.out.println(fibMatrixLog(6));
    }
}
