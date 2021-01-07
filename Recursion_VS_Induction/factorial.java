package Recursion_VS_Induction;

public class factorial {

    //O(2N)
    public static int factorialRecursive(int n) {
        if( n == 0 )
            return 1; 

        return n * factorialRecursive(n-1);
    }

    //O(N)
    public static int factorialInductive(int n) {

        int ans = 1;
        for(int i = 1 ; i <= n ; i++) {
            ans *= i;
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(factorialRecursive(5));
        System.out.println(factorialInductive(5));
    }
}
