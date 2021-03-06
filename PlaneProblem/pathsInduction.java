package PlaneProblem;

import java.util.HashSet;
import java.util.Vector;

public class pathsInduction {

    public static void getCornerPath(Node[][] matrix) {
        int i = matrix.length-1, j = matrix[0].length-1;
        System.out.println("\n===== getCornerPath ("+i+","+j+") inductive =========");

        getPathOfNode(matrix,i,j);
    }

    public static void getPathOfNode(Node[][] matrix, int i, int j) {
        if(i < matrix.length && j < matrix[0].length) {
            Vector<Node> vector = new Vector<>();
            Node source = matrix[i][j];
            int tempi = i, tempj = j;

            while(i != 0 || j != 0) {
                vector.add(matrix[i][j]);
                if(i == 0) {
                    j--;
                } else if(j == 0) {
                    i--;
                } else {

                    int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;
                    int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;

                    if(fromAbove > fromLeft) {
                        j--;
                    } else if(fromAbove < fromLeft) {
                        i--;
                    } else {
                        i--;
                        j--;
                    }

                }

            }
            vector.add(matrix[i][j]);
            source.myShortestPath.add(vector);
            printPaths(source, tempi, tempj);
        }
    }

    public static void getAllPaths(Node[][] matrix) {
        System.out.println("\n===== getAllPaths inductive =========");

        for(int i = 1 ; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length ; j++) {
                getPathOfNode(matrix,i,j);
            }
        }
    }

    public static void printPaths(Node node,int i, int j) {
        HashSet<Vector<Node>> set = node.myShortestPath;
        System.out.println("Node: ("+i+","+j+") {");
        int counter = 1;
        for(Vector<Node> vec : set) {
            System.out.print(counter+"): " +vec);
            System.out.println();
            counter++;
        }
        System.out.println("}");
    }

    public static boolean isOnPath(Node[][] matrix, int i_source,int j_source, int i_dest, int j_dest) {

        getPathOfNode(matrix,i_source,j_source);
        Node source = matrix[i_source][j_source];
        Node destination = matrix[i_dest][j_dest];

        HashSet<Vector<Node>> paths = source.myShortestPath;

        for(Vector<Node> path : paths) {
                if(path.contains(destination))
                    return true;
        }
        return false;
    }

    public static int shortestPathBetween(Node[][] matrix, int i1, int j1, int i2, int j2) {
        if(i1 < i2 && j1 < j2) {

            matrix[i1][j1].entry = 0;
            for(int i = i1+1 ; i <= i2; i++) { // O(N)
                matrix[i][j1].entry = matrix[i-1][j1].entry + matrix[i-1][j1].goDown;
            }
            for(int i = j1+1 ; i <= j2; i++) { // O(M)
                matrix[i1][i].entry = matrix[i1][i-1].entry + matrix[i1][i-1].goRight;
            }

            for(int i = i1 +1 ; i <= i2; i++) {
                for(int j = j1+1; j <= j2; j++) {
                    int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
                    int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;
                    matrix[i][j].entry = Math.min(fromAbove,fromLeft);
                }
            }
            return matrix[i2][j2].entry;
        }
        return -1;
    }

}
