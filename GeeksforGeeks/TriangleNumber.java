package GeeksforGeeks;

import java.util.Arrays;

public class TriangleNumber {

    // inductive
    public static int triangle(int n) {
        int ans = 0;
        int[] triangle_number = new int[n];
        for(int k = 1; k <= n ; k++) {
            ans += k;
            triangle_number[k-1] = ans;
        }
        System.out.println(Arrays.toString(triangle_number));
        return ans;
    }

    // recursive
    public static int triangleRec(int n) {
        if(n == 1) {
            return 1;
        }
        return triangleRec(n-1) + n;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(triangle(n));
        System.out.println(triangleRec(n));
    }
}
