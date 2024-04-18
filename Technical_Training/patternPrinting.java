package Technical_Training;

class patternPrinting {
    public static void main(String[] args) {
        int range = 5;

        // for(int i = 1; i <= range; i++){
        //     for(int j = 1; j <= range; j++){
        //         if(i == 1 || i == range || j == 1 || j == range || i == j || i == range-j+1){
        //             System.out.print("*");
        //         }else{
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println("");
        // }

        // for(int row = 1; row <= range; row++){
        //     for(int space = 0; space <= range - row; space ++){
        //         System.out.print(" ");
        //     }
        //     for(int col = 1; col <= row; col ++){
        //         System.out.print("*");
        //     }
        //     System.out.println("");
        // }

        // for(int row = 1; row <= range; row++){
        //     for(int space = 0; space <= range - row; space ++){
        //         System.out.print(" ");
        //     }
        //     for(int col = 1; col <= row; col ++){
        //         System.out.print("* ");
        //     }
        //     System.out.println("");
        // }

        for(int row = 0; row < range; row++){
            for(int space = 0; space <= range - row; space ++){
                System.out.print(" ");
            }
            for(int col = 1; col <= (2*row+1); col ++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
