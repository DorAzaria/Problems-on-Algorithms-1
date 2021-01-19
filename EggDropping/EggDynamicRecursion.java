package EggDropping;

public class EggDynamicRecursion {

    public static int minimalAttempts(int floors, int balls) {
        int[][] attempts = new int[floors+1][balls+1];
        for(int i = 0; i < attempts.length; i++) {
            attempts[i][0] = 0;
            attempts[i][1] = i;
        }
        for(int j = 1 ; j < attempts[0].length; j++) {
            attempts[0][j] = 0;
            attempts[1][j] = 1;
        }

        generateRec(attempts,2,2,1, Integer.MAX_VALUE);
        printRec(attempts,0,0);
        return attempts[floors][balls];
    }

    private static void generateRec(int[][] attempts, int b, int n, int i, int min) {
        if(b == attempts[0].length) {
            return;
        } else if(n == attempts.length) {
            generateRec(attempts,b+1,2,1,min);
        } else if(i == n) {
            attempts[n][b] = min;
            generateRec(attempts,b,n+1,1,Integer.MAX_VALUE);
        } else {
            int max = Math.max(attempts[n-i][b], attempts[i-1][b]) + 1;
            if(min > max) {
                min = max;
            }
            generateRec(attempts,b,n,i+1,min);
        }
    }

    public static void printRec(int[][] attempts, int i, int j) {
        if(i == attempts.length) {
            return;
        } else if(j == attempts[0].length) {
            System.out.println();
            printRec(attempts,i+1,0);
        } else {
            System.out.print(attempts[i][j] + "\t");
            printRec(attempts,i,j+1);
        }
    }

    public static void main(String[] args) {
        System.out.println("minimal: " + minimalAttempts(6,3));
    }
}
