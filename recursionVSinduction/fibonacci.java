package recursionVSinduction;

public class fibonacci {

    public static int fiboRecursive(int n) {
        if( n == 0 || n == 1) {
            return n;
        }
        return fiboRecursive(n-1) + fiboRecursive(n-2); // O(2^N)
    }

    public static int fiboInductive(int n) {
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;

        for(int i = 2 ; i <= n ; i++)
            arr[i] = arr[i-1] + arr[i-2];

        return arr[n];
    }

    public static void main(String[] args) {
        System.out.println(fiboRecursive(9));
        System.out.println(fiboInductive(9));
    }
}
