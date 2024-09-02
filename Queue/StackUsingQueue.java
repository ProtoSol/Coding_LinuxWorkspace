import java.util.Queue;
import java.util.LinkedList;

class MyStackUsingQueue {
    Queue<Integer> q1;
    
    // Initialize q1 using LinkedList
    public MyStackUsingQueue() {
        q1 = new LinkedList<>();
    }

    // Add element to q1 at the end
    public void push(int data) {
        q1.offer(data);
    }

    // Remove and return the top element from q1
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q1.offer(q1.poll());
        }
        return q1.poll();
    }

    // Return the top element from q1 without removing it
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        int size = q1.size();
        for (int i = 0; i < size - 1; i++) {
            q1.offer(q1.poll());
        }
        int top = q1.poll();
        q1.offer(top);
        return top;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStackUsingQueue stack = new MyStackUsingQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        
        System.out.println(stack.pop());  // Should print 3
        System.out.println(stack.pop());  // Should print 2
        System.out.println(stack.peek()); // Should print 1
        System.out.println(stack.pop());  // Should print 1
        System.out.println(stack.isEmpty()); // Should print true
    }
}
