package SortNSearch;

public class BinarySearch {

    public static int binarySearch(int arr[], int left, int right, int x) {

        if(right >= 1) {

            int middle = left + (right - left)/2;

            if(arr[middle] == x)
                return middle;

            if(arr[middle] > x)
                return binarySearch(arr, left, middle - 1 , x);

            else
                return binarySearch(arr, middle + 1 , right, x);
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {48,3,7,9,43,1,2,4,6,8};
        System.out.println(binarySearch(arr,0,arr.length-1,43)); // 4
    }
}
