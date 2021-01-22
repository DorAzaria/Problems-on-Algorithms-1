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

        int[][] lrs = new int[str.length()+1][str.length()+1];
        int max = 0;
        for(int i = 1 ; i < lrs.length; i++) {
             for(int j = 1; j < lrs.length ; j++) {
                 if(i != j) {
                     if (str.charAt(i-1) == str.charAt(j-1)) {
                         lrs[i][j] = lrs[j][i] + 1;

                         if(lrs[i][j] == lrs[i][j-1] ) {
                             lrs[i][j]++;
                         }
                     }
                     else {
                         lrs[i][j] = 1;
                     }

                     if(max < lrs[i][j]) {
                         max = lrs[i][j];
                     }
                 } else {
                     lrs[i][j] = 1;
                 }
                 System.out.print(lrs[i][j] + " ");
             }
            System.out.println();
        }

        return makeString(lrs,str,max);
    }

    public static String makeString(int[][] LRS, String str, int max) {
        String ans = "";
        for(int i = 0; i < LRS.length; i++) {
            boolean isDuplicated = false;
            for(int j = 0 ; j < LRS.length; j++) {
                if(LRS[i][j] == max) {
                    isDuplicated = true;
                    break;
                }
            }
            if(isDuplicated) {
                ans += str.charAt(i-1);
            }
        }

        return ans;
    }
    public static void main(String[] args) {
        String str = "AAABBBEEE";
        System.out.println(LRS(str));
    }
}
