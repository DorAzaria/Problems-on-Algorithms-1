package LongestIncreasingSubsequence;

import java.util.Stack;

public class Greedy {

    public static Stack<Integer> greedy(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++) {
            if(stack.peek() < arr[i])
                stack.push(arr[i]);
        }
        return stack;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2};
        System.out.println(greedy(arr)); // [1, 3, 4]
    }
}
