import java.util.*;

public class game{
    static char[][] board = {{' ',' ',' '},{' ',' ',' '},{' ',' ',' '}};
    static char[] players = {'X','O'};
    static Random random = new Random();
    static int index = random.nextInt(1-0)+1;
    static char player = players[index];
    // printing tic tac toe board
    static void print_board(){
        int i,j;
        System.out.println("-------------");
        for(i=0;i<3;i++){
            System.out.print("| ");
            for(j=0;j<3;j++){
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    // checking if the board is filled or not
    static Boolean is_board_filled(){
        for (int i=0;i<board.length;){
                if(board[i][0]==' ' || board[i][1]==' ' || board[i][2]==' ' || board[0][i]==' ' || board[1][i]==' ' || board[2][i]==' '){
                    return false;
                }
                return true;
                
        }
        return null;
    }
    // swapping the players so the players play one after the other.
    static void swap_player(){
        if (player == 'X'){
            player = 'O';
        }
        else{
            player = 'X';
        }
    }
    // conditions on which the winner is decided
    static Boolean game_win(){
        // checking horizontally and vertically.
        for (int i=0;i<3;i++){
                if((board[i][0] == player && board[i][1] == player && board[i][2] == player)||(board[0][i] == player && board[1][i] == player && board[2][i] == player)){
                    return true;
                }
        }
        // checking diagonally
        if ((board[0][2] == player && board[1][1] == player && board[2][0] == player)||(board[0][0] == player && board[1][1] == player && board[2][2] == player)){
            return true;
        }
        return false;
    }


    public static void main(String[] args){
        System.out.println("Welcome to Tic Tac Toe game!!");
        print_board();
        boolean checkwinner = false;
        Scanner obj1 = new Scanner(System.in);
        // obj1.close();

        while (!checkwinner){
            System.out.println(checkwinner);
            System.out.println(player+"'s turn");
            System.out.println("Enter the row: ");
            int row = obj1.nextInt()-1;
            System.out.println("Enter the column: ");
            int column = obj1.nextInt()-1;
            if (board[row][column] == ' '){
                board[row][column] = player;
                print_board();
                checkwinner = game_win();
                if(!checkwinner){
                    swap_player();
                }
            }
            else{
                System.out.println("Invalid input.");
            }

            if(checkwinner == true){
                System.out.println("Player "+player+" is the winner.");
                break;
            }
            

            if (is_board_filled()){
                System.out.println("The game is draw.");
                break;
            }

        }
    }
}