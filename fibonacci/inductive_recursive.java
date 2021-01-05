package fibonacci;

public class inductive_recursive {

    public static int fiboRecursive(int n) {
        if( n == 0 || n == 1) {
            return n;
        }
        return fiboRecursive(n-1) + fiboRecursive(n-2); // O(2^N)
    }

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
    }
}
