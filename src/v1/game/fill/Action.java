package v1.game.fill;

import java.util.Scanner;

/**
 * An action of a player, in the Fill game.
 */
class Action {

    /**
     * Line chosen by the player.
     */
    int line;

    /**
     * Column chosen by the player.
     */
    int column;

    /**
     * Player wants to quit.
     */
    boolean quit;

    /**
     * Scanner used to read the input from keyboard.
     */
    Scanner s;

    /**
     * Constructor.
     */
    Action() {
        s = new Scanner(System.in);
        quit = false;
    }

    /**
     * Ask the player for its next action, and record it.
     *
     * @param black is it the black player?
     */
    void getFromPlayer(boolean black, Board board) {
        System.out.println((black ? "Black" : "White") + " plays...");
        System.out.println("Your action : ");
        String action = s.next();
        fromKeyboard(action, board);
    }

    /**
     * Record an action from the player.
     *
     * @param action String obtained from the player
     */
    void fromKeyboard(String action, Board board) {
        if (action == null || action.isEmpty()) {
            // empty action -> quit
            quit = true;
            return;
        }
        char firstChar = action.charAt(0);
        if (firstChar == 'q' || firstChar == 'Q') {
            // action : quit
            quit = true;
            return;
        }
        // action : play
        char lineChar = firstChar;
        if ('a' <= lineChar && lineChar <= 'a' + board.NB_LIN - 1) {
            // line is valid
            if (action.length() == 1) {
                // no column -> quit
                System.out.println("No column: abort.");
                quit = true;
            } else {
                char colChar = action.charAt(1);
                if ('A' <= colChar && colChar <= 'A' + board.NB_COL - 1) {
                    // column is valid
                    line = lineChar - 'a';
                    column = colChar - 'A';
                } else {
                    // column is wrong
                    System.out.println("Wrong column: " + colChar);
                    quit = true;
                }
            }
        } else {
            // line is wrong
            System.out.println("Wrong line: " + lineChar);
            quit = true;
        }
    }
}
