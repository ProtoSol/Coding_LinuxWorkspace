package technicalTraining;

public class swtichCase {
    public static void main(String[] args) {
        // The Advanced Syntax from java 14 not like java 7
        // String item = "Burger";
        // int amount = switch(item){
        //     case "Burger", "Pizza" -> 1000;
        //     case "drink" -> 200;
        //     default -> 0;
        // };
        // System.out.println(amount);

        // yeild keyword
        String item = "Burger";
        int amount = switch(item){
            case "Burger", "Pizza" ->{ 
                System.out.println("Expensive")
                yield 100;
            }
            case "drink" -> 200;
            default -> 0;
        };
        System.out.println(amount);
        // yield was created that would break the arrow function as well as swtich function.
        // the return keyword could only break the  arrow function not the switch function.
    }
}
