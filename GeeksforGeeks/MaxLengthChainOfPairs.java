package GeeksforGeeks;

import java.util.Arrays;

public class MaxLengthChainOfPairs {

    /*
    An Amazon interview question.
    You are given n pairs of numbers.
    In every pair, the first number is always smaller than the second number.
    A pair (c, d) can follow another pair (a, b) if b < c.
    Chain of pairs can be formed in this fashion.
    Find the longest chain which can be formed from a given set of pairs.
     */

    public static int dynamic(int[][] arr) {

        int[] chains = new int[arr.length];

        for(int i = 0 ; i < chains.length; i++) {
            chains[i] = 1;
        }

        for(int i = 1; i < arr.length; i++) {
            for(int j = 0 ; j < i ; j++) {
                if (arr[i][0] > arr[j][1]) {
                    if (chains[i] < chains[j] + 1) {
                        chains[i] = chains[j] + 1;
                    }
                }
            }
        }

        int max = 0;
        for(int i = 0; i < chains.length; i++) {
            if(max < chains[i]) {
                max = chains[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] chain = {{5, 24},
                {39, 60},
                {15, 28},
                {27, 40},
                {50, 90}
                        };
        System.out.println(dynamic(chain));

        int[][] smoker = {{1,2},
                {3,4},
                {5,6},
                {7,8},
                {10,11},
                {20,500}
        };
        System.out.println(dynamic(smoker));
    }
}
