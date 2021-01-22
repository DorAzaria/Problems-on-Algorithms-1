package LIS_LongestIncreasingSubsequence;

import java.util.Arrays;
import java.util.Vector;

public class BruteForceSearch {

    public static Vector<int[]> getSubsets(int[] arr) {
        Vector<int[]> subsets = new Vector<>();
        int size = (int)Math.pow(2,arr.length) - 1;

        for(int decimal = 0; decimal < size; decimal++) {

            int binary = decimal;
            int i = 0;
            Vector<Integer> vec_set = new Vector<>();
            while(binary > 0) {
                if(binary % 2 == 1) {
                    vec_set.add(arr[i]);
                }
                binary /= 2;
                i++;
            }
            int[] arr_set = new int[vec_set.size()];
            for(int s = 0 ; s < vec_set.size(); s++) {
                arr_set[s] = vec_set.get(s);
            }
            subsets.add(arr_set);
        }

        return subsets;
    }

    public static int[] bruteForce(int[] arr) {

        Vector<int[]> subsets = getSubsets(arr);
        int[] solution = new int[0];
        int max = 0;

        for(int i = 0 ; i < subsets.size(); i++) {
            int[] subset = subsets.get(i);
            boolean isIncreasing = true;
            for(int j = 1 ; j < subset.length; j++) {
                if(subset[j-1] > subset[j]) {
                    isIncreasing = false;
                    break;
                }
            }
            if(isIncreasing && subset.length > max) {
                solution = subset;
                max = solution.length;
            }
        }

        return solution;
    }


    public static void main(String[] args) {
        int[] arr = {1, 100, 101, 2, 3, 4, 5, 6, 7};
        System.out.println(Arrays.toString(bruteForce(arr)));
        //prints [1, 2, 3, 4, 5, 6, 7]
    }

}
