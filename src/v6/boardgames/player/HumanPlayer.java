package v6.boardgames.player;

import java.util.Scanner;
import v6.boardgames.action.Load;
import v6.boardgames.action.Play;
import v6.boardgames.action.Quit;
import v6.boardgames.action.Save;
import v6.boardgames.game.Board;
import v6.boardgames.game.GameState;
import v6.boardgames.action.IAction;

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
    public IAction play(GameState state) {
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
    private static IAction fromKeyboard(String action) {
        int actionLine, actionColumn;
        if (action == null || action.isEmpty()) {
            // empty action -> quit
            return new Quit();
        }
        final char firstChar = action.charAt(0);
        switch (firstChar) {
            case 'q':
            case 'Q':
                return new Quit();
            case 's':
            case 'S':
                return new Save();
            case 'l':
            case 'L':
                return new Load();
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
                return new Quit();
            }
            char colChar = action.charAt(1);
            if ('A' <= colChar && colChar <= 'A' + Board.NB_COL - 1) {
                // column is valid
                actionLine = lineChar - 'a';
                actionColumn = colChar - 'A';
            } else {
                // column is wrong
                System.out.println("Wrong column: " + colChar);
                return new Quit();
            }
        } else {
            // line is wrong
            System.out.println("Wrong line: " + lineChar);
            return new Quit();
        }
        return new Play(actionLine, actionColumn);
    }

}
