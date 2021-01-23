
package EggDropping;

public class EggDynamicInduction {

    public static int minimalAttempts(int floors, int balls) {
        int[][] attempts = new int[floors+1][balls+1];

        for(int i = 0; i < attempts.length; i++) {
            attempts[i][1] = i;
        }
        for(int j = 1 ; j < attempts[0].length; j++) {
            attempts[1][j] = 1;
        }

        for(int b = 2; b < attempts[0].length; b++) { // balls
            for(int n = 2; n < attempts.length ; n++) { // floors
                int min = Integer.MAX_VALUE;
                for(int i = 1; i <= n; i++) {
                    int max = Math.max(attempts[i-1][b-1], attempts[n-i][b]) + 1;
                    if(min > max) {
                        min = max;
                    }
                }
                attempts[n][b]= min;
            }
        }

        printMatrix(attempts);
        return attempts[floors][balls];
    }

    public static void printMatrix(int[][] attempts) {
        for(int i = 0 ; i < attempts.length; i++) {
            for(int j = 0 ; j < attempts[0].length; j++) {
                System.out.print(attempts[i][j]+ "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        System.out.println("minimal: " + minimalAttempts(105,2));
    }
}