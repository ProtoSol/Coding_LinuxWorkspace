import java.math.BigInteger;
import java.util.LinkedList;

public class WrapperClass {
    public static void main(String[] args) {
        int x = 10;
        Integer y = 10;
        // Here the class Integer class is an wrapper class.

        // Another example being 
        LinkedList<Integer> x1 = new LinkedList<>();
        int y2 = 20;
        x1.add(x); // Auto Boxing

        // x1.add(new Integer(x)); // Manual Boxing

        BigInteger x2 = new BigInteger("100000000000000");
        // Example of the Big data type in usage.
        BigInteger x3 = new BigInteger("100000000000000");
        x2.add(x3);
    }   
}
