/********************************************************************** 
 * Name: 
 **********************************************************************/

import java.util.Scanner;


public class App {

    /****************************************************************** 
     * 
     ******************************************************************/
    public static boolean GameOver(char[] board, int turn)
    {
        char player;

        if ((turn % 2 ) == 0)
        {
            player = 'X';
        }
        else if ((turn % 2) == 1)
        {
            player = 'O';
        }
        else
        {
            System.out.println("Somethings wrong here?");
            player = '?';
        }

        for (int i = 0; i < 3; i++)
        {
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player)
            {
                return true;
            }
        }

        for (int i = 0; i < 9; i = i + 3)
        {
            if (board[i] == player && board[i + 1] == player && board[i + 2] == player)
            {
                return true;
            }
        }

        if ((board[0] == player && board[4] == player && board[8] == player) ||
             board[2] == player && board[4] == player && board[6] == player)
             {
                 return true;
             }

        int count = 0;

        for (int i = 0; i < 9; i++)
        {
            if (board[i] != 'X')
            {
                if (board[i] != '0')
                {
                    count++;
                }
            }
        }
        if (count == 0)
        {
            return true;
        }
        return false;
    }

    /****************************************************************** 
     * 
     ******************************************************************/
    public static int PlayerTurns(char[] board, int turn)
    {
        Scanner user = new Scanner(System.in);
        String slot;
        if (turn % 2 != 0 || turn == 1)
        {
            System.out.print("X's turn to choose a square (1-9): ");
            slot = user.next();
            // "X";
        }
        else
        {
            System.out.print("O's turn to choose a square (1-9): ");
            slot = user.next();
            // "O";
        }
        turn++;
        return turn;
    }

    /****************************************************************** 
     * 
     ******************************************************************/
    public static void main(String[] args) throws Exception {

        Board b = new Board();

        b.DisplayBoard();
        char[] board = new char[9];
        board = b.GetBoard();
        boolean end = false;
        int turn = 1;

        while (!end)
        {
            turn = PlayerTurns(board, turn);
            b.DisplayBoard();
            end = GameOver(board, turn);
        }
        System.out.println("Good game. Thanks for playing!");
    }
}
