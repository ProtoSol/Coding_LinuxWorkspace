package Recursion;

public class PrintNameRecursion {

    /* 
        The Recursive function consists of two part one is the Base Case;
        The Base Case is used as a termination point for the function,
        until the Base case is reached the function perform it's task.

        The recursion function is of two types Head recursive and Tail recursive.
        Head recursive calls itself first then perform task, while tail recursive do task then calls iteself.
        Tail Recursive is better as the Stack gets eliminated faster.
    */ 
    

    public static void main(String[] args) {
        printName(5);
        printNameWithSurname(5);
    }

    private static void printName(int n){

        // Base Case
        if(n == 0){
            return;
        }
        // Job to perform
        System.out.println("Pranshu");
        printName(n-1);
    }

    private static void printNameWithSurname(int n){
        if (n == 0) {
            return;
        }
        System.out.println("Pranshu + "+ n);
        // Above part is Pre processing
        printNameWithSurname(n-1);
        // Below part is Post Processing
        System.out.println(" Saini + "+ n);
    }
}
