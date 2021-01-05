package MinMax;

import java.util.Arrays;

public class solution4 {

    public static int[] finalSolution(int[] arr){
        int max = 0;
        int min = 0;

        if(arr[0] > arr[1]) { // 1 comparison
            max = arr[0];
            min = arr[1];
        } else {
            max = arr[1];
            min = arr[0];
        }

        // n-2 values, 2*jumps which is n-2/2, in each iteration we make 3 comparisons
        // in conclusion, n-2/2 + n-2/2 + n-2/2 = 3(n-2)/2
        for(int i = 2 ; i < arr.length - 1 ; i+=2) {

            if(arr[i] < arr[i+1]) { // 3 comparisons

                if(min > arr[i]) {
                    min = arr[i];
                }
                if(arr[i+1] > max){
                    max = arr[i+1];
                }

            } else { // 3 comparisons
                // if arr[i] >= arr[i+1]
                if(min > arr[i+1]) {
                    min = arr[i+1];
                }
                if(max < arr[i]) {
                    max = arr[i];
                }

            }

        }

        if(arr.length % 2 != 0) { // 2 comparisons
            if(arr[arr.length-1] > max) {
                max = arr[arr.length-1];
            }
            else if(arr[arr.length-1] < min) {
                min = arr[arr.length-1];
            }
        }
        // in conclusion 1 + 3n/2 + 2 = 3n/2 + 4 = O(3n/2)
        return new int[] { max, min};
    }

    public static void main(String[] args) {
        int[] arr = {84,31,3,1,567,4,2,93202,32,3};
        System.out.println(Arrays.toString(finalSolution(arr)));
        arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
        System.out.println(Arrays.toString(finalSolution(arr)));
        arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
        System.out.println(Arrays.toString(finalSolution(arr)));
    }
}
