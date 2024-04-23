// e.g. SavingAccount, CurrentAccount

// Parent Class thus Common Features

// Scopes - Local scope(Within the function or the code block), Private Scope (within the class)
// Default scope (Within the folder / package)
// protected scope (Withing the folder, outside the package using Inheritance)
// public scope (Anywhere)
// There is no Global scope in java environment.

abstract class Account{
    int id;
    String name;
    double balance;
    double roi;

    // In the case where all child have the same function we make abstract function
    abstract void rateOfInterest(); // Body less code.
    // This type of function can only be created in abstract class.
    // public void rateOfInterest(){
    //     System.out.println("Account ROI 3%");
    // }
    public void deposit(){
        System.out.println("Deposited");
    }
    public void withDraw(){
        System.out.println("Withdrawed");
    }
    public void showBalance(){
        System.out.println("Balance Shown");
    }
}

// Child class thus extends the parent class
class SavingAccount extends Account{
    // Overriding (Can only be done in Inheritance) (IS A relationship is a must have)
    // parent and child method signature should be same
    // Overriding is done as Parent method is outdated, that's why we override in chid Class.
    // @Override Annotation that Compiler and Developer gets Signal that Here overriding is being performed.
    // Parent functions gets overshadowed.
    @Override
    public void rateOfInterest(){
        System.out.println("Saving Account ROI 4.5%");
    }
    public void limit(){
        System.out.println("Limit Reached");
    }
}

// Child class
class CurrentAccount extends Account{
    @Override
    public void rateOfInterest(){
        System.out.println("Current Account ROI 3.5%");
    }
    public void noLimit(){
        System.out.println("No Limit");
    }
    public void odLimit(){
        System.out.println("Limit Reached");
    }
}

abstract class  Loan {
    abstract void computEMI();
    void loanAprrove(){

    }
    abstract void roi();
    abstract void rulesReg();
}

class HomeLoan extends Loan{

    @Override
    void computEMI() {
        
    }

    @Override
    void roi() {
        
    }

    @Override
    void rulesReg() {
        
    }
    // As we can see we have to make functions for the abstract functions with the same name
    // to Override them.
}


public class IS_A_demo {
    public static void main(String[] args) {
        SavingAccount sa = new SavingAccount();
        sa.deposit();
        sa.limit();
        sa.withDraw();
        sa.rateOfInterest();
        System.out.println("************");
        CurrentAccount ca = new CurrentAccount();
        ca.odLimit();
        ca.noLimit();
        ca.withDraw();
        ca.rateOfInterest();
    }
}
