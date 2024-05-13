// Use Case of Interface:-
// what to do - (Used for Planning)

interface Player{ // Interface is 100% abstract
    int MAX = 100; // This variable is -> (public static final int MAX = 100)
    void jump(); // These are Abstract Class (Public access Modifier)
    void run(); // These are Abstract Class (Public access Modifier)
    void punch(); // These are Abstract Class (Public access Modifier)
    void walk(); // These are Abstract Class (Public access Modifier)
}

interface ExtraPower{
    int MAX = 200;
    void extra();
    void limitedtime();
    void jump();
}

interface MultipleInheritance extends Player, ExtraPower{
    // this is possible as the extended interface has empty functions
    // There is no constructor chain problem and no need for initialization needed.
}

// class - (how to do)
class Ryu implements MultipleInheritance{
    // Class can implement multiple interface but can only extends one class.
    // class gets extended first then interface is implemented.
    // interface extends interface.
    // multiple inheritance is achievable using interface only.

    @Override
    public void jump() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jump'");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    @Override
    public void punch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'punch'");
    }

    @Override
    public void walk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'walk'");
    }

    @Override
    public void extra() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'extra'");
    }

    @Override
    public void limitedtime() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limitedtime'");
    }

}
class Honda implements Player{

    @Override
    public void jump() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'jump'");
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

    @Override
    public void punch() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'punch'");
    }

    @Override
    public void walk() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'walk'");
    }

}
class Ken{

}

public class Interface {
    
}
