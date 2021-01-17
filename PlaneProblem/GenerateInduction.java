package PlaneProblem;

public class GenerateInduction {

    public static void generateMatrix(Node[][] matrix) {

        for(int i = 1 ; i < matrix.length; i++) { // O(N)
            matrix[i][0].entry = matrix[i-1][0].entry + matrix[i-1][0].goDown;
        }
        for(int i = 1 ; i < matrix[0].length; i++) { // O(M)
            matrix[0][i].entry = matrix[0][i-1].entry + matrix[0][i-1].goRight;
        }

        for(int i = 1; i < matrix.length; i++) { // O(N*M)
            for(int j = 1; j < matrix[0].length; j++) {
                int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
                int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;
                matrix[i][j].entry = Math.min(fromAbove,fromLeft);

                int leftPaths = matrix[i][j-1].numOfPaths;
                int abovePaths = matrix[i-1][j].numOfPaths;
                if(fromAbove > fromLeft) {
                    matrix[i][j].numOfPaths = leftPaths;
                }
                else if(fromAbove < fromLeft) {
                    matrix[i][j].numOfPaths = abovePaths;
                }
                else { // if they got the same weight of path.
                    matrix[i][j].numOfPaths = abovePaths + leftPaths;
                }
            }
        }
    }

}
