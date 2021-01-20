package LIS_LongestIncreasingSubsequence;

import java.util.Arrays;

public class DynamicRecursive {

    public static int[] dynamic(int[] arr) {
        int[][] matrix = new int[arr.length][arr.length];
        matrix[0][0] = arr[0];

        int length = recursive(matrix,arr,1,1);

        int[] solution = new int[length];
        fillSolution(matrix,solution,0);

        return solution;
    }

    public static int recursive(int[][] matrix, int[] arr, int length, int i) {
        if(i == arr.length){
            return length;
        }
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
        newRow(matrix,index,0);

        if(index == length) {
            return recursive(matrix,arr,length+1,i+1);
        } else {
            return recursive(matrix,arr,length,i+1);
        }
    }

    public static int binarySearch(int[][] matrix, int left, int right, int value) {
        if(left > right) {
            return -1;
        }
        if(left == right){
            return left;
        }
        int middle = (right+left)/2;
        if(value < matrix[middle][middle]) {
            return binarySearch(matrix,left,middle,value);
        }
        else if(value > matrix[middle][middle]){
            return binarySearch(matrix,middle+1,right,value);
        }
        else { // value == matrix[middle][middle]
            return middle;
        }
    }

    public static void newRow(int[][] matrix, int index, int i) {
        if(i == index) {
            return;
        }
        matrix[index][i] = matrix[index-1][i];
        newRow(matrix,index,i+1);
    }

    public static void fillSolution(int[][] matrix, int[] solution, int i) {
        if(i == solution.length) {
            return;
        }
        solution[i] = matrix[solution.length-1][i];
        fillSolution(matrix,solution,i+1);
    }

    public static void main(String[] args) {
        int[] arr = {5,9,4,20,6,3};
        System.out.println(Arrays.toString(dynamic(arr)));
        // prints [5, 9, 20]
    }
}
