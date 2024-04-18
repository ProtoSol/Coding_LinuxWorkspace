public class ArrayQues {

    public static int[] getSecondOrderElements(int n, int[] arr) {
        int largest = arr[0];
        int second_largest = -1;
        int[] list = new int[2];

        // finding the largest number and second largest
        for(int i = 0; i < arr.length; i++){
            if(largest < arr[i]){
                second_largest = largest;
                largest = arr[i];
            }
        }
        list[0] = second_largest;

        // finding smallest and second smallest;
        int smallest = arr[0];
        int second_smallest = -1;
        for(int i = 0; i < arr.length; i++){
            if(smallest > arr[i]){
                second_smallest = smallest;
                smallest = arr[i];
            }
        }
        list[1] = second_smallest;

        return list;

    }
    public static void main(String[] args) {
        // max size of array is 10^6 and for global it is 10^7

        // we use index to acess the array
        // size (0 to size - 1)

        // We should never say the answer the directly
        // We should propose both bruteforce and optimized answers

        int[] arr = new int[5];


    }
}
