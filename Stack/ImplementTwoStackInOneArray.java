package Stack;

/**
 * TwoStack: Implements two stacks in a single array
 */
class TwoStack {

    int arr[];
    int capacity;
    int top1; // Index of top element in stack1
    int top2; // Index of top element in stack2

    // Constructor: Initializes the two stacks
    TwoStack(int capacity) {
        this.capacity = capacity;
        arr = new int[this.capacity];
        top1 = -1;
        top2 = capacity;
    }

    // Pushes an element onto stack1
    void push1(int data) {
        if (top1 < top2 - 1) {
            top1++;
            arr[top1] = data;
        } else {
            throw new RuntimeException("Stack1 is full");
        }
    }

    // Pushes an element onto stack2
    void push2(int data) {
        if (top1 < top2 - 1) {
            top2--;
            arr[top2] = data;
        } else {
            throw new RuntimeException("Stack2 is full");
        }
    }

    // Pops an element from stack1
    int pop1() {
        if (top1 >= 0) {
            int val = arr[top1];
            top1--;
            return val;
        } else {
            throw new RuntimeException("Stack1 Empty ...");
        }
    }

    // Pops an element from stack2
    int pop2() {
        if (top2 < capacity) {
            int val = arr[top2];
            top2++;
            return val;
        } else {
            throw new RuntimeException("Stack2 Empty ...");
        }
    }

    // Returns the top element of stack1 without removing it
    void peek1() {
        if (top1 >= 0) {
            System.out.println(arr[top1]);
        } else {
            System.out.println("Stack1 is empty");
        }
    }

    // Returns the top element of stack2 without removing it
    void peek2() {
        if (top2 < capacity) {
            System.out.println(arr[top2]);
        } else {
            System.out.println("Stack2 is empty");
        }
    }

    // Prints all elements in stack1
    void print1() {
        for (int i = top1; i >= 0; i--) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // Prints all elements in stack2
    void print2() {
        for (int i = top2; i < capacity; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class ImplementTwoStackInOneArray {
    
    public static void main(String[] args) {
        TwoStack obj = new TwoStack(10);
        obj.push1(10);
        obj.push1(20);
        obj.push1(30);
        obj.push2(40);
        obj.push2(50);
        obj.push2(60);

        System.out.println("Stack1:");
        obj.print1();
        System.out.println("Stack2:");
        obj.print2();

        System.out.println("Peek Stack1: ");
        obj.peek1();
        System.out.println("Peek Stack2: ");
        obj.peek2();
    }
}