package LCS_LongestCommonSubsequence;

public class BetterBruteForceSearch {

    public static String[] subset(String str) {
        String[] subsets = new String[(int)Math.pow(2,str.length()) - 1];

        for(int decimal = 0 ; decimal < subsets.length; decimal++) {
            String subset = "";
            int binary  = decimal, i = 0;
            while(binary  != 0 ) { // to binary
                if(binary  % 2 == 1) {
                    subset += str.charAt(i);
                }
                binary  /= 2;
                i++;
            }
            subsets[decimal] = subset;
        }

        return subsets;
    }


    public static String bruteForce(String X, String Y) {
        String ans = "", shortest = X, longest = Y;
        if(X.length() > Y.length()) {
            shortest = Y;
            longest = X;
        }

        String[] shortestSubset = subset(shortest);
        String[] longestSubset = subset(longest);

        for(int i = 0 ; i < shortestSubset.length ; i++) {
            for(int j = 0; j < longestSubset.length; j++) {

                if(shortestSubset[i].equals(longestSubset[j])) {
                    if(shortestSubset[i].length() > ans.length()) {
                        ans = shortestSubset[i];
                    }
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String X = "abcbdab", Y = "bdcaba";
        System.out.println(bruteForce(X,Y)); // bcba
    }
}
