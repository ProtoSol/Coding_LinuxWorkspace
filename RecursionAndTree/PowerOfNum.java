package RecursionAndTree;

public class PowerOfNum {
    public static void main(String[] args) {
        powerOfNum(2,3,1);
        System.out.println("Power of number is : " + powerOfNum2(2, 3));
    }

    // Void return method
    private static void powerOfNum(int num, int pow, int result){
        if (pow == 0) {
            System.out.println("Output : " + result);
            return;
        }
        powerOfNum(num, pow - 1, result * num);
    }

    // Int return
    private static int powerOfNum2(int num, int pow){
        if(pow == 0){
            return 1;
        }
        return num * powerOfNum2(num, pow - 1);
    }
}
