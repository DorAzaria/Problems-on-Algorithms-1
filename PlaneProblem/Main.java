package PlaneProblem;

public class Main {

    public static void printMatrix(Node[][] matrix) {
        System.out.println("\n===== Print Matrix ====");
        for(int i = 0; i < matrix.length; i++) { // O(N*M)
            for(int j = 0; j < matrix[0].length; j++) {
                Node n = matrix[i][j];
                System.out.print(n + ":{ rt="+n.goRight+", dn="+n.goDown+
                        ", ey="+n.entry+", ph="+n.numOfPaths+" } \t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void runTest(Node[][] matrix) {
        GenerateInduction.generateMatrix(matrix);
        printMatrix(matrix);

        // Inductive
        pathsInduction.getCornerPath(matrix);
        pathsInduction.getAllPaths(matrix);
        pathsInduction.getPathOfNode(matrix,2,1);

        // Recursive
        pathsRecursion.getCornerPath(matrix);
        pathsRecursion.getAllPaths(matrix);
        pathsRecursion.getPathOfNode(matrix,2,1);
    }

    public static void main(String[] args) {
        System.out.println("########################### TEST 1 ###########################");
        runTest(test.getTest1());
        System.out.println("\n\n########################### TEST 2 ###########################");
        runTest(test.getTest2());
        System.out.println("\n\n########################### TEST 3 ###########################");
        runTest(test.getTest3());
    }

}
