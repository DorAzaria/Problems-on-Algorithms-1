package PlaneProblem;

public class GenerateRecursion {

    private static void generateRec(Node[][] matrix, int i, int j) {
        if(i == matrix.length)
            return;
        if(j == matrix.length) {
            generateRec(matrix,i+1,1);
        }
        else {
            matrix[i][j].setLocation(i,j); // not a part of the algorithm, used for printing later.

            int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
            int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;
            matrix[i][j].entry = Math.min(fromAbove,fromLeft);

            int abovePaths = matrix[i-1][j].numOfPaths;
            int leftPaths = matrix[i][j-1].numOfPaths;
            if(fromAbove > fromLeft){
                matrix[i][j].numOfPaths = leftPaths;
            } else if(fromAbove < fromLeft) {
                matrix[i][j].numOfPaths = abovePaths;
            } else {
                matrix[i][j].numOfPaths = leftPaths + abovePaths;
            }
            generateRec(matrix,i,j+1);
        }
    }

    public static void generateMatrix(Node[][] matrix) {
        for(int i = 1 ; i < matrix.length; i++) {
            matrix[i][0].entry = matrix[i - 1][0].entry + matrix[i - 1][0].goDown;
            matrix[i][0].setLocation(i,0); // not a part of the algorithm, used for printing later.
        }
        for(int j = 1 ; j < matrix[0].length; j++) {
            matrix[0][j].entry = matrix[0][j - 1].entry + matrix[0][j - 1].goRight;
            matrix[0][j].setLocation(0,j); // not a part of the algorithm, used for printing later.
        }
        generateRec(matrix,1,1);
    }

}
