package GeeksforGeeks;

public class ShortestCommonSuperSequence {
    /**
     * Shortest Common SuperSequence
     */
        private int[][] mat;
        private int n,m;
        private String X,Y;

        public ShortestCommonSuperSequence(String X,String Y) {
            this.X = X;
            this.Y = Y;
            buildLCSMatrix();
        }

        /**
         * LCS
         * Complexity: O(n*m)
         */
        private void buildLCSMatrix() {
            n = X.length()+1;
            m = Y.length()+1;
            mat = new int[n][m];
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if(X.charAt(i-1) == Y.charAt(j-1)) {
                        mat[i][j] = mat[i-1][j-1] + 1;
                    }
                    else {
                        mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
                    }
                }
            }
        }

        /**
         * SCS(X,Y) = |X| + |Y| - |LCS(X,Y)|
         * returns the string length
         */
        public int getSCSLength() {
            return X.length() + Y.length() - mat[n-1][m-1];
        }

        /**
         * SCS - returns the string
         * Complexity: O(n*m)
         */
        public String getSCSString() {
            return getSCSString(n-1,m-1);
        }

        private String getSCSString(int i, int j) {
            if(i == 0 && j == 0) return "";
            if(i == 0) {
                return getSCSString(i,j-1) + Y.charAt(j-1);
            }
            if(j == 0) {
                return getSCSString(i-1,j) + X.charAt(i-1);
            }
            if(X.charAt(i-1) == Y.charAt(j-1)) {
                return getSCSString(i-1,j-1) + X.charAt(i-1);
            }
            else {
                if(mat[i-1][j] > mat[i][j-1]) {
                    return getSCSString(i-1,j) + X.charAt(i-1);
                }
                else {
                    return getSCSString(i,j-1) + Y.charAt(j-1);
                }
            }
        }

        public static void main(String[] args) {
            /// tt
            System.out.println(new ShortestCommonSuperSequence("shortest", "string").getSCSString());
        }
}
