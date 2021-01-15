package GameNumber;

//for 100 different arrays of size : 10000, the results are:
//Greedy: 45 wins out of 100 games.
//Even or Odd: 100 wins out of 100 games.
//Adaptive: 100 wins out of 100 games.
//Dynamic: 10 wins out of 10 games.

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

        int size = 10000, n=100;
        int g1=0, g2=0 , g3=0, g4=0;
        int[] arr;
        for (int i = 0; i < n; i++) {

            arr = arraysForTest(size);

            int[] sol = Greedy.game(arr);
            if(sol[0] > sol[1])
                g1++;


            sol = EvenOrOdd.game(arr);
            if(sol[0] > sol[1])
                g2++;


            sol = Adaptive.game(arr);
            if(sol[0] > sol[1])
                g3++;


            if(i % 10 == 0) {
                sol = Dynamic.dynamic(arr);
                if(sol[0] > sol[1])
                    g4++;
            }

        }
        System.out.println("for " + n + " different arrays of size : " + size + ", the results are: " );
        System.out.println("Greedy: " + g1 + " wins out of "+n+" games.");
        System.out.println("Even or Odd: " + g2 + " wins out of "+n+" games.");
        System.out.println("Adaptive: " + g3 + " wins out of "+n+" games.");
        System.out.println("Dynamic: " + g4 + " wins out of " + n/10 + " games. ");
    }

}
