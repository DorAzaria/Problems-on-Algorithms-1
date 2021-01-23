package EggDropping;

public class GlassBall {

    /*
        Time Complexity: O(2 * sqrt(N) )
     */
    public static int break_ball_floor(int[] floors, int balls) {
        int num_floors = floors.length;
        int k = 1;

        // divide the building to k parts
        while(num_floors > gauss(k)) {
            k++;
        }

        int current_floor = k;
        int next_part = k-1;

        // catch the exact current_floor for the first case the ball is broken
        while(floors[current_floor] < balls) {
            current_floor += next_part;
            next_part--;
        }

        int last_floor = current_floor - (next_part + 1);
        while(floors[last_floor] < balls) {
            last_floor++;
        }

        return last_floor;
    }

    public static int gauss(int k) {
        return ( k*(k+1) ) / 2 ;
    }

    /*
        Time Complexity: O(sqrt(2N))
     */
    public static int break_ball_floor2(int[] floors, int balls) {
        int num_floors = floors.length;

        if(balls>=floors[num_floors-1])
            return -1;

        int last_floor = 1;
        int k = 1;

        while(num_floors > gauss(k)){
            k++;
        }

        int current_floor = k;

        while(current_floor <= num_floors){

            if(balls < floors[current_floor - 1]){
                last_floor  = current_floor - k + 1;

                while(balls > floors[last_floor]) {
                    last_floor++;
                }
                break;
            }

            k--;
            current_floor += k;

            if (current_floor> num_floors)
                current_floor = num_floors;
        }
        return last_floor ;
    }

    public static int twoBalls(int n) {
        int[] f = new int[n+1];
        f[0] = 0;
        f[1] = 1;

        for (int i = 3; i <= n; i++) {
            int min = n;
            for (int j = 1; j < i-1; j++) {
                int x = Math.max(j, f[i-j]+1);
                if (x < min)
                    min = x;
            }
            f[i] = min;
        }
        return f[n];
    }

    public static int threeBalls(int n) {
        int[] f3 =new int[n+1];

        if(n==1) {
            f3[n] =1;
        }
        else if(n==2) {
            f3[n] = 2;
        }
        else { // if n>=3
            int[] f2 = new int[n+1];
            for(int i = 1; i < n ; i++) {
                f2[i] = twoBalls(i);
            }
            f3[0] = 0;
            f3[1] = 1;
            f3[2] = 2;
            f3[3] = 2;
            for(int i = 4; i <= n ; i++) {
                int min = n;
                for(int j = 1; j < i ; j++) {
                    int x = Math.max(f2[j-1]+1, f3[i-j]+1);

                    if(x < min) {
                        min = x;
                    }
                }
                f3[i] = min;
            }
        }
        return f3[n];
    }

    public static void main(String[] args) {
        int [] arr = {1,2,3,4,5,6};
        System.out.println(break_ball_floor(arr,3));
        System.out.println(threeBalls(6)); // 3
        System.out.println(twoBalls(105)); // 14
    }
}
