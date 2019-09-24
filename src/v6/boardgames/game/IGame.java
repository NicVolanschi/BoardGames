package v6.boardgames.game;

import v6.boardgames.action.Play;
import v6.boardgames.player.Player;

/**
 * Interface of a game.
 */
public interface IGame {
    
    /**
     * Initial state of the game.
     * 
     * @return the initial state of the game
     */
    public GameState initialState();

    /**
     * Players of the game, in the order of their turn.
     * 
     * @return players of the game
     */
    public Player[] players();
    
    /**
     * Updates the state of the game, according to an action.
     * 
     * @param state current state of the game
     * @param action action played
     */
    public void updatePlay(GameState state, Play action);
}
