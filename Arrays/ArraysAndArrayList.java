import java.util.Arrays;
import java.util.Scanner;

public class ArraysAndArrayList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Why the arrays are requried ?
        // this is used to store a large number of similar type of data in sequence.

        // The syntax is as follows:
        // datatype[] var_name = new datatype[size];
        // For Eg to store 5 numbers

        // int[] rollno = new int[5];
        // // This can be done directly
        // int[] rollno2 = {1,2,3,4,5,6,7,8,9};
        // // All must be the same datatype, cannot be mismatched.

        int[] ros; // declaration of array stored in stack.

        ros = new int[5]; // initialization of object is being created here and stored in heap.
        // {0, 0, 0, 0, 0}

        // everything at the right of the equal sign happens in runtime.
        // and the left at the compilation time.

        // This is called dynamic memory allocation.

        // In java, It depends on the javm if it will stored continously or differently.
        // as heap objects can or cannot be continous.
        
        // new is used to create an object.

        // System.out.println(ros[0]);
        // This goes same for the String objects.
        // String[] string1 = new String[4];
        // System.out.println(string1[3]);
        // This gives out null as a value. null is a literal it can be assigned but cannot be created.
        // a = null works but null = 'Hello' wont work.

        // This can be assigned to non primitive datatype.

        // non primitive are only stored in heap memory, while primitive datatype are stored in stack.

        // The string stores objects and each object has a referal that points it in the heap memory.
        // If the String is not initialized all the referals points towards null.

        // We will use the ros from the above
        // Now we will take input using for loop
            // If we know the lenght of the array we can use it.
            // but if not then we use arr_name.length.
        for (int i = 0; i < ros.length; i++) {
            ros[i] = sc.nextInt();
        }
        sc.close();
        // Now printing out the values.
        for (int i = 0; i < ros.length; i++) {
            System.out.print(ros[i] + " ");;
        }

        System.out.println(" ");

        // We used the for each loop advanced version.
        for(int num : ros){
            System.out.print(num + " ");
        } 
        System.out.println(" ");

        // here num represents the element of the array.

        // If we try to print the element out of the index range we get the error "ArrayIndexOutOfBound"

        // Another way of printing is using Arrays.tostring() method

        System.out.println(Arrays.toString(ros));
        
        // We can directly change the value of objects in the array_variable.

    }
}