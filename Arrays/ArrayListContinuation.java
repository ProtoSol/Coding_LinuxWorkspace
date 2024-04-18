import java.util.*;

public class ArrayListContinuation {
    public static void main(String[] args) {
        
        // The syntax to initialize arraylist in java
        // ArrayList<"DataType"> list_name = new ArrayList<"Datatype but not necessary">("Default lenght of the list");

        ArrayList<Integer> list = new ArrayList<>();

        // To input any int and Integer to the list we use .add();
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);
        list.add(1);
        list.add(0);

        System.out.println(list);

        // there is also other functions
        
        // to contains
        System.out.println(list.contains(2));

        // update values.
        list.set(0, 2); // updates the value of the arraylist.

        // removing values using index
        list.remove(2);
        
        // when we print this list obj the ArrayList calls it's own .toString() function.
        System.out.println(list);

        // to input into the ArrayList we use the for loop.
        int n = 10;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            list.add(sc.nextInt());
        }
        sc.close();

        System.out.println(list);

        // To get the index value from the Arraylist we use .get() function.
        for(int i = 0; i < 10; i++){
            System.out.print(list.get(i) + " ");
        }
        
        // For initializing multi dimensional array list we perform the following syntax.
        ArrayList<ArrayList<Integer>> list2 = new ArrayList<>();
        // then we need to add arraylist in list2 that will be equal to the row number.
        for(int i = 0; i < 3; i++){
            list2.add(new ArrayList<>());
        }
        // This is how we initialize multi dimensional arraylist.
    }
}