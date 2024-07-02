package Stack;

import java.util.Stack;

public class PGE {

    // Previous Greater element Problem
    public static void main(String[] args) {
        int arr[] = {10,5,100,90,88,99};
        Stack<Integer> stack = new Stack<>();
        stack.push(arr[0]);
        System.out.println(-1);
        for(int i = 1; i < arr.length; i++){
            while (!stack.isEmpty()&& stack.peek() <= arr[i]) {
                stack.pop();
            }
            int prevGreatElement = stack.isEmpty()?-1:stack.peek();
            System.out.println(prevGreatElement);
            stack.push(arr[i]);
        }
    }
}
