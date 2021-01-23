package GeeksforGeeks;

public class LongestPalindromicSubString {
    /**
     * Longest Palindromic SubString
     * Complexity: O(n^2)
     */
    public static int lpsLen(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        return LCS(s,reverse);
    }

    private static int LCS(String X, String Y) {
        int n = X.length()+1;
        int m = Y.length()+1;
        int[][] mat = new int[n][m];
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if(X.charAt(i-1) == Y.charAt(j-1)) {
                    mat[i][j] = mat[i-1][j-1] + 1;
                }
                else {
                    mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                }
            }
        }
        return mat[n-1][m-1];
    }

    public static void main(String[] args) {
        /// tt
        System.out.println(lpsLen("wasitacaroracatisaw"));
        System.out.println(lpsLen("alfalfa"));
        System.out.println(lpsLen("aubcxctybza"));
    }
}
