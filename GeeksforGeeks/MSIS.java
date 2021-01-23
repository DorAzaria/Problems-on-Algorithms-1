package GeeksforGeeks;

import java.util.Arrays;
import java.util.Stack;
import java.util.Vector;

public class MSIS {

    /**
     * Maximum Sum Increasing Subsequence
     Given an array of n positive integers.
     Write a program to find the sum of maximum sum subsequence of the given array such
     that the integers in the subsequence are sorted in increasing order.
     For example, if input is {1, 101, 2, 3, 100, 4, 5}, then output should be 106 (1 + 2 + 3 + 100),
     if the input array is {3, 4, 5, 10}, then output should be 22 (3 + 4 + 5 + 10) and if the input
     array is {10, 5, 4, 3}, then output should be 10.
     */

    public static Vector<int[]> subsets(int[] arr) {
        int length = (int) Math.pow(2,arr.length);
        Vector<int[]> subsets = new Vector<>();

        for(int decimal = 1; decimal < length; decimal++) {

            Vector<Integer> subset = new Vector<>();
            int binary = decimal;
            int i = 0;

            while (binary!=0) {
                if(binary % 2 == 1){
                    subset.add(arr[i]);
                }
                binary/=2;
                i++;
            }
            int[] ss = new int[subset.size()];
            for(int s = 0; s < ss.length; s++) {
                ss[s] = subset.get(s);
            }

            subsets.add(ss);
        }
        return subsets;
    }

    public static int BruteForce(int[] arr) {

        Vector<int[]> subsets = subsets(arr);
        int max = 0;
        int[] solution = new int[0];

        for(int i = 0 ; i < subsets.size(); i++) {

            int[] subset = subsets.get(i);
            boolean isIncreasing = true;
            int temp_sum = subset[0];
            for(int j = 1 ; j < subset.length; j++) {

                if(subset[j-1] < subset[j]) {
                    temp_sum += subset[j];
                } else {
                    isIncreasing = false;
                    break;
                }
            }

            if(isIncreasing && temp_sum > max) {
                max = temp_sum;
                solution = subset;
            }

        }

        System.out.println(Arrays.toString(solution));
        return max;
    }

    public static int dynamic(int[] arr) {

        int[] sis = new int[arr.length];

        for(int i = 0 ; i < sis.length; i++) {
            sis[i] = arr[i];
        }

        int max = 0;

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0 ; j < i; j++) {
                if(arr[i] > arr[j]) {
                    if(sis[i] < arr[i] + sis[j]) {
                        sis[i] = arr[i] + sis[j];
                    }
                    if(sis[i] > max) {
                        max = sis[i];
                    }
                }
            }
        }

        System.out.println(Arrays.toString(sis));
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1, 101, 2, 3, 100};
        System.out.println(BruteForce(arr));

        System.out.println(dynamic(arr));
    }
}
