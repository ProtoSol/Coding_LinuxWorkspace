/**
 * QueueUsingLinkedList
 * Implementation of Queue using LinkedList
 */
import java.util.LinkedList;


public class QueueUsingLinkedList {

    // The Implementation of Queue using LinkedList works with the help of the LinkedList class
    // That follows the FIFO (First In First Out) principle
    LinkedList<Integer> list;
    public QueueUsingLinkedList() {
        list = new LinkedList<>();
    }

    // Operations Push / Offer, Pop / Poll, Peek, isEmpty, size

    public void offer(int data) {
        list.addLast(data);
    }

    public int poll() {
        if (!isEmpty()) {
            return list.removeFirst();
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public int peek() {
        if (!isEmpty()) {
            return list.getFirst();
        } else {
            System.out.println("Queue is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Printing the Queue
    public void print() {
        System.out.println(list);
    }

    public static void main(String[] args) {
        QueueUsingLinkedList queue = new QueueUsingLinkedList();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);
        queue.offer(5);
        queue.print(); // 1 2 3 4 5
        System.out.println(queue.poll()); // 1
        System.out.println(queue.poll()); // 2
        System.out.println(queue.peek()); // 3
        queue.print(); // 3 4 5
    }
}