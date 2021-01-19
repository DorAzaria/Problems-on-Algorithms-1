package LongestDecreasingSubsequence;

import java.util.Stack;

public class ImprovedGreedy {

    public static Stack<Integer> greedy(int[] arr, int start) {
        Stack<Integer> sequence = new Stack<>();
        sequence.add(arr[start]);

        for(int i = start+1; i < arr.length; i++) {
            if(sequence.peek() > arr[i])
                sequence.add(arr[i]);
        }

        return sequence;
    }

    public static Stack<Integer> improved(int[] arr) {
        Stack<Integer> sequence = new Stack<>();

        for(int i = 0 ; i < arr.length; i++) {
            Stack<Integer> temp_seq = greedy(arr,i);
            if(temp_seq.size() > sequence.size())
                sequence = temp_seq;
        }
        return sequence;
    }

    public static void main(String[] args) {
        int[] arr = {7, 6, 5, 4, 3, 2, 101, 100, 1};
        System.out.println(improved(arr)); // prints [7, 6, 5, 4, 3, 2, 1]
    }
}
