package v8.boardgames.player;

import java.util.Random;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.GameState;
import v8.boardgames.action.IAction;
import v8.boardgames.game.Coord;

/**
 * A stupid IA player, purely random.
 */
public class IAPlayer extends Player {

    /**
     * Constructor.
     * 
     * @param aName player's name
     */
    public IAPlayer(String aName) {
        super(aName);
    }

    @Override
    public IAction play(GameState g) {
        // pick a random line an column
        final Random r = new Random();
        final int line = r.nextInt(Board.NB_LIN);
        final int col = r.nextInt(Board.NB_COL);
        return new Play(new Coord(line, col));
    }
}
