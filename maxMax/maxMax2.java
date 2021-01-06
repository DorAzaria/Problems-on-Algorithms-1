package maxMax;
import java.util.Arrays;

public class maxMax2 {

    /**
     * Not so different from the first solution...
     * Comparisons : 2n - 3
     * @param arr a numeric array.
     * @return the two maximum numbers in the array.
     */
    public static int[] maxMax(int[] arr) {
        int max1 = arr[0];
        int max2 = arr[1];

        if(max2 > max1) { // 1 comparison
            max1 = arr[1];
            max2 = arr[0];
        }

        for(int i = 2; i < arr.length; i++) {

            if(max1 < arr[i]) {
                max2 = max1;
                max1 = arr[i];
            }
            else if(max2 < arr[i]) {
                    max2 = arr[i];
            }

        } // end for

        return new int[] { max1, max2 };
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
