package LittleProblems;

public class ThePizza {

    public static boolean pizza(double X , int N) {
        int F = (int)X + 1 ;
        int P =  N / (F + 1);
        int r = N % (F+1);

        if(2 <= r && r <= (int)X) {
            double t = (X*P + r - 1) / ((X+1)*P + r);
            if(t < X/(X+1) ) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(pizza(2,6)); // true
        System.out.println(pizza(2,4)); // false
    }
}
