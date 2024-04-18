package technicalTraining;

public class loops {
    public static void main(String[] args) {
        int count = 0;
        int num = 6;

        // // Bruteforce
        // for(int i = 1; i <= num; i++){
        //     if(num % i == 0){
        //         // IF NOT PRIME FLAG == 1
        //         count ++;
        //     }
        // }
        // We are using the advanced syntax of the if condition
        // condition ? (if true) "Statement" : (If False) "Statement"
        // System.out.println(count == 2? "Prime Number": "Not Prime Number");
        

        // // Better
        // for(int i = 2; i < num; i++){
        //     if(num % i == 0){
        //         System.out.println("Not A Prime");
        //         return ;
        //     }
        // }
        // System.out.println("Prime Number");

        // Optimal
        for(int i = 2; i*i < num; i++){
            if(num % i == 0){
                System.out.println("Not A Prime");
                return ;
            }
        }
        System.out.println("Prime Number");

    }
}
