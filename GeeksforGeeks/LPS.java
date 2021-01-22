package GeeksforGeeks;

public class LPS {

    /**
     * Given a sequence, find the length of the longest palindromic subsequence in it.
     * if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is
     * the longest palindromic subsequence in it. “BBBBB” and “BBCBB” are also palindromic subsequences
     * of the given sequence, but not the longest ones.
     *
     * Let X[0..n-1] be the input sequence of length n and L(0, n-1) be the length of the longest
     * palindromic subsequence of X[0..n-1].
     * If last and first characters of X are same, then L(0, n-1) = L(1, n-2) + 2.
     * Else L(0, n-1) = MAX (L(1, n-1), L(0, n-2)).
     */

    public static int rec(String str, int left, int right) {
        if(left >= str.length() || right < 0) {
            return 0;
        }
        if(str.charAt(left) == str.charAt(right)) {
            return rec(str,left+1,right-1) + 1;
        } else {
            int from_left = rec(str,left+1,right);
            int from_right = rec(str,left,right-1);
            return Math.max(from_left,from_right);
        }
    }

    public static int dynamic(String str) {

        int[][] matrix = new int[str.length()][str.length()];

        for(int i = 0 ; i < matrix.length; i++) {
            matrix[i][i] = 1;
        }

        for(int sub_str_len = 2; sub_str_len <= matrix.length; sub_str_len++) {
            for(int i = 0; i < matrix.length - sub_str_len + 1 ; i++) {
                int j = sub_str_len + i - 1;

                if(str.charAt(i) == str.charAt(j)) {
//                    System.out.println(str.charAt(i) + "= [" + i + " , "+ j+"]");
                    matrix[i][j] = matrix[i+1][j-1] + 2;
                } else {
                    int fromLeft = matrix[i][j-1];
                    int fromDown = matrix[i+1][j];
                    matrix[i][j] = Math.max(fromDown,fromLeft);
                }
            }
        }

//        print(matrix);
        return matrix[0][str.length()-1];
    }

    public static void print(int[][] matrix) {

        for(int i = 0 ; i < matrix.length ; i ++) {
            for(int j = 0 ; j < matrix.length ; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static String strRec(String str, int left, int right) {
        if(left >= str.length() || right < 0) {
            return "";
        } else {
            if(str.charAt(left) == str.charAt(right)) {
                return strRec(str,left+1,right-1) + str.charAt(left);
            } else {
                String from_left = strRec(str,left+1,right);
                String from_right = strRec(str,left,right-1);
                if(from_left.length() > from_right.length()) {
                    return from_left;
                } else {
                    return from_right;
                }
            }
        }
    }
    public static void main(String[] args) {
        String str = "GEEKSFORGEEKS";
        System.out.println(rec(str,0,str.length()-1)); // 5
        System.out.println(dynamic(str));
        System.out.println(strRec(str,0,str.length()-1));
    }
}
