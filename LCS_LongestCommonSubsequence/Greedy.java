package LCS_LongestCommonSubsequence;

public class Greedy {

    public static String greedy(String X, String Y) {
        String ans = "";
        int i = 0, j = 0;

        while( i < X.length() && j < Y.length()) {
            if(X.charAt(i) == Y.charAt(j)) {
                ans += X.charAt(i++);
            }
            j++;
        }
        return ans;
    }
    public static void main(String[] args) {
        String X = "ababcb";
        String Y = "cbab";
        System.out.println(greedy(X,Y));
    }
}
