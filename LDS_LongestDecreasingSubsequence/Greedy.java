package LDS_LongestDecreasingSubsequence;

import java.util.Stack;

public class Greedy {

    public static Stack<Integer> greedy(int[] arr) {
        Stack<Integer> sequence = new Stack<>();

        sequence.add(arr[0]);
        for(int i = 1 ; i < arr.length; i++) {
            if(sequence.peek() > arr[i])
                sequence.add(arr[i]);
        }

        return sequence;
    }

    public static void main(String[] args) {
        int[] arr = {4,3,2,5};
        System.out.println(greedy(arr)); // [4, 3, 2]
    }
}
