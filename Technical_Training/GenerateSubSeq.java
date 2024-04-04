package Technical_Training;

public class GenerateSubSeq {
    // Generate a substring sequence from a given substring
    static void generateSubSeq(String str, String result){
        // Base Case
        if(str.length() == 0){
            System.out.println(result);
            return;
        }
        // Not Taken
        generateSubSeq(str.substring(1), result);
        // Taken
        generateSubSeq(str.substring(1), result + str.charAt(0));
    }

    public static void main(String[] args) {
        generateSubSeq("str", "");   
    }
}
