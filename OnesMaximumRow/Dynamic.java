package OnesMaximumRow;

public class Dynamic {

    public static int dynamic(int[] arr){
        int[] count = new int[arr.length];

        if(arr[0] == 1)
            count[0] = 1;

        int max = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == 1) {
                count[i] = count[i-1] + 1;
                if(count[i] > max)
                    max = count[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,0,1,0,0,1,1,1,1};
        System.out.println(dynamic(arr)); // prints 4
    }
}
