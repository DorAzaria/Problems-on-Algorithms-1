package MinMax;

import java.util.Arrays;

public class solution3 {

    public static int[] improvedMinMax(int[] arr) {
        int max = 0;
        int min = 0;

        if(arr[0] > arr[1]) {
            max = arr[0];
            min = arr[1];
        } else{
            max = arr[1];
            min = arr[0];
        }

        for( int i = 2 ; i < arr.length ; i++ ) {
            if(max < arr[i]) {
                max = arr[i];
            }
            if(min > arr[i]){
                min = arr[i];
            }
        }

        return new int[] {max, min};
    }

    public static void main(String[] args) {
        int[] arr = {84,31,3,1,567,4,2,93202,32,3};
        System.out.println(Arrays.toString(improvedMinMax(arr)));
        arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
        System.out.println(Arrays.toString(improvedMinMax(arr)));
        arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
        System.out.println(Arrays.toString(improvedMinMax(arr)));

    }
}
