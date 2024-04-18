import java.util.Scanner;

public class Functions {

    // The function have these things to notice:
    // acess modifier
    // return type
    // parameters
    public void addSum(int a, int b){
        System.out.println("Sum : " + (a + b));
    }

    public static void main(String[] args) {
        // Q: take an input of two numbers and print the sum.
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        // We made an object to call methods from the static function.
        Functions fc = new Functions();
        fc.addSum(a, b);
    }

    // Scoping
    // Shadowing (the recent variable will be considered rather than old one with same name.)
    // When we are not sure how many variables will be passed in the function we perform.
    // void add (int ...v) 
    // ...v is considered as an array of type int and variable name v.

    //We can mix match the argument types too, but the order should be followed.
    

}