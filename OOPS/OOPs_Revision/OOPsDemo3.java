class Human{
    String name;
    int age;
    void display(){
        System.out.println("Name : "+name);
        System.out.println("Age : "+age);
    }
}

class Student extends Human{
    int rollno;
    void display(){
        super.display();
        System.out.println("Roll No : "+rollno);
    }
}

public class OOPsDemo3 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.name = "John";
        s1.age = 20;
        s1.rollno = 1;
        s1.display();
    }
}