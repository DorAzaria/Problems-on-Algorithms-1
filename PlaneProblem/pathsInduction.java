package PlaneProblem;

public class pathsInduction {

    public static String getCornerPath(Node[][] matrix) {
        return getPath(matrix,matrix.length-1,matrix[0].length-1);
    }

    public static String getPath(Node[][] matrix, int i, int j) {

        String direction = "("+i+","+(j)+")-> ";
        String ans = direction;

        while(i >= 1 && j >= 1) {
            int fromAbove = matrix[i-1][j].entry + matrix[i-1][j].goDown;
            int fromLeft = matrix[i][j-1].entry + matrix[i][j-1].goRight;
            if(fromAbove > fromLeft) {
                direction = "("+i+","+(j-1)+")-> ";
                ans = direction + ans;
                j--;
            } else {
                direction = "("+(i-1)+","+(j)+")-> ";
                ans = direction + ans;
                i--;
            }
        }
        direction = "(0,0)-> ";
        ans = direction + ans;

        return ans;
    }

    public static void getAllPaths(Node[][] matrix) {
        System.out.println("\n===== ALL PATHS ====");
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1 ; j < matrix[0].length; j++) {
                matrix[i][j].myShortestPath = getPath(matrix,i,j);
                System.out.println("Path of ("+i+","+j+") is [ "+ matrix[i][j].myShortestPath +" ]");
            }
        }
    }
}
