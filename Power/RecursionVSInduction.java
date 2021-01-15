package Power;

public class RecursionVSInduction {

    public static int powerRecursion(int a, int n) { // O(2N)
        return n == 0 ? 1 : a * powerRecursion(a,n-1);
    }

    public static int powerInduction(int a, int n) { // O(N)
        int solution = 1;
        while (n > 0) {
            solution *= a;
            n--;
        }
        return solution;
    }
    public static void main(String[] args) {
        System.out.println(powerRecursion(2,5)); // 32
        System.out.println(powerRecursion(3,3)); // 27
        System.out.println(powerInduction(2,5)); // 32
        System.out.println(powerInduction(3,3)); // 27
    }
}
