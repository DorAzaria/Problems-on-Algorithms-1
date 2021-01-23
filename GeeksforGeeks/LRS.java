package GeeksforGeeks;

import java.util.Arrays;

public class LRS {

    /*
    Longest Repeated Subsequence
    Given a string, print the longest repeating subsequence
    such that the two subsequence don’t have same string character at same position,
    i.e., any i’th character in the two subsequences shouldn’t have the same index in the original string.
     */

    public static String LRS(String str) {

        int[][] LRS = new int[str.length()+1][str.length()+1];

        for(int i = 1 ; i < LRS.length; i++) {
            for(int j = 1; j < LRS.length; j++) {

                if(i != j && str.charAt(i-1) == str.charAt(j-1)) {
                    LRS[i][j] = LRS[i-1][j-1] + 1;
                } else {
                    LRS[i][j] = Math.max(LRS[i-1][j], LRS[i][j-1]);
                }
                System.out.print(LRS[i][j] + " ");
            }
            System.out.println();
        }

        return getString(LRS,str);
    }

    public static String getString(int[][] LRS, String str) {
        String ans = "";
        int i = LRS.length-1, j = LRS.length-1;

        while(i > 0 && j > 0) {

            if(LRS[i][j] == LRS[i-1][j-1] + 1) {
                ans = str.charAt(i-1) + ans;
                i--;
                j--;
            }
            else if(LRS[i][j] == LRS[i-1][j]) {
                i--;
            } else {
                j--;
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str = "AABEBCDD";
        System.out.println(LRS(str));
    }
}
