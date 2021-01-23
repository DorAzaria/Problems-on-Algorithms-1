package GeeksforGeeks;

public class LargestPlus {

	public static int largestPlus(int[][] mat) {
		int n = mat.length;
		int m = mat[0].length;

		int[][] up = new int[n][m];
		int[][] down = new int[n][m];
		int[][] left = new int[n][m];
		int[][] right = new int[n][m];

		for (int i = 0; i < m; i++) {
			up[0][i] = mat[0][i];
		}
		for (int i = 0; i < m; i++) {
			down[n-1][i] = mat[n-1][i];
		}
		for (int i = 0; i < n; i++) {
			left[i][0] = mat[i][0];
		}
		for (int i = 0; i < n; i++) {
			right[i][m - 1] = mat[i][m - 1];
		}


		int max = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(mat[i][j] != 0) {
					if(i != 0) {
						up[i][j] = up[i-1][j] + 1;
					}
					if(j != 0) {
						left[i][j] = left[i][j-1] + 1;
					}
				}
			}
		}
		for (int i = n-1; i >= 0; i--) {
			for (int j = m-1; j >= 0; j--) {
				if(mat[i][j] != 0) {
					if(i != n-1) {
						down[i][j] = down[i+1][j] + 1;
					}
					if(j != m-1) {
						right[i][j] = right[i][j+1] + 1;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if(Math.min(Math.min(up[i][j], down[i][j]),Math.min(left[i][j], right[i][j])) > max) {
					max = Math.min(Math.min(up[i][j], down[i][j]),Math.min(left[i][j], right[i][j]));
				}
			}
		}

		System.out.println("UP === ");
		print(up);
		System.out.println("DOWN === ");
		print(down);
		System.out.println("LEFT === ");
		print(left);
		System.out.println("RIGHT === ");
		print(right);
		System.out.println("ORIGINAL === ");
		print(mat);
		return (max-1)*4 + 1;
	}

	private static void print(int[][] arr) {
		for(int i = 0 ; i < arr.length ; i++) {
			for(int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
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
