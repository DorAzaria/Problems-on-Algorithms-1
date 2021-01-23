package GeeksforGeeks;

import java.util.Arrays;

public class GameNumberCycle {
	public static int numberGame(int[] arr) {
		int n = arr.length;
		int[][] m = new int[n][n];
		for (int i = 0; i < m.length; i++) {
			m[i][i] = arr[i];
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = i+1; j < n; j++) {
				m[i][j] = Math.max(arr[i] - m[i+1][j], arr[j] - m[i][j-1]);
			}
		}
		for (int i = 0; i < m.length; i++) {
			System.out.println(Arrays.toString(m[i]));
		}
		return m[0][n-1];
	}
	
	public static int numberGameCycle(int[] arr) { // O(n^3)
		int n = arr.length;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			int a = arr[i];
			int[] b = new int[n-1];
			int k = (i+1) % n;
			for (int j = 0; j < n-1; j++) {
				b[j] = arr[k];
				k = (k+1) % n;
			}
			int f = numberGame(b);
			if(a-f > max) max = a-f;
		}
		return max;
	}
	
	public static void main(String[] args) {
		// tt
		int[] arr = {1,3,6,1,3,6};
		System.out.println(numberGameCycle(arr));
	}
}
