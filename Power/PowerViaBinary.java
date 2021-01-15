package Power;

public class PowerViaBinary {


    //  O(log n)
    public static int recursion(int a, int n) {
        return rec(a, n , 1);
    }

    public static int rec(int a, int n, int answer) {

        if(n == 0)
            return answer;

        if(n % 2 == 1)
            answer = answer * a;

        return rec(a * a,n/2,answer);
    }

    // O(log n)
    public static int induction(int a, int n) {
        int answer = 1;

        while (n > 0) {

            if(n % 2 == 1)
                answer = answer * a;

            n = n / 2;
            a = a * a;
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(recursion(2,5)); // 32
        System.out.println(recursion(3,3)); // 27
        System.out.println(induction(2,5)); // 32
        System.out.println(induction(3,3)); // 27
    }
}
