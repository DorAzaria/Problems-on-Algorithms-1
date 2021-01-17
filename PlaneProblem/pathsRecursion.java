package PlaneProblem;

import java.util.Vector;

public class pathsRecursion {

    public static String getCornerPath(Node[][] matrix) {
        return getOnePath(matrix,matrix.length-1,matrix[0].length-1);
    }

    public static String getOnePath(Node[][] matrix, int i, int j) {
        String direction = "("+i+","+j+")-> ";
        return getOnePathRec(matrix,i,j) + direction;
    }

    private static String getOnePathRec(Node[][] matrix, int i, int j) {
        if(i == 0 || j == 0) {
            return "(0,0)-> ";
        }
        int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
        int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;

        if(fromAbove > fromLeft) {
            String direction = "("+i+","+(j-1)+")-> ";
            return getOnePathRec(matrix,i,j-1) + direction;
        }

        String direction = "("+(i-1)+","+j+")-> ";
        return getOnePathRec(matrix,i-1,j) + direction;
    }

    public static void getAllPaths(Node[][] matrix) {
        System.out.println("\n===== ALL PATHS ====");
        getAllRec(matrix,1,1);
    }

    private static void getAllRec(Node[][] matrix, int i, int j) {
        if(i == matrix.length)
            return;
        if(j == matrix[0].length) {
            getAllRec(matrix,i+1,1);
        }else {
            Vector<String> paths = new Vector<>();
            getPaths(matrix,i,j,"("+i+","+j+")",paths);
            String ans = "";
            for(String str : paths) {
                ans = ans + "\n" +  str;
            }
            matrix[i][j].myShortestPath = ans;
            System.out.println("Path of ("+i+","+j+") is [ "+ matrix[i][j].myShortestPath +"\n]");
            getAllRec(matrix,i,j+1);
        }
    }

    private static void getPaths(Node[][] matrix, int i, int j, String ans, Vector<String> paths) {
        if(i == 0 || j == 0) {
            ans = "(0,0)-> " + ans;
            paths.add(ans);
            return;
        }
        int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
        int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;
        String directionLeft = "("+i+","+(j-1)+")-> ";
        String directionAbove = "(" + (i - 1) + "," + j + ")-> ";
        if(fromAbove > fromLeft) {
            getPaths(matrix,i,j-1, directionLeft + ans, paths);
        } else if(fromAbove < fromLeft) {
            getPaths(matrix, i - 1, j, directionAbove + ans, paths);
        } else {
            getPaths(matrix,i,j-1, directionLeft + ans, paths);
            getPaths(matrix, i - 1, j, directionAbove + ans, paths);
        }
    }

}
