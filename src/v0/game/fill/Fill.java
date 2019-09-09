package v0.game.fill;

import java.util.Scanner;

/**
 * A 2-player game where each one wants to fill the board.
 */
class Fill {

    public static void main(String[] args) {
        char[][] board = new char[4][4];
        for (int line = 0; line < 4; line++) {
            for (int col = 0; col < 4; col++) {
                board[line][col] = ' ';
            }
        }
        boolean end = false;
        boolean black = true;
        Scanner s = new Scanner(System.in);
        String action;
        while (!end) {
            for (int line = 0; line < 4; line++) {
                for (int col = 0; col < 4; col++) {
                    System.out.print(board[line][col]);
                }
                System.out.println();
            }
            System.out.println((black ? "Black" : "White") + " plays...");
            System.out.println("Your action: ");
            action = s.next();
            char lineChar = action.charAt(0);
            char colChar = action.charAt(1);
            int line = lineChar - 'a';
            int col = colChar - 'A';
            if (board[line][col] != ' ') {
                System.out.println("This cell is occupied: " + 
                        (black?"White":"Black") + " wins!");
                end = true;
            } else {
                board[line][col] = (black ? 'B' : 'W');
                black = !black;
            }
        }
    }
}
