package LDS_LongestDecreasingSubsequence;

import java.util.Arrays;
import java.util.Vector;

public class BruteForceSearch {

    public static Vector<int[]> subsets(int[] arr) {
        Vector<int[]> subsets = new Vector<>();
        int length = (int)Math.pow(2,arr.length)-1;

        for(int decimal = 0; decimal < length; decimal++) {

            int binary = decimal;
            int i = 0;
            Vector<Integer> subset = new Vector<>();
            while (binary != 0) {
                if(binary % 2 == 1) {
                    subset.add(arr[i]);
                }
                i++;
                binary /= 2;
            }

            int[] ss = new int[subset.size()];

            for(int j = 0 ; j < ss.length; j++) {
                ss[j] = subset.get(j);
            }
            subsets.add(ss);
        }
        return subsets;
    }

    public static int[] bruteForce(int[] arr) {

        Vector<int[]> vector = subsets(arr);
        int[] bestSubset = new int[0];
        for(int i = 0 ; i < vector.size(); i++) {
            boolean isDecreasing = true;
            int[] subset = vector.get(i);
            for(int j = 1; j < subset.length; j++) {
                if(subset[j-1] < subset[j]){
                    isDecreasing = false;
                }
            }
            if(isDecreasing && bestSubset.length < subset.length) {
                bestSubset = subset;
            }
        }

        return bestSubset;
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 101, 100, 1};
        System.out.println(Arrays.toString(bruteForce(arr)));
        // print [7, 6, 5, 4, 3, 2, 1]
    }
}
