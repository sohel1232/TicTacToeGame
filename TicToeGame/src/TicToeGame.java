import java.util.Scanner;
public class TicToeGame {


    static char [][] board = new char[3][3];  //Generating board.
    static char player = 'X'; //Initialising the first player to be X.


    public static void settingUp(){
        int k = 1;
        for(int row = 0 ; row<3 ; row++){
            for(int col = 0 ; col<3 ; col++ ){
                board[row][col] = (char)(k+'0');        //INITIALIZING BOARD TO 1 to 9
                k++;
            }
        }
    }


    public static void letsPlay(){
        Scanner sc = new Scanner(System.in);    //import to take inputs from user.

        //printing board.
        System.out.println();
        displayBoard();

        //checking if we already have a winner.
        if(hasWon()){
            System.out.println("Player "+ player + " has won.End of Game!");
            return;
        }else{

            System.out.println("Player " + player + " please place your token.");
            int position = sc.nextInt();
            char positionChar = (char)(position+'0');

            System.out.println();
            boolean found = false;
            for(int i = 0 ; i<3 ; i++){
                for(int j = 0 ; j<3 ; j++){
                    if(board[i][j]==positionChar){
                        found = true; // flag to mark valid entry of input.
                        board[i][j] = player;
                    }
                }
            }

            //if invalid move found.
            if(!found){
                System.out.println("invalid Move.Please trye again");
                letsPlay();
            }

            if(hasWon()){
                System.out.println("Game over");
                System.out.println("Player "+ player + " has won.End of Game!");
                displayBoard();
                return;
            }

            //toggling players after each turn.
            player = (player == 'X')? '0' : 'X';
            letsPlay();

        }

    }



    public static void displayBoard(){
        for(int row = 0 ; row<3 ; row++){
            for(int col = 0 ; col<3 ; col++){
                System.out.print(" " + board[row][col] + " |");
            }
            System.out.println();
        }
    }


    public static boolean hasWon(){
        //checking for row.
        for(int row = 0 ; row<3 ; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }

        //checking for cols.
        for(int col = 0 ; col<3 ; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }

        //checking for left to right diagonal.
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player )return true;

        //checking for right to left diagonal.
        if(board[0][2] == player && board[1][1] == player && board[2][0] == player )return true;

        return false;
    }

}



