package GeeksforGeeks;

import java.util.Arrays;

public class ThreeCoinsProblem {
    /*
    Given 3 numbers i.e.{1, 3, 5}, we need to tell
    the total number of ways we can form a number 'N'
    using the sum of the given three numbers.
     */

    public static int calc(int[] memory, int[] c, int n) {
        if(n < 0) {
            return 0;
        }
        if(n == 1 || n == 0) {
            return 1;
        }
        memory[n] = calc(memory,c,n-c[0]) + calc(memory,c,n-c[1]) + calc(memory,c,n-c[2]);
        return memory[n];
    }

    public static void main(String[] args) {
        int[] coins = { 1, 3, 5 };
        int value = 6;
        int[] memory = new int[value+1];
        System.out.println(calc(memory,coins,value));
    }
}
