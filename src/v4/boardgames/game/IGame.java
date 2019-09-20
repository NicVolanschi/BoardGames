package v4.boardgames.game;

/**
 * Interface of a game.
 */
public interface IGame {
    
    /**
     * Updates the state of the game, according to an action.
     * 
     * @param state current state of the game
     * @param action action played
     */
    void updatePlay(GameState state, Action action);
}
