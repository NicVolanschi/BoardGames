package v5.boardgames.player;

import java.util.Scanner;
import v5.boardgames.game.Action;
import v5.boardgames.game.ActionType;
import v5.boardgames.game.Board;
import v5.boardgames.game.GameState;

/**
 * A human player.
 */
public class HumanPlayer extends Player {

    /**
     * Scanner used to read the input from keyboard.
     */
    private static final Scanner SCAN = new Scanner(System.in);

    /**
     * Constructor
     * @param aName player's name 
     */
    public HumanPlayer(String aName) {
        super(aName);
    }

    @Override
    public Action play(GameState state) {
        System.out.println(state.getCurrentPlayer().getName() + " plays...");
        System.out.println("Your action : ");
        final String action = SCAN.next();
        return fromKeyboard(action);
    }
    
    /**
     * Record an action from the player.
     *
     * @param action String obtained from the player
     * @return action chosen by the player
     */
    private static Action fromKeyboard(String action) {
        int actionLine, actionColumn;
        if (action == null || action.isEmpty()) {
            // empty action -> quit
            return Action.actionQuit();
        }
        final char firstChar = action.charAt(0);
        switch (firstChar) {
            case 'q':
            case 'Q':
                return Action.actionQuit();
            case 's':
            case 'S':
                return Action.actionSave();
            case 'l':
            case 'L':
                return Action.actionLoad();
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
                return Action.actionQuit();
            }
            char colChar = action.charAt(1);
            if ('A' <= colChar && colChar <= 'A' + Board.NB_COL - 1) {
                // column is valid
                actionLine = lineChar - 'a';
                actionColumn = colChar - 'A';
            } else {
                // column is wrong
                System.out.println("Wrong column: " + colChar);
                return Action.actionQuit();
            }
        } else {
            // line is wrong
            System.out.println("Wrong line: " + lineChar);
            return Action.actionQuit();
        }
        return new Action(ActionType.PLAY, actionLine, actionColumn);
    }

}
