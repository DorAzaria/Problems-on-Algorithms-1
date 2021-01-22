package GeeksforGeeks;

public class MinCostPath {

    /**
     * Given a cost matrix cost[][] and a position (m, n) in cost[][],
     * write a function that returns cost of minimum cost path to reach (m, n) from (0, 0).
     * Each cell of the matrix represents a cost to traverse through that cell.
     * The total cost of a path to reach (m, n) is the sum of all the costs on that path
     * (including both source and destination).
     * You can only traverse down, right and diagonally lower cells from a given cell,
     * i.e., from a given cell (i, j), cells (i+1, j), (i, j+1), and (i+1, j+1) can be traversed.
     * You may assume that all costs are positive integers.
     */

    // Overlapping - the time complexity of this naive recursive solution is exponential and it is terribly slow.
    public static int minCostPath(int[][] matrix, int i, int j) {
        if(i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }
        if(i == 0 && j == 0) {
            return matrix[i][j];
        }
        else {
           int fromAbove = minCostPath(matrix,i-1,j);
           int fromLeft = minCostPath(matrix, i,j-1);
           int fromDiag = minCostPath(matrix,i-1,j-1);

           return matrix[i][j] + min(fromAbove,fromLeft , fromDiag);
        }

    }

    public static int min(int x, int y, int z) {
        int min = x;
        if(min > y) {
            min = y;
        }
        if(min > z) {
            min = z;
        }
        return min;
    }

    // O(N*M)
    public static int dynamic(int[][] matrix, int ii, int jj) {

        int[][] cost = new int[ii+1][jj+1];
        cost[0][0] = matrix[0][0];

        for(int i = 1 ; i < cost.length; i++) {
            cost[i][0] = matrix[i][0] + cost[i-1][0];
        }

        for(int j = 1; j < cost[0].length; j++) {
            cost[0][j] = matrix[0][j] + cost[0][j-1];
        }

        for(int i = 1 ; i < cost.length; i++) {
            for(int j = 1 ; j < cost[0].length; j++) {

                int fromAbove = cost[i-1][j];
                int fromLeft = cost[i][j-1];
                int fromDiag = cost[i-1][j-1];
                cost[i][j] = min(fromAbove,fromDiag,fromLeft) + matrix[i][j];
            }
        }

//        print(cost);
        return cost[ii][jj];
    }

    public static void print(int[][] matrix) {

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0 ; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,8,2},{1,5,3}};
        // OVERLAPPING
        System.out.println(minCostPath(matrix,2,2));
        // DYNAMIC
        System.out.println(dynamic(matrix,2,2));
    }
}
