package v5.boardgames.player;

import java.util.Random;
import v5.boardgames.game.Action;
import v5.boardgames.game.ActionType;
import v5.boardgames.game.Board;
import v5.boardgames.game.GameState;

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
    public Action play(GameState g) {
        // always play
        final ActionType type = ActionType.PLAY;
        // pick a random line an column
        final Random r = new Random();
        final int line = r.nextInt(Board.NB_LIN);
        final int col = r.nextInt(Board.NB_COL);
        return new Action(type, line, col);
    }
}
