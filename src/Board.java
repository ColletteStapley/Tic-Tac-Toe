/**********************************************************************
 * 
**********************************************************************/

import java.io.File;
import java.io.FileWriter;   // Import the FileWriter class

import java.io.IOException;  // Import the IOException class to handle errors

/**********************************************************************
 * 
 *********************************************************************/
public class Board {
    String[] board = new String[9];
    public Board () {
        for (int row = 0; row < 9; row++) {
            board[row] = String.valueOf(row + 1);
        }
        
    }

    /**********************************************************************
     * 
     **********************************************************************/
    public String[] GetBoard() {
        return board;
    }

    /**********************************************************************
     * 
     **********************************************************************/
    public void DisplayBoard() {
        System.out.print(board[0]);
        for (int i = 1; i <= 8; i++) {
            if (i == 3 || i == 6) {
                System.out.print("\n");
                System.out.println("-+-+-");
                System.out.print(board[i]);
            } else {
                System.out.print(board[i]);
            }
        }
        System.out.print("\n");
    }

    /**********************************************************************
     * 
     **********************************************************************/
    public void UpdateSpot(String spot, String ticTac) {
        
    }
    
    /**********************************************************************
     * 
     **********************************************************************/
    public void SaveBoard(String fileName) {
        try {
            FileWriter writeFile = new FileWriter(fileName + ".txt");
            for (int i = 0; i < 9; i++) {
                    writeFile.write(board[i]);
            }
            writeFile.close();

        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    /**********************************************************************
     * 
     **********************************************************************/
    public void CreateFile(String fileName) {
        try {
            File file = new File(fileName + ".txt");
            if (file.createNewFile()) {
                System.out.println("File Created: " + fileName);
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }

    /**********************************************************************
     * 
     **********************************************************************/
    public void OpenFile(String fileName) {
        String file = fileName + ".txt";
        try {
            FileWriter writer = new FileWriter(file); 
            writer.write(board);
            writer.flush();
            writer.close();
        } catch (IOException e) {
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }
}
