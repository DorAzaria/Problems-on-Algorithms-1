package Fibonacci;

public class goldenRatio {

    static double PHI = (1 + Math.sqrt(5)) / 2;
    static int[] fib = { 0, 1, 1, 2, 3, 5 };

    /**
     * calculating fibonacci number with golden ratio
     * is valid only if n > 5
     * time : O(N)
     * Math.round example: if 3.49 then 3, 3.50 then 4.
     * @param n - the number of index in the fibonacci series
     * @return the value in index n
     */
    public static int goldenInduction(int n) {
        if(n <= 5) {
            return fib[n];
        }
        int ans = fib[5];
        for (int i = 5; i < n ; i++) {
            ans = (int) Math.round(ans * PHI);
        }

        return ans;
    }

    /**
     * calculating fibonacci number with golden ratio
     * is valid only if n > 5.
     * time : O(PHI^n) which is O(2^n)
     * @param n an index in the fibonacci series
     * @return the value in this index.
     */
    public static int goldenRecursive(int n) {
        if(n <= 5) {
            return fib[n];
        }
        if(n == 6)
            return (int) Math.round(5 * PHI);

        return (int) Math.round( goldenRecursive(n-1) * PHI);
    }
    
    /**
     * time : O(constant) = O(1)
     * @param n an index in the fibonacci series
     * @return the value in this index.
     */
    public static int binetFormula(int n) {
        return (int) ((Math.pow(PHI, n) - Math.pow(-PHI, -n))/Math.sqrt(5));
    }

    public static void main(String[] args) {
        System.out.println(goldenInduction(9));
        System.out.println(goldenRecursive(9));
        System.out.println(binetFormula(9));
    }
}
