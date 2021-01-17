package LargestRowOfOnes;

public class ImprovedGreedy {

    public static int improved(int[] arr) {
        int max = 0;
        int current_max = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                current_max++;
                if(current_max > max){
                    max = current_max;
                }
            }
            else {
                current_max = 0;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,1,1,1,1};
        System.out.println(improved(arr)); // prints 4
    }
}
