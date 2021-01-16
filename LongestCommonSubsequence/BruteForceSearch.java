package LongestCommonSubsequence;

public class BruteForceSearch {

    public static void plusOne(int[] binary) {
        int size = binary.length - 1;
        while(size >= 0 && binary[size] == 1) {
            binary[size--] = 0;
        }
        if(size >= 0)
            binary[size] = 1;
    }

    public static String[] subsets(String str) {
        int array_size = ((int) (Math.pow(2, str.length())))-1;
        String[] subsets = new String[array_size];
        int[] binary = new int[str.length()];

        for(int i = 0; i < subsets.length; i++) {
            plusOne(binary);
            String subset="";

            for (int j = 0; j < binary.length; j++) {
                if(binary[j] == 1)
                    subset+=str.charAt(j);
            }
            subsets[i] = subset;
        }
        return subsets;
    }

    public static String bruteForce(String X, String Y) {
        String shortest = X, longest= Y, ans = "";
        if(X.length() > Y.length()){
            shortest = Y;
            longest= X;
        }
        String[] shortestSet = subsets(shortest);
        String[] longestSet = subsets(longest);

        for(int i = 0; i < shortestSet.length; i++) {
            for(int j = 0; j < longestSet.length; j++) {

                if(shortestSet[i].equals(longestSet[j])) {
                    if(shortestSet[i].length() > ans.length())
                        ans = shortestSet[i];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String X = "abcbdab", Y = "bdcaba";
        System.out.println(bruteForce(X,Y));
    }
}
