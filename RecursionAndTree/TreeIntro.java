package RecursionAndTree;

public class TreeIntro {

    // Tree has Multiple Recursive call present in the function making a Branch.

    static void fun(int num){
        if (num <= 0) {
            return;
        }
        System.out.println("Building Stack pre call: " + num);
        fun(num - 1); // Recursive Call
        System.out.println("Stack Completed in b/w call: " + num);
        fun(num - 2); // Recursive Call
        System.out.println("Stack Destroy post call: " + num);
    }

    public static void main(String[] args) {
        fun(3);
    }
}
