package MoedA17;

public class Q3 {

    public static int bsIncrease(int[] sequence, int left, int right, int value) {

        while(right - left > 1) { // while we can compare min two values

            int middle = (right+left)/2;

            if(value <= sequence[middle]) {
                right = middle;
            }
            else if(value > sequence[middle]) {
                left = middle;
            }
        }
        return right;
    }

    public static int bsDecrease(int[] sequence, int left, int right, int value) {

        while(right - left > 1) { // while we can compare min two values

            int middle = (right+left)/2;

            if(value <= sequence[middle]) {
                right = middle;
            }
            else if(value > sequence[middle]) {
                left = middle;
            }
        }
        return right;
    }

    public static int lis(int[] arr){
        int[] sequence = new int[arr.length];
        sequence[0] = arr[0];

        int length = 0;
        for(int i = 1 ; i < sequence.length; i++) { // O(n)

            if(arr[i] < sequence[0]) {
                sequence[0] = arr[i];
            }
            else if(arr[i] > sequence[length]) {
                length++;
                sequence[length] = arr[i];
            } else {
                int index = bsIncrease(sequence,0,length,arr[i]); // O(log n)
                sequence[index] = arr[i];
            }
        }
        return length+1;
    }

    public static int lds(int[] arr){
        int[] sequence = new int[arr.length];
        sequence[0] = arr[0];

        int length = 0;
        for(int i = 1 ; i < sequence.length; i++) { // O(n)

            if(arr[i] > sequence[0]) {
                sequence[0] = arr[i];
            }
            else if(arr[i] < sequence[length]) {
                length++;
                sequence[length] = arr[i];
            } else {
                int index = bsDecrease(sequence,0,length,arr[i]); // O(log n)
                sequence[index] = arr[i];
            }
        }
        return length+1;
    }

    public static int lbs(int[] arr){

        int lds_length = lds(arr);
        int lis_length = lis(arr);
        int max = Math.max(lds_length,lis_length);

        if(max == arr.length) {
            return max;
        } else {
            return  max + 1;
        }
    }

}
