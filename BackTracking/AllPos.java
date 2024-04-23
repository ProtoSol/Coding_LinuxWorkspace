public class AllPos {

    /*
     * function backtrack(curr){
     *  
     * {Base Case}
     * 
     *  for loop {
     *      modify curr
     *      backtrack(curr)
     *      undo whatever modifications were done to curr
     *      }
     * }
     */

    static void allAtoZ(int nLen, String result){
        //Base Case
        if(result.length() == nLen){
            System.out.print(result + " ");
            return;
        }
        for(char alpha = 'A'; alpha <= 'Z'; alpha++){
            allAtoZ(nLen, result + alpha);
        }
    }

    public static void main(String[] args) {
        allAtoZ(2, "");
    }
}
