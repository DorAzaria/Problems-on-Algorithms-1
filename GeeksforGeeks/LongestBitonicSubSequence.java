package GeeksforGeeks;

public class LongestBitonicSubSequence {

    /// tt

    /**
     * Longest Bitonic SubSequence
     * Complexity: O(n*log n)
     */
    public static int LBSLen(int[] arr) {
        int n = arr.length;
        int[] arr_lds = new int[n];
        for (int i = 0; i < n; i++) {
            arr_lds[i]= arr[n-i-1];
        }
        int[] lisArr = new int[n];
        lisArr[0] = arr[0];
        int[] ldsArr = new int[n];
        ldsArr[0] = arr_lds[0];
        int[] upLen = new int[n+1];
        int[] downLen = new int[n+1];
        int len = 1;
        upLen[1] = 1;
        downLen[n-1] = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(lisArr,len,arr[i]);
            lisArr[index] = arr[i];
            if(index == len) len++;
            upLen[i+1] = len;
        }
        len = 1;
        for (int i = 1; i < n; i++) {
            int index = binarySearchBetween(ldsArr,len,arr_lds[i]);
            ldsArr[index] = arr_lds[i];
            if(index == len) len++;
            downLen[n-i-1] = len;
        }
        //System.out.println(Arrays.toString(upLen));
        //System.out.println(Arrays.toString(downLen));
        int max = upLen[1] + downLen[0] - 1;
        for (int i = 1; i < n; i++) {
            int lbs = upLen[i+1] + downLen[i] -1;
            if(lbs > max) {
                max = lbs;
            }
        }
        return max;
    }

    private static int binarySearchBetween(int[] arr, int end, int v) {
        if(v > arr[end-1]) return end;
        if(v < arr[0]) return 0;
        int high = end, low = 0;
        while(low <= high) {
            if(low == high)return low;
            int mid = (low + high)/2;
            if(arr[mid] == v) return mid;
            if(arr[mid] > v) high = mid;
            else low = mid+1;
        }
        return -1;
    }
}
