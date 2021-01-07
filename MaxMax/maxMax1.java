package MaxMax;

import java.util.Arrays;

public class maxMax1 {

    /**
     * Comparisons : 2n - 3
     * @param arr a numeric array.
     * @return the two maximum numbers in the array.
     */
    public static int[] maxMax(int[] arr){
        int maxIndex = maximum(arr); // n-1 comparisons
        int max1 = arr[maxIndex];
        arr[maxIndex] = Integer.MIN_VALUE;
        maxIndex = maximum(arr); // n-2 comparisons
        int max2 = arr[maxIndex];
        return new int[] {max1, max2};
    }

    /**
     * a simple method to return the maximum value of the given array.
     * @param arr a numeric array.
     * @return the maximum value in this array.
     */
    public static int maximum(int[] arr) {
        int max =  arr[0];
        int index = 0;
        for(int i = 1 ; i < arr.length ; i++) {
            if(max < arr[i]) {
                max = arr[i];
                index = i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = {84,31,3,1,567,4,2,93202,32,3};
        System.out.println(Arrays.toString(maxMax(arr)));
        arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
        System.out.println(Arrays.toString(maxMax(arr)));
        arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
        System.out.println(Arrays.toString(maxMax(arr)));
    }
}
