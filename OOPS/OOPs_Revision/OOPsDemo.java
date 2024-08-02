package OOPS.OOPs_Revision;

import java.util.Scanner;

/**
 *  Student
 */
class Student_Data {

    int[] rno;
    String[] names;
    float[] marks;

    Student_Data(int[] rno, String[] names, float[] marks){
        this.rno = rno;
        this.names = names;
        this.marks = marks;
    }

    // public void accept(){
    //     Scanner sc = new Scanner(System.in);
    //     for(int i=0;i<5;i++){
    //         System.out.println("Enter Roll No :");
    //         rno[i] = sc.nextInt();
    //         System.out.println("Enter Name :");
    //         names[i] = sc.next();
    //         System.out.println("Enter Marks :");
    //         marks[i] = sc.nextFloat();
    //     }
    //     sc.close();
    // }

    public void print(){
        for(int i=0;i<5;i++){
            System.out.println("Roll No : "+rno[i]);
            System.out.println("Name : "+names[i]);
            System.out.println("Marks : "+marks[i]);
            System.out.println("-----------------------");
        }
    }

}

public class OOPsDemo {
    public static void main(String[] args) {
        // Store 5 Roll Numbers
        int[] numbers = new int[5];
        // Store 5 Names
        String[] names = new String[5];
        // Store 5 Marks of Student
        float[] marks = new float[5];
        // Data Structure To store 5 student Data
            // Here the Class will be used.
        Student_Data student_data = new Student_Data(numbers, names, marks);
        // student_data.accept();
        student_data.print();
    }
}
