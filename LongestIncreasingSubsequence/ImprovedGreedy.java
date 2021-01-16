package LongestIncreasingSubsequence;

import java.util.Stack;

public class ImprovedGreedy {

    public static Stack<Integer> greedy(int[] arr,int start) {
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        for(int i = start+1; i < arr.length; i++) {
            if(stack.peek() < arr[i])
                stack.push(arr[i]);
        }
        return stack;
    }

    public static Stack<Integer> improved(int[] arr) {
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < arr.length ; i++) {
            Stack<Integer> temp_stack = greedy(arr,i);
            if(temp_stack.size() > stack.size())
                stack = temp_stack;
        }


        return stack;
    }
    public static void main(String[] args) {
        int[] arr = {1, 100, 101, 2, 3, 4, 5, 6, 7};
        System.out.println(improved(arr));
    }
}
