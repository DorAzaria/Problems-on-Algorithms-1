package OnesMaximumRow;

public class Greedy {

    public static int greedy(int[] arr){
        int ans = 0;
        for(int i = 0 ; i < arr.length ; i++) {
            if(arr[i] == 0) {
                break;
            }
            ans++;
        }
        return ans;
    }
    public static int greedyRec(int[] arr, int i){
        if(i == arr.length)
            return 0;
        if(arr[i] == 0)
            return 0;
        return greedyRec(arr,i+1) + 1;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,1,1,1,1};
        System.out.println(greedy(arr)); // prints 2
        System.out.println(greedyRec(arr,0)); // prints 2
    }
}
