package v6.boardgames.game;

import v6.boardgames.player.Player;

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
}
