package GeeksforGeeks;

import java.util.Arrays;
import java.util.Comparator;

public class RaceHorseProblem {
	/**
	 * n^2 horses - an array of speeds
	 * n horses in each race, n>=5
	 * find the 1st, 2nd, 3rd
	 * count = sqrt(horses.length) + 2 = n + 2
	 */
	public static int print3Most(int[] horses) {
		int n = (int) Math.sqrt(horses.length);
		int[][] ans = new int[n][n];
		int k = 0;
		int count = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ans[i][j] = horses[k++];
			}
			count++; race(ans[i], n);
		}
		count++; race(ans, n);
		int[] cand = {ans[n-1][n-2],ans[n-1][n-3],ans[n-2][n-1],ans[n-2][n-2],ans[n-3][n-1]};
		count++; race(cand, 5);
		System.out.println("1st - " + ans[n-1][n-1]);
		System.out.println("2nd - " + cand[cand.length-1]);
		System.out.println("3nd - " + cand[cand.length-2]);
		return count;
	}

	public static void race(int[] horses, int n) {
		if(horses.length == n) {Arrays.sort(horses);}
	}

	public static void race(int[][] horses, int n) {
		if(horses.length == n) {Arrays.sort(horses, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[n-1] < o2[n-1]) return -1;
				if(o1[n-1] > o2[n-1]) return 1;
				return 0;
			}
		});}
	}

	public static void main(String[] args) {
		// tt
		int[] horses = {4,6,10,12,20,1,2,3,7,15,11,13,17,21,25,4,5,14,23,24,9,16,17,18,19, 5, 23, 12, 39, 12, 11, 10, 8, 27, 24, 20};
		System.out.println(print3Most(horses));
	}
}
