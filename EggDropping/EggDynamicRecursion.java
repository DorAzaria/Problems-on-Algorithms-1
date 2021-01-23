package EggDropping;

public class EggDynamicRecursion {

    public static int minimalAttempts(int floors, int balls) {
        int[][] attempts = new int[floors+1][balls+1];
        for(int i = 0; i < attempts.length; i++)
            attempts[i][1] = i;
        for(int j = 1 ; j < attempts[0].length; j++)
            attempts[1][j] = 1;

        generateRec(attempts,2,2,1, Integer.MAX_VALUE);
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
            int max = Math.max(attempts[i-1][b-1], attempts[n-i][b]) + 1;
            if(min > max) {
                min = max;
            }
            generateRec(attempts,b,n,i+1,min);
        }
    }

    public static void main(String[] args) {
        System.out.println("minimal: " + minimalAttempts(105,2));
    }
}
