/********************************************************************** 
 * Name: Collette Stapley
 **********************************************************************/

import java.util.Scanner;


public class App {
    public static Scanner user = new Scanner(System.in);
    public static Board b = new Board();

    /****************************************************************** 
     * checks for winning/tie conditions
     ******************************************************************/
    public static String GameOver(int turn)
    {
        String[] board = new String[9];
        board = b.GetBoard();

        String player;

        if ((turn % 2 ) == 0)
        {
            player = "X";
        }
        else if ((turn % 2) == 1)
        {
            player = "O";
        }
        else
        {
            System.out.println("Somethings wrong here?");
            player = "?";
        }

        for (int i = 0; i < 3; i++)
        {
            if (board[i] == player && board[i + 3] == player && board[i + 6] == player)
            {
                return player + " Wins! Thanks for Playing!";
            }
        }

        for (int i = 0; i < 9; i = i + 3)
        {
            if (board[i] == player && board[i + 1] == player && board[i + 2] == player)
            {
                return player + " Wins! Thanks for Playing!";
            }
        }

        if ((board[0] == player && board[4] == player && board[8] == player) ||
             board[2] == player && board[4] == player && board[6] == player)
             {
                return player + " Wins! Thanks for Playing!";
             }

        int count = 0;

        for (int i = 0; i < 9; i++)
        {
            if (board[i] != "X")
            {
                if (board[i] != "O")
                {
                    count++;
                }
            }
        }
        if (count == 0)
        {
            return "Cats Cradle, IT'S A TIE! Thanks for Playing!";
        }
        return "continue";
    }

    /****************************************************************** 
     * 
     ******************************************************************/
    public static int PlayerTurns(int turn)
    {
        Scanner user = new Scanner(System.in);
        String slot;
        if (turn % 2 != 0 || turn == 1)
        {
            System.out.print("X's turn to choose a square (1-9): ");
            slot = user.next();
            int spot = Integer.parseInt(slot);
            b.UpdateSpot(spot, "X");
            // "X";
        }
        else
        {
            System.out.print("O's turn to choose a square (1-9): ");
            slot = user.next();
            int spot = Integer.parseInt(slot);
            b.UpdateSpot(spot, "O");
            // "O";
        }
        turn++;
        return turn;
    }

    /****************************************************************** 
     * 
     ******************************************************************/
    public static void main(String[] args) throws Exception {

        b.DisplayBoard();
        String end = "continue";
        int turn = 1;

        while (end == "continue")
        {
            turn = PlayerTurns(turn);
            b.DisplayBoard();
            end = GameOver(turn);
        }
        System.out.println(end);
        // System.out.println("Good game. Thanks for playing!");
    }
}
