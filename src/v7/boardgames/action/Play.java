package v7.boardgames.action;

import v7.boardgames.game.GameState;
import v7.boardgames.game.IGame;

/**
 * Action "Play".
 */
public class Play implements IAction {

    /**
     * Line chosen by the player.
     */
    private final int line;

    /**
     * Column chosen by the player.
     */
    private final int column;

    /**
     * Constructor.
     *
     * @param aLine line (if Play)
     * @param aColumn column (if Play)
     */
    public Play(int aLine, int aColumn) {
        line = aLine;
        column = aColumn;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    @Override
    public void perform(IGame game, GameState state) {
        game.updatePlay(state, this);
        System.out.println("## Board updated. ##");
    }

    @Override
    public String toString() {
        return "(" + (char)('a' + line) + "," + (char)('A' + column) + ")";
    }
}
