import java.util.Queue;
import java.util.LinkedList;

class MyStackUsingQueue {
    Queue<Integer> q1;
    Queue<Integer> q2;
    
    // Initialize both queues using LinkedList
    public MyStackUsingQueue() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Add element to q2, then move all from q1 to q2, then swap q1 and q2
    public void push(int data) {
        q2.offer(data);
        while (!q1.isEmpty()) {
            q2.offer(q1.poll());
        }
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
    }

    // Remove and return the top element from q1
    public int pop() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return q1.poll();
    }

    // Return the top element from q1 without removing it
    public int peek() {
        if (q1.isEmpty()) {
            throw new RuntimeException("Stack is Empty");
        }
        return q1.peek();
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