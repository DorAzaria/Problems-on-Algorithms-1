package MinMax;

public class solution1 {


    public static int getMax(int[] arr) {
        int ans = arr[0];

        for(int i = 1 ; i < arr.length ; i++) {
            if(ans < arr[i])
                ans  = arr[i];
        }

        return ans;
    }

    public static int getMin(int[] arr) {
        int ans = arr[0];

        for(int i = 1 ; i < arr.length ; i++) {
            if( ans > arr[i])
                ans = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {84,31,3,1,567,4,2,93202,32,3};
        System.out.println(getMax(arr));
        System.out.println(getMin(arr));
        arr = new int[] {1,2,3,4,5,8,5,3,2,1,6,7,8};
        System.out.println(getMax(arr));
        System.out.println(getMin(arr));
        arr = new int[] {-1,1,-2,2,-10,10,-100,100,30,2};
        System.out.println(getMax(arr));
        System.out.println(getMin(arr));
    }
}
