package LIS_LongestIncreasingSubsequence;

import java.util.Arrays;

public class DynamicInductive {

    public static int binarySearch(int[][] matrix, int left, int right, int value) {
        while(left <= right) {
            if(left == right) {
                return left;
            }
            int middle = (right+left)/2;
            if(value == matrix[middle][middle]) {
                return middle;
            }
            if(value < matrix[middle][middle]) {
                right = middle;
            }
            else {
                left = middle+1;
            }
        }
        return -1;
    }

    public static int[] dynamic(int[] arr) {
        int[][] matrix = new int[arr.length][arr.length];
        int length = 1;
        matrix[0][0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            int index;
            if(arr[i] > matrix[length-1][length-1]) {
                index = length;
            }
            else if(arr[i] < matrix[0][0]) {
                index = 0;
            } else {
                index = binarySearch(matrix,0,length,arr[i]);
            }
            matrix[index][index] = arr[i];

            if(index == length){
                length++;
            }

            for(int j = 0 ; j < index; j++) {
                matrix[index][j] = matrix[index-1][j];
            }// end j for

        }// end i for

        int[] solution = new int[length];
        for(int i = 0; i < length; i++) {
            solution[i] = matrix[length-1][i];
        }

        return solution;
    }
    public static void main(String[] args) {
        int[] arr = {5,9,4,20,6,3};
        System.out.println(Arrays.toString(dynamic(arr)));
    }
}
