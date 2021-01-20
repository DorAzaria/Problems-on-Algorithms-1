package PlaneProblem;
import java.util.HashSet;
import java.util.Vector;

public class pathsRecursion {

    public static void getCornerPath(Node[][] matrix) {
        int i = matrix.length-1, j = matrix[0].length-1;
        System.out.println("\n===== getCornerPath ("+i+","+j+") recursive =========");
        getPath(matrix, matrix[i][j],new Vector<>(),i,j);
        printPaths(matrix[i][j],i,j);
    }

    public static void getPathOfNode(Node[][] matrix, int i, int j) {
        System.out.println("\n===== getPathOfNode ("+i+","+j+") recursive =========");
        if(i < matrix.length && j < matrix[0].length) {
            getPath(matrix, matrix[i][j],new Vector<>(),i,j);
            printPaths(matrix[i][j],i,j);
        }
    }

    public static void getPath(Node[][] matrix, Node source,Vector<Node> path, int i, int j) {
        path.add(matrix[i][j]);
        if(i == 0 && j == 0) {
            source.myShortestPath.add(path);
        } else if(i == 0) {
            getPath(matrix,source,path,i,j-1);
        } else if(j == 0) {
            getPath(matrix,source,path,i-1,j);
        } else {
            int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
            int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;

            if(fromAbove > fromLeft) {
                getPath(matrix,source,path,i,j-1);
            } else if(fromAbove < fromLeft) {
                getPath(matrix,source,path,i-1,j);
            } else {
                Vector<Node> pathLeft = new Vector<>(path);
                getPath(matrix,source,pathLeft,i,j-1);

                Vector<Node> pathAbove = new Vector<>(path);
                getPath(matrix,source,pathAbove,i-1,j);
            }
        }
    }

    public static void getAllPaths(Node[][] matrix) {
        System.out.println("\n===== getAllPaths recursive =========");
        allPathsRec(matrix,1,1);
    }

    public static void allPathsRec(Node[][] matrix, int i, int j) {
        if(i == matrix.length) {
            return;
        }
        if(j == matrix[0].length) {
            allPathsRec(matrix,i+1,1);
        } else {
            getPath(matrix,matrix[i][j],new Vector<>(),i,j);
            printPaths(matrix[i][j],i,j);
            allPathsRec(matrix,i,j+1);
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

}
