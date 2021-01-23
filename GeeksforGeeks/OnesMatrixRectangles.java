package GeeksforGeeks;

public class OnesMatrixRectangles {
    /**
     * Number of rectangles in ones-zeros matrix
     * Complexity: O(n*m)
     */
    public static int numOfRectangles(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j] == 1) {
                    if((i == 0 || mat[i-1][j] == 0) && (j == 0 || mat[i][j-1] == 0)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        /// tt
        int[][] mat = {
                {1,0,1,0,0},
                {0,0,1,0,1},
                {0,0,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,1}};
        System.out.println(numOfRectangles(mat));
    }
}
