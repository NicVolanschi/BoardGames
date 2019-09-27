package v7.boardgames.game;

import java.util.Map;
import java.util.Set;
import v7.boardgames.action.Play;
import v7.boardgames.player.Player;

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
     * Initial set of pieces of each player, at the beginning of the game.
     *
     * @param p player
     * @return initial set of pieces
     */
    public Set<Piece> initPieces(Player p);
    
    /**
     * Updates the state of the game, according to an action.
     * 
     * @param state current state of the game
     * @param action action played
     */
    public void updatePlay(GameState state, Play action);
    
    /**
     * Find a piece corresponding to a character used by the "Save" action.
     * @param charPiece character representing the piece
     * @param amongPieces available pieces, for each player
     * @return a matching piece (or null, if there is no)
     */
    public Piece deserializePiece(char charPiece, 
            Map<Player,Set<Piece>> amongPieces);
}
