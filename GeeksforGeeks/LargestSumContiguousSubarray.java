package GeeksforGeeks;

public class LargestSumContiguousSubarray {

    /*
    Write an efficient program to find the sum of contiguous subarray
    within a one-dimensional array of numbers which has the largest sum.
     */

    public static int contiguous(int[] arr) {

        int temp_max = Integer.MIN_VALUE;
        int max = 0;

        for (int i = 0; i < arr.length; i++) { // O(n)

            max = max + arr[i];

            if (max < 0)
                max = 0;

            if (temp_max < max)
                temp_max = max;
        }
        return temp_max;
    }

    public static void main(String[] args) {

        int[] arr = {-2,-3,4,-1,-2,1,5,-3};
        System.out.println(contiguous(arr));
    }
}
