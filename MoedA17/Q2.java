package MoedA17;

public class Q2 {

    public static int longestSubseqWithDiffOne(int[] arr){

        int[] difference = new int[arr.length];

        for(int i = 0 ; i < arr.length ; i++) {
            difference[i] = 1;
        }

        for(int i = 1; i < arr.length;i++) { // O(n^2)
            for(int j = 0; j < i ; j++) {
                if (Math.abs(arr[i] - arr[j]) <= 1) {
                        difference[i] = difference[j] + 1;
                }
            }
        }

        int max = 0;
        for(int i = 0 ; i < difference.length; i++) {
            if(max < difference[i]) {
                max = difference[i];
            }
        }
        return max;
    }
}
