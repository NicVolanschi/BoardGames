package v3.game.fill;

import java.util.Scanner;

/**
 * An action of a player, in the Fill game. Immutable class.
 */
class Action {

    /**
     * Type of action.
     */
    final ActionType type;

    /**
     * Line chosen by the player.
     */
    final int line;

    /**
     * Column chosen by the player.
     */
    final int column;

    /**
     * Scanner used to read the input from keyboard.
     */
    static final Scanner SCAN = new Scanner(System.in);

    /**
     * Constructor.
     * 
     * @param aType type of action
     * @param aLine line (if Play)
     * @param aColumn column (if Play)
     */
    Action(ActionType aType, int aLine, int aColumn) {
        type = aType;
        line = aLine;
        column = aColumn;
    }

    /**
     * Ask the player for its next action, and record it.
     *
     * @param black is it the black player?
     */
    static Action getFromPlayer(boolean black) {
        System.out.println((black ? "Black" : "White") + " plays...");
        System.out.println("Your action : ");
        final String action = SCAN.next();
        return fromKeyboard(action);
    }

    /**
     * Returns the "Quit" action.
     *
     * @return the "Quit" action
     */
    static Action actionQuit() {
        return new Action(ActionType.QUIT, -1, -1);
    }

    /**
     * Returns the "Save" action.
     *
     * @return the "Save" action
     */
    static Action actionSave() {
        return new Action(ActionType.SAVE, -1, -1);
    }

    /**
     * Returns the "Load" action.
     *
     * @return the "Load" action
     */
    static Action actionLoad() {
        return new Action(ActionType.LOAD, -1, -1);
    }

    /**
     * Record an action from the player.
     *
     * @param action String obtained from the player
     */
    static Action fromKeyboard(String action) {
        int actionLine, actionColumn;
        if (action == null || action.isEmpty()) {
            // empty action -> quit
            return actionQuit();
        }
        final char firstChar = action.charAt(0);
        switch (firstChar) {
            case 'q':
            case 'Q':
                return actionQuit();
            case 's':
            case 'S':
                return actionSave();
            case 'l':
            case 'L':
                return actionLoad();
            default:
                break;
        }
        // action : play
        char lineChar = firstChar;
        if ('a' <= lineChar && lineChar <= 'a' + Board.NB_LIN - 1) {
            // line is valid
            if (action.length() == 1) {
                // no column -> quit
                System.out.println("No column: abort.");
                return actionQuit();
            }
            char colChar = action.charAt(1);
            if ('A' <= colChar && colChar <= 'A' + Board.NB_COL - 1) {
                // column is valid
                actionLine = lineChar - 'a';
                actionColumn = colChar - 'A';
            } else {
                // column is wrong
                System.out.println("Wrong column: " + colChar);
                return actionQuit();
            }
        } else {
            // line is wrong
            System.out.println("Wrong line: " + lineChar);
            return actionQuit();
        }
        return new Action(ActionType.PLAY, actionLine, actionColumn);
    }
}
