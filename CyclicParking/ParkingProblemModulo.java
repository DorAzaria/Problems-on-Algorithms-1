package CyclicParking;

public class ParkingProblemModulo {

    /**
     * 1 means someone marked the car as visited.
     * 2 means that I marked the car as visited.
     * @param arr a numeric array.
     * @return the number of cars.
     */
    public static int solution(int[] arr) {

        int temp_counter = 0;
        int main_counter = 0;
        int start = 1;
        boolean flag = false;
        while(!flag) {

            // go forward
            while(arr[(start + temp_counter) % arr.length] != 1) {
                temp_counter++;
            }

            arr[(start + temp_counter ) % arr.length] = 2;
            temp_counter++;
            main_counter = temp_counter;

            // go backward
            while( temp_counter != 0 ) {
                temp_counter--;
            }
            if(arr[temp_counter] == 2) {
                flag = true;
            }

        }
        return main_counter;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,1,1};
        System.out.println(solution(a));
        a = new int[]{1,1,1,1,1,1,1,1,1,1};
        System.out.println(solution(a));

        int[] arr = {1,2,3,4,5};
        int start = 3;
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[(start - i + arr.length) % arr.length] + ",");
        }
    }
}
