package Fibonacci;

public class inductive_recursive {

    /**
     * 0, 1, 1, 2, 3, 5, 8, ...
     * Time : O(2^N)
     * @param n an index
     * @return the value at this index in fibonacci series
     */
    public static int fiboRecursive(int n) {
        if( n == 0 || n == 1) {
            return n;
        }
        return fiboRecursive(n-1) + fiboRecursive(n-2);
    }

    /**
     * ... −8, 5, −3, 2, −1, 1, 0
     * Time : O(2^N)
     * @param n a negative index
     * @return the value at this index in fibonacci series
     */
    public static int negativeFiboRecursive(int n) {
        if(n >= 0) { // if its not a negative index then use the positive method.
            return fiboRecursive(n);
        }
        return negativeFiboRecursive(n+2) - negativeFiboRecursive(n+1);
    }

    /**
     * 0, 1, 1, 2, 3, 5, 8, ...
     * Time : O(N)
     * @param n an index
     * @return the value at this index in fibonacci series
     */
    public static int fiboInductive(int n) {
        int prev1 = 1;
        int prev2 = 1;

        if (n == 1 || n == 2) {
            return 1;
        }

        for (int i = 1; i < n - 1; i++) {
            prev2 += prev1;
            prev1 = prev2 - prev1;
        }
        return prev2;
    }

    public static void main(String[] args) {
        System.out.println(fiboRecursive(9));
        System.out.println(fiboInductive(9));
        System.out.println(negativeFiboRecursive(-7));
    }
}
