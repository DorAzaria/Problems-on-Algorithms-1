package GeeksforGeeks;

public class LCS_Triple {

    public static String LCS(String X, String Y, String Z) {

        int[][][] LCS = new int[X.length()+1][Y.length()+1][Z.length()+1];

        for(int i = 1; i < X.length()+1; i++) {
            for(int j = 1 ; j < Y.length()+1; j++) {
                for(int k = 1; k < Z.length()+1; k++) {

                    if(X.charAt(i-1) == Y.charAt(j-1) && X.charAt(i-1) == Z.charAt(k-1)) {
                     LCS[i][j][k] = LCS[i-1][j-1][k-1] + 1;
                    } else {
                        LCS[i][j][k] = max(LCS[i-1][j][k],LCS[i][j-1][k],LCS[i][j][k-1]);
                    }
                }
            }
        }

        String ans = "";
        int i = X.length(), j = Y.length(), k = Z.length();

        while (i > 0 && j > 0 && k > 0) {

            if(LCS[i][j][k] == LCS[i-1][j-1][k-1] + 1) {
                ans = X.charAt(i-1) + ans;
                i--;
                j--;
                k--;
            }
            else if(LCS[i][j][k] == LCS[i-1][j][k] ) {
                i--;
            }
            else if(LCS[i][j][k] == LCS[i][j-1][k]) {
                j--;
            }
            else {
                k--;
            }
        }
        return ans;
    }

    public static int max(int x, int y, int z) {
        int max = x;
        if(max < y) {
            max = y;
        }
        if(max < z) {
            max = z;
        }
        return max;
    }

    public static void main(String[] args) {
        String X = "sunday";
        String Y = "monday";
        String Z = "may";
        System.out.println(LCS(X,Y,Z));
    }
}