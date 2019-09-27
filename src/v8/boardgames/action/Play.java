package v8.boardgames.action;

import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;
import v8.boardgames.game.IGame;

/**
 * Action "Play". Immutable class.
 */
public class Play implements IAction {

    /**
     * Coordinates chosen by the player.
     */
    private final Coord coord;

    /**
     * Constructor.
     *
     * @param someCoord coordinates of the play
     */
    public Play(final Coord someCoord) {
        coord = someCoord;
    }

    public Coord getCoord() {
        return coord;
    }

    @Override
    public void perform(IGame game, GameState state) {
        game.updatePlay(state, this);
        System.out.println("## Board updated. ##");
    }

    @Override
    public String toString() {
        return coord.toString();
    }
}
