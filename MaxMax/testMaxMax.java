package MaxMax;

/*
    for 100 different arrays of size : 1000000, the results are:
    MaxMax1 by average : 1.63 Millis.
    MaxMax2 by average : 1.03 Millis.
    MaxMax3 by average : 3.57 Millis.
    MaxMax4 by average : 285.7 Millis.
*/

public class testMaxMax {

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

        long start, end;
        int size = 1000000, n=100;
        double mm1=0, mm2=0 , mm3=0, mm4=0;

        for (int i = 0; i < n; i++) {
            int[] arr = arraysForTest(size);

            start = System.currentTimeMillis();
            maxMax1.maxMax(arr);
            end = System.currentTimeMillis();
            long time =  end - start;
            mm1 = mm1 + time;

            start = System.currentTimeMillis();
            maxMax2.maxMax(arr);
            end = System.currentTimeMillis();
            time = end - start;
            mm2 = mm2 + time;

            start = System.currentTimeMillis();
            maxMax3.maxMax(arr);
            end = System.currentTimeMillis();
            time = end - start;
            mm3 = mm3 + time;

            start = System.currentTimeMillis();
            maxMax4.maxMax(arr);
            end = System.currentTimeMillis();
            time = end - start;
            mm4 = mm4 + time;
        }
        System.out.println("for " + n + " different arrays of size : " + size + ", the results are: " );
        System.out.println("MaxMax1 by average : " + mm1/n + " Millis.");
        System.out.println("MaxMax2 by average : " + mm2/n + " Millis.");
        System.out.println("MaxMax3 by average : " + mm3/n + " Millis.");
        System.out.println("MaxMax4 by average : " + mm4/n + " Millis.");

    }
}
