package LongestDecreasingSubsequence;

import java.util.Arrays;

public class lengthLDS {


    public static int binarySearch(int[] sequence, int left, int right, int value) {

        while(right - left > 1) { // while we can compare min two values

            int middle = (right+left)/2;

            if(value >= sequence[middle]) {
                right = middle;
            }
            else if(value < sequence[middle]) {
                left = middle;
            }
        }
        return right;
    }

    public static int length(int[] arr) {
        int[] sequence = new int[arr.length];
        sequence[0] = arr[0];

        int length = 0;
        for(int i = 1 ; i < sequence.length; i++) {

            if(arr[i] > sequence[0]) {
                sequence[0] = arr[i];
            }
            else if(arr[i] < sequence[length]) {
                length++;
                sequence[length] = arr[i];
            } else {
                int index = binarySearch(sequence,0,length,arr[i]);
                sequence[index] = arr[i];
            }
        }

        System.out.println(Arrays.toString(sequence));
        return length+1;
    }

    public static void main(String[] args) {
        int[] arr = {11,8,7,3,6,20,4,9,5};
        System.out.println(length(arr)); // prints 5
    }
}
