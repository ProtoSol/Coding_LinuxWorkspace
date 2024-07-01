package Stack;

import java.util.Stack;

public class IntroToStack {

    // Linear Data Structure
    // LIFO -> Last in First out
    // Works on the base of Head pointer
    // Perform Operation like
        // Push (add to top)
        // Pop (remove the top)
        // Peek (read the stack)
        // Empty (if empty)

    // Time complexity (O(n) if not tail present, else O(1) if Tail present)
    // Space complexity (O(n))
    
    // For this We will be using the Pre built Stack

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(100);
        stack.push(200);
        stack.push(300);
        // These elements will be inserted at the end.

        System.out.println(stack.peek());

        System.out.println(stack.pop());

        System.out.println(stack.peek());

        // If Empty
        System.out.println(stack.isEmpty());

        // Size
        System.out.println(stack.size());
    }
}
