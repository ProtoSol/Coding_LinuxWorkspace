import java.util.Scanner;

class ArrayOperations {
    int arr[]; // Array to store integers
    int size; // Current number of elements in the array

    /**
     * Constructor to initialize the array with the given capacity.
     * @param capacity The maximum number of elements the array can hold.
     */
    ArrayOperations(int capacity) {
        arr = new int[capacity]; // Initialize the array with the given capacity
        size = 0; // Initially, the array is empty
    }

    /**
     * Inserts an element at the specified position in the array.
     * @param position The position where the element should be inserted (1-indexed).
     * @param element The element to be inserted.
     */
    void insert(int position, int element) {
        // Check if the array is full
        if (size == arr.length) {
            System.out.println("Array is Full can't Insert...");
            return;
        }
        int currentIndex = position - 1;
        // Shift elements to make space for the new element
        for (int i = size - 1; i >= currentIndex; i--) {
            arr[i + 1] = arr[i];
        }
        arr[currentIndex] = element; 
        size++; // Increment the size of the array
        
        // otherwise shift the elements till reach the last element, 
        //start from the position
    }

    /**
     * Searches for an element in the array.
     * @param element The element to be searched.
     * @return The index of the element if found, -1 otherwise.
     */
    int search(int element) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes the specified element from the array.
     * @param element The element to be removed.
     */
    void remove(int element) {
        int index = search(element);
        if (index == -1) {
            System.out.println("Element Not Exist Can't Remove");
            return;
        }
        // Remove logic
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0;
        size--;
    }

    /**
     * Prints all elements in the array.
     */
    void print() {
        for (int element : arr) {
            System.out.println(element);
        }
    }
}

public class ArrayOperationsDemo {

    public static void main(String[] args) {
        int capacity = 10;
        ArrayOperations obj = new ArrayOperations(capacity);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Insertion ");
            System.out.println("2. Remove");
            System.out.println("3. Update");
            System.out.println("4. Search");
            System.out.println("5. Print");
            System.out.println("6. Exit");
            System.out.println("Enter the Choice");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    obj.insert(1, 100);
                    obj.insert(2, 200);
                    obj.insert(1, 900);
                    obj.insert(1, 1000);
                    break;

                case 2:
                    obj.remove(900);
                    break;

                case 4:
                    if (obj.search(1000) == -1) {
                        System.out.println("Element Not Found");
                    }
                    break;

                case 5:
                    obj.print();
                    break;

                case 6:
                    return;
                    // System.exit(0);
            }
        }
        
    }
}