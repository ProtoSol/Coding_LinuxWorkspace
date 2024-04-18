package technicalTraining;

public class Flipping {
    public static void main(String[] args) {
        int num = 32145;
        int pos = 1;
        int result = 0;
        while (num != 0) {
            int temp = 1;
            int lastDig = num % 10;
            for(int i = 1; i < lastDig; i++){
                temp *= 10;
            }
            temp = temp * pos;
            result += temp;
            pos ++;
            num /= 10;
        }
        System.out.println(result);
    }
}
