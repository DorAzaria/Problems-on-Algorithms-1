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

    public static void runInductionTest(Node[][] matrix) {
        // Inductive
        GenerateInduction.generateMatrix(matrix);
        printMatrix(matrix);
        pathsInduction.getCornerPath(matrix);
        pathsInduction.getAllPaths(matrix);
        pathsInduction.getPathOfNode(matrix,2,1);
        System.out.println("----> is not path? " + pathsInduction.isOnPath(matrix,2,2,1,1));
    }

    public static void runRecursionTest(Node[][] matrix) {
        // Recursive
        GenerateInduction.generateMatrix(matrix);
        pathsRecursion.getCornerPath(matrix);
        pathsRecursion.getAllPaths(matrix);
        pathsRecursion.getPathOfNode(matrix,2,1);
        System.out.println("----> is not path? " + pathsRecursion.isOnPath(matrix,2,2,1,1));
    }


        public static void main(String[] args) {
        System.out.println("########################### TEST 1 ###########################");
        runInductionTest(test.getTest1());
        runRecursionTest(test.getTest1());
        System.out.println("\n\n########################### TEST 2 ###########################");
        runInductionTest(test.getTest2());
        runRecursionTest(test.getTest2());
        System.out.println("\n\n########################### TEST 3 ###########################");
        runInductionTest(test.getTest3());
        runRecursionTest(test.getTest3());

        }

}
