package GeeksforGeeks;

import java.util.Arrays;
import java.util.Vector;

public class KnapsackProblem {

    /**
     * Given weights and values of n items,
     * put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
     * In other words, given two integer arrays val[0..n-1] and wt[0..n-1]
     * which represent values and weights associated with n items respectively.
     * Also given an integer W which represents knapsack capacity,
     * find out the maximum value subset of val[] such that sum of the weights of this subset
     * is smaller than or equal to W. You cannot break an item,
     * either pick the complete item or don’t pick it (0-1 property).
     */

    public static Vector<int[]> subsets(int[] values) {

        int length = (int) Math.pow(2,values.length);
        Vector<int[]> subsets = new Vector<>();

        for(int decimal = 0 ; decimal < length ; decimal++) {

            Vector<Integer> subset = new Vector<>();
            int binary = decimal;
            int i = 0;

            while (binary != 0) {
                if(binary % 2 == 1) {
                    subset.add(values[i]);
                }
                binary/=2;
                i++;
            }

            int[] ss = new int[subset.size()];
            for(int j =0 ; j < ss.length; j++) {
                ss[j] = subset.get(j);
            }
            subsets.add(ss);
        }

        return subsets;
    }

    public static int BruteForce(int W, int[] weight, int[] values) {

        Vector<int[]> subsets = subsets(values);
        int[] optimal = new int[0];
        int max_value = 0;
        for(int i = 0; i < subsets.size() ; i++) {

            int[] subset = subsets.get(i);
            int sum_subset = 0;
            int sum_weight = 0;

            for(int j = 0; j < subset.length; j++) {
                    sum_subset += subset[j];

                for(int k = 0 ; k < values.length ; k++) {
                    if(values[k] == subset[j]) {
                        sum_weight += weight[k];
                    }
                }
            }

            if(sum_weight <= W && sum_subset >= max_value) {
                max_value = sum_subset;
                optimal = subset;
            }
        }

        System.out.println(Arrays.toString(optimal));
        return max_value;
    }

    public static void main(String[] args) {
        int W = 50;
        int[] weight = {10, 20, 30};
        int[] values = {60,100,120};
        System.out.println(BruteForce(W,weight,values));
    }
}
