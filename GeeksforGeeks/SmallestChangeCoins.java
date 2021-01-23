package GeeksforGeeks;

import java.util.Arrays;

public class SmallestChangeCoins {

    public static int dynamicChange(int n) {
        int[] coins = {1,5,10};
        int[] sum = new int[n+1];
        sum[0] = 1;

        for(int i = 0 ; i < coins.length; i++) {
            int coin = coins[i];
            for(int j = coin ; j <= n ; j++) {
                sum[j] = sum[j] + sum[j-coin];
            }
        }
        return sum[n];
    }

    public static void main(String[] args) {
        int n = 7;
        System.out.println(dynamicChange(n));
    }
}
