package OOPS;


abstract class Employee{
    int id;
    String name;
    double salary;
    void salaryComput(){

    }
    void bonus(){

    }
    void addAllowances(){

    }
    // This is a function that will be same but different for both type of Employee.
    // void joinForm(){ ... }
    // Thus we make abstract function and has to be made by the Child class.
    abstract void veiwForm();
}

class FullTimeEmployee extends Employee{
    // This becomes compulsary to make
    @Override
    void veiwForm() {
        throw new UnsupportedOperationException("Unimplemented method 'veiwForm'");
    }

}

class PartTimeEmployee extends Employee{
    void flexTime(){

    }
    // Same like in the class of Full Time Employee
    @Override
    void veiwForm() {
        throw new UnsupportedOperationException("Unimplemented method 'veiwForm'");
    }
}

public class AbstractClass {
    public static void main(String[] args) {
        // FullTimeEmployee ram = new FullTimeEmployee();
        // PartTimeEmployee shyam = new PartTimeEmployee();
        System.out.println("Testing");
    }
}
