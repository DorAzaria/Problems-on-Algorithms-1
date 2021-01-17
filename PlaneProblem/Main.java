package PlaneProblem;

public class Main {

    public static void printMatrix(Node[][] matrix) {
        System.out.println("\n===== Print Matrix ====");
        for(int i = 0; i < matrix.length; i++) { // O(N*M)
            for(int j = 0; j < matrix[0].length; j++) {
                Node n = matrix[i][j];
                System.out.print("(rt="+n.goRight+", dn="+n.goDown+
                        ", ey="+n.entry+", ph="+n.numOfPaths+")\t");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node[][] matrix = test.getTest1();
        GenerateInduction.generateMatrix(matrix);
        printMatrix(matrix);

        // Inductive
        System.out.println(pathsInduction.getCornerPath(matrix));
        pathsInduction.getAllPaths(matrix);
        System.out.println(pathsInduction.getPath(matrix,2,1));

        // Recursive
        System.out.println(pathsRecursion.getCornerPath(matrix));
        pathsRecursion.getAllPaths(matrix);
        System.out.println(pathsRecursion.getOnePath(matrix,2,1));
    }

}
