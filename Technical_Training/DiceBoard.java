package Technical_Training;
public class DiceBoard {

    // Given a board of NxN size
    // We have a dice that is rolled.
    // We are given a position and We have to print the possible rolls we need.
    // Similar to Maze path

    // Made on the Go
    static void diceBoardScratch(int currentNumber, int sum, int position, String result){
        // Base Case
        if(sum > position){
            return;
        }
        if(sum == position){
            System.out.println(result);
            return;
        }
        // Working Case
        diceBoardScratch(1, sum + 1, position, result + " 1");
        diceBoardScratch(2, sum + 2, position, result + " 2");
        diceBoardScratch(3, sum + 3, position, result + " 3");
        diceBoardScratch(4, sum + 4, position, result + " 4");
        diceBoardScratch(5, sum + 5, position, result + " 5");
        diceBoardScratch(6, sum + 6, position, result + " 6");

    }
    
    // Better Version
    static void diceBoard(int currentNumber, int end, String result){
        if(currentNumber == end){
            System.out.print(result + " , ");
        }
        if (currentNumber > end){
            return;
        }
        for(int dice = 1; dice <= 6; dice ++){
            diceBoard(currentNumber + dice, end, result + dice);
        }
    }

    public static void main(String[] args) {
        // diceBoardScratch(0, 0, 5, "");
        diceBoard(0, 5, "");
    }
}
