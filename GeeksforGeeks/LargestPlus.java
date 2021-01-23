package GeeksforGeeks;

public class LargestPlus {
	public static int largestPlus(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;
		int[][] u = new int[n][m];
		int[][] d = new int[n][m];
		int[][] l = new int[n][m];
		int[][] r = new int[n][m];
		for (int i = 0; i < m; i++) {u[0][i] = mat[0][i];}
		for (int i = 0; i < m; i++) {d[n-1][i] = mat[n-1][i];}
		for (int i = 0; i < n; i++) {l[i][0] = mat[i][0];}
		for (int i = 0; i < n; i++) {r[i][m-1] = mat[i][m-1];}
		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(mat[i][j] != 0) {
					if(i != 0) {u[i][j] = u[i-1][j] + 1;}
					if(j != 0) {l[i][j] = l[i][j-1] + 1;}
				}
			}
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				if(mat[i][j] != 0) {
					if(i != n-1) {d[i][j] = d[i+1][j] + 1;}
					if(j != m-1) {r[i][j] = r[i][j+1] + 1;}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(Math.min(Math.min(u[i][j], d[i][j]),Math.min(l[i][j], r[i][j])) > max) {
					max = Math.min(Math.min(u[i][j], d[i][j]),Math.min(l[i][j], r[i][j]));
				}
			}
		}
		return (max-1)*4 + 1;
	}

	public static void main(String[] args) {
		// tt
		int[][] mat = {
				{1,0,1,1,1,1,0,1,1,1},
				{1,0,1,0,1,1,1,0,1,1},
				{1,1,1,0,1,1,0,1,0,1},
				{0,0,0,0,1,0,0,1,0,0},
				{1,0,0,0,1,1,1,1,1,1},
				{1,1,1,1,1,1,1,1,1,0},
				{1,0,0,0,1,0,0,1,0,1},
				{1,0,1,1,1,1,0,0,1,1},
				{1,1,0,0,1,0,0,0,0,1},
				{1,0,1,1,1,1,0,1,0,0}
		};
		System.out.println(largestPlus(mat));
	}
}
