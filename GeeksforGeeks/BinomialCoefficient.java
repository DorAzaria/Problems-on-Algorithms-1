package GeeksforGeeks;

public class BinomialCoefficient {

    /**
     * Write a function that takes two parameters n and k and returns
     * the value of Binomial Coefficient C(n, k).
     * For example, your function should return 6 for n = 4 and k = 2,
     * and it should return 10 for n = 5 and k = 2.
     *    C(n, k) = C(n-1, k-1) + C(n-1, k)
     *    C(n, 0) = C(n, n) = 1
     */

    //Overlapping
    public static int overlapping(int n, int k) {
        if(k == 0 || k == n) {
            return 1;
        }
        return overlapping(n-1,k) + overlapping(n-1,k-1);
    }

    //Dynamic O(n*m)
    public static int dynamic(int nn, int kk) {

        int[][] matrix = new int[nn+1][kk+1];

        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }

        for(int n = 1 ; n < matrix.length; n++) {
            for(int k = 1 ; k < matrix[0].length; k++) {
                if(k == n) { // Best Case
                    matrix[n][k] = 1;
                }
                else {
                    matrix[n][k] = matrix[n-1][k-1] + matrix[n-1][k];
                }
            }
        }
        print(matrix);
        return matrix[nn][kk];
    }


    public static int dynamicRec(int n, int k) {
        int[][] matrix = new int[n+1][k+1];

        for(int i = 0; i < matrix.length; i++) {
            matrix[i][0] = 1;
        }

        recursive(matrix,1,1);
        print(matrix);

        return matrix[n][k];
    }

    public static void recursive(int[][] matrix, int n, int k) {
        if(n == matrix.length){
            return;
        }
        if(k == matrix[0].length) {
            recursive(matrix,n+1,1);
        }
        else {
            if(n == k) {
                matrix[n][k] = 1;
            } else {
                matrix[n][k] = matrix[n-1][k-1] + matrix[n-1][k];
            }
            recursive(matrix,n,k+1);
        }
    }

    public static void print(int[][] matrix) {

        for(int i = 0 ; i < matrix.length ; i++) {
            for(int j = 0; j < matrix[0].length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 5;
        int k = 2;
        System.out.println(overlapping(n,k));
        System.out.println(dynamic(n,k));
        System.out.println(dynamicRec(n,k));
    }
}
