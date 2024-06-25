package Linked_List;

import java.util.Scanner;

/**
 * Node = data + address of next Node
 */
class Node<T> {
    T data; // Current Node Data
    Node<T> next; // Reference to the next Node

    // Constructor
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}

// CRUD Operations - Create, Read, Update, Delete
class LinkedListOperations<T> {
    Node<T> head; // First node of the list
    Node<T> tail; // Last node of the list

    // Insert a node at the end of the list
    void insertAtEnd(Node<T> node) {
        if (head == null) {
            tail = head = node; // If list is empty, new node becomes both head and tail
        } else {
            tail.next = node; // Link the new node to the end of the list
            tail = node; // Update the tail to the new node
        }
    }

    // Insert a node at the start of the list
    void insertAtStart(Node<T> node) {
        if (head == null) {
            tail = head = node; // If list is empty, new node becomes both head and tail
        } else {
            node.next = head; // Link the new node to the current head
            head = node; // Update the head to the new node
        }
    }

    // Insert a node at a specific position in the list
    void insertAtPosition(Node<T> node, int position) {
        if (head == null) {
            tail = head = node; // If list is empty, new node becomes both head and tail
            return;
        }
        if (position == 0) {
            node.next = head; // Link the new node to the current head
            head = node; // Update the head to the new node
            return;
        }
        if (position > 0) {
            Node<T> temp = head;
            int i = 1;
            while (i < position && temp.next != null) {
                temp = temp.next;
                i++;
            }
            node.next = temp.next; // Link the new node to the next node
            temp.next = node; // Link the previous node to the new node
            if (temp == tail) {
                tail = node; // Update tail if inserting at the end
            }
        }
    }

    // Delete the first node of the list
    void deleteAtStart() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = tail = null; // If only one node, set both head and tail to null
        } else {
            head = head.next; // Move head to the next node
        }
    }

    // Delete the last node of the list
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty");
        } else if (head == tail) {
            head = tail = null; // If only one node, set both head and tail to null
        } else {
            Node<T> temp = head;
            while (temp.next != tail) {
                temp = temp.next;
            }
            temp.next = null; // Remove the link to the last node
            tail = temp; // Update the tail to the new last node
        }
    }

    // Delete a node at a specific position in the list
    void deleteAtPosition(int position) {
        if (head == null) {
            System.out.println("List is empty");
        } else if (position == 0) {
            head = head.next; // Move head to the next node
            if (head == null) {
                tail = null; // If list becomes empty, update tail as well
            }
        } else {
            Node<T> temp = head;
            int i = 1;
            while (i < position && temp.next != null) {
                temp = temp.next;
                i++;
            }
            if (temp.next != null) {
                temp.next = temp.next.next; // Skip the node to be deleted
                if (temp.next == null) {
                    tail = temp; // Update tail if last node is deleted
                }
            }
        }
    }

    // Search for a node with specific data in the list
    void searchLinkedList(T data) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(data)) { // Use equals() for proper comparison
                System.out.println("Found");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not Found");
    }

    // Update a node with oldData to newData
    void updateLinkedList(T oldData, T newData) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(oldData)) {
                temp.data = newData;
                System.out.println("Updated successfully");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Not Found");
    }

    // Print all nodes in the list
    void printLinkedList() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

class Customer {
    int id;
    String name;
    double balance;
}

public class LinkedList {
    public static void main(String[] args) {
        LinkedListOperations<Integer> operations = new LinkedListOperations<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Insert at End");
            System.out.println("2. Insert at Start");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Start");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Search");
            System.out.println("8. Update");
            System.out.println("9. Print");
            System.out.println("10. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the data: ");
                    operations.insertAtEnd(new Node<>(scanner.nextInt()));
                    break;
                case 2:
                    System.out.print("Enter the data: ");
                    operations.insertAtStart(new Node<>(scanner.nextInt()));
                    break;
                case 3:
                    System.out.print("Enter the data: ");
                    int data = scanner.nextInt();
                    System.out.print("Enter the position: ");
                    int position = scanner.nextInt();
                    operations.insertAtPosition(new Node<>(data), position);
                    break;
                case 4:
                    operations.deleteAtStart();
                    System.out.println("Deleted the first element.");
                    break;
                case 5:
                    operations.deleteAtEnd();
                    System.out.println("Deleted the last element.");
                    break;
                case 6:
                    System.out.print("Enter the position: ");
                    operations.deleteAtPosition(scanner.nextInt());
                    break;
                case 7:
                    System.out.print("Enter the data to search: ");
                    operations.searchLinkedList(scanner.nextInt());
                    break;
                case 8:
                    System.out.print("Enter the old data: ");
                    int oldData = scanner.nextInt();
                    System.out.print("Enter the new data: ");
                    int newData = scanner.nextInt();
                    operations.updateLinkedList(oldData, newData);
                    break;
                case 9:
                    System.out.print("Linked List: ");
                    operations.printLinkedList();
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}