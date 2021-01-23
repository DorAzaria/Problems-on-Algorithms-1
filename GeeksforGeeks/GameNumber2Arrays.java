package GeeksforGeeks;

import java.util.Arrays;

public class GameNumber2Arrays {
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
	
	public static int numberGame(int[] arr1, int[] arr2) {
		int n = arr1.length;
		int m = arr2.length;
		int[][][][] f = new int[n][n][m][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				f[i][i][j][j] = Math.max(arr1[i] - arr2[j], arr2[j] - arr1[i]);
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				for (int k = j+1; k < m; k++) {
					int[] b = Arrays.copyOfRange(arr2, j, k+1);
					f[i][i][j][k] = Math.max(arr1[i] - numberGame(b), arr2[j] - f[i][i][j+1][k]);
				}
			}
		}
		return 0;
	}
}
