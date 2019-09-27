package v7.boardgames.game;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import v7.boardgames.player.Player;

/**
 * State of the game, fully described.
 */
public class GameState {

    /**
     * Current board of the game.
     */
    private Board board;

    /**
     * Current player's index.
     */
    private int current;
    
    /**
     * The game.
     */
    private final IGame game;
    
    /**
     * End of the game?
     */
    private boolean end;

    /**
     * The winner, once the game ended.
     * null for a draw, or during the game.
     */
    private Player winner;
    
    /**
     * Available pieces for each player.
     */
    private final Map<Player, Set<Piece>> pieces;

    /**
     * Constructor.
     *
     * @param aBoard current board
     * @param currentPlayer current player's index
     * @param aGame the game
     */
    public GameState(final Board aBoard, final int currentPlayer, 
            final IGame aGame) {
        board = aBoard;
        current = currentPlayer;
        game = aGame;
        end = false;
        pieces = new HashMap<>();
        for (Player p : game.players()) {
            pieces.put(p, game.initPieces(p));
        }
        winner = null;
    }

    public Board getBoard() {
        return board;
    }

    public int getCurrentPlayerIndex() {
        return current;
    }
    
    public Player getCurrentPlayer() {
        return game.players()[current];
    }

    public void setCurrentPlayer(int p) {
        current = p;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public void setBoard(Board aBoard) {
        board = aBoard;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player theWinner) {
        this.winner = theWinner;
    }
    
    /**
     * Set of available pieces of a player.
     * 
     * @param p the player
     * @return her set of available pieces
     */
    public Set<Piece> piecesOfPlayer(Player p) {
        return pieces.get(p);
    }
    
    /**
     * Look for a piece of a player, returns it, and remove it from the set of
     * available pieces.
     * 
     * @param player a player
     * @return an available piece of this player
     */
    public Piece takeAPiece(Player player) {
        Set<Piece> availablePieces = piecesOfPlayer(player);
        if (availablePieces.isEmpty()) {
            return null;
        }
        Piece piece = availablePieces.iterator().next();
        availablePieces.remove(piece);
        return piece;
    }
}
