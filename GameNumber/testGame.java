package GameNumber;

public class testGame {

    private static int[] arraysForTest(int size) {
        int []arr = new int[size];
        for(int i=0; i<arr.length;i++){
            arr[i] = i+1;
        }
        shuffle(arr);
        return arr;
    }

    public static void shuffle(int[] arr){
        int size = arr.length;
        for(int i=0; i<size;i++){
            int r = (int)(Math.random()*size);
            int t = arr[i];
            arr[i] = arr[r];
            arr[r] = t;
        }
    }

    public static void main(String[] args) {

        int size = 1000000, n=100;
        int g1=0, g2=0 , g3=0, g4=0;

        for (int i = 0; i < n; i++) {
            int[] arr = arraysForTest(size);

            int[] sol = Greedy.game(arr);
            if(sol[0] > sol[1])
                g1++;
//
//            start = System.currentTimeMillis();
//            maxMax2.maxMax(arr);
//            end = System.currentTimeMillis();
//            time = end - start;
//            mm2 = mm2 + time;


        }

        System.out.println("for " + n + " different arrays of size : " + size + ", the results are: " );
        System.out.println("Greedy: " + g1 + " wins out of "+n+" games.");
    }

}
