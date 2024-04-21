package Technical_Training;

public class shiftingNumber {
    public static void main(String[] args) {
        int num = 123456789;
        // int count = num;
        int result = 0;
        int r = 2;
        int pos = (int) Math.pow(10, r);
        // int rem = num % pos;
        num = num/pos;
        
        System.out.println(result);
    }
}
