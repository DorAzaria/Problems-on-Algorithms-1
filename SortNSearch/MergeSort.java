package SortNSearch;

import java.util.Arrays;

public class MergeSort {

    private static void mergeSort(int[] arr) {
        mergeSort(arr,0,arr.length-1);
    }

    private static void mergeSort(int[] arr, int left, int right) {
        if(left < right) {
            int middle = (left+right)/2;

            mergeSort(arr,left,middle); // left
            mergeSort(arr,middle+1,right); // right
            Merge(arr,left,middle,right);
        }
    }

    private static void Merge(int[] arr, int left, int middle, int right) {

        int[] temp = new int[right - left + 1];

        int i = left; // left half
        int j = middle + 1; // right half
        int k = 0; // The Running Pointer

        while( i <= middle && j <= right) {

            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while(i <= middle)
            temp[k++] = arr[i++];

        while(j <= right)
            temp[k++] = arr[j++];


        for(i = left, k = 0 ; k < temp.length && i <= right; k++, i++)
            arr[i] = temp[k];
    }

    public static void main(String[] args) {
        int[] arr = {48,3,7,9,43,1,2,4,6,8};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
