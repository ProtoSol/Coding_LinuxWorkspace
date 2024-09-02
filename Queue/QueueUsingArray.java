/**
 * QueueUsingArray
 * Implementation of Queue using Arrays
 */

class Queue {
    // The Implementation of Queue using Arrays works with the Circular Queue Logic
    // Where the start and end works independently of each other to make a Queue data structure
    // That follows the FIFO (First In First Out) principle

    // We will use the Array to implement the Queue
    int[] arr;
    int start;
    int end;
    int size;
    public Queue(int size) {
        this.size = size;
        arr = new int[size];
        start = 0;
        end = 0;
    }

    // Operations Push / Offer, Pop / Poll, Peek, isEmpty, size

    public void push(int data) {
        if (!isFull()) {
            arr[end] = data;
            end = (end + 1) % size;
        } else {
            System.out.println("Queue is full");
        }
    }

    public int poll() {
        if (!isEmpty()) {
            int data = arr[start];
            start = (start + 1) % size;
            return data;
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return arr[start];
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return start == end;
    }

    public boolean isFull() {
        return (end + 1) % size == start;
    }

    // Printing the Queue
    public void print() {
        for (int i = start; i != end; i = (i + 1) % size) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}

public class QueueUsingArray {
    public static void main(String[] args) {
        Queue queue = new Queue(5);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        queue.print(); // 1 2 3 4 5
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        System.out.println(queue.peek()); // 3
        queue.print(); // 3 4 5
    }
}

