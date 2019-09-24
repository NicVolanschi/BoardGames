package v6.boardgames.action;

import v6.boardgames.game.GameState;
import v6.boardgames.game.IGame;

/**
 * An action of a player.
 */
public interface IAction {

    /**
     * Perform the action.
     * 
     * @param game the game
     * @param state state of the game
     */
    public void perform(IGame game, GameState state);
}
