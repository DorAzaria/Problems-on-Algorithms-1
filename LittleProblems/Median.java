package LittleProblems;

import java.util.Arrays;

public class Median {

    public static int optimal(int[] arr) {
        int max = arr[0];

        for(int i = 1; i < arr.length-1 && i < 64 -1; i+=2) {

            if(arr[i] > arr[i+1] && max < arr[i]) {
                max = arr[i];
            }
            else if(max < arr[i+1]) {
                max = arr[i+1];
            }
        }

        return max;
    }

    public static int naive(int[] arr) {
        Arrays.sort(arr); // O(n*log n)
        return arr[arr.length-1]; // O(1)
    }
    public static void main(String[] args) {
        int[] odd = {77,3,23,8,12,6,1};
        int[] even = {77,3,23,12,6,1};
        System.out.println("naive even: " + naive(even));
        System.out.println("naive odd: " + naive(odd));
        System.out.println("optimal even: "+optimal(even));
        System.out.println("optimal odd: "+optimal(odd));
    }
}
