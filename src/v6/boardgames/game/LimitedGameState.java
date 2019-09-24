package v6.boardgames.game;

/**
 * State of a limited game.
 */
public class LimitedGameState extends GameState {
    
    /**
     * Number of pieces per player.
     */
    private final int[] nbPieces;
    
    /**
     * Constructor.
     * 
     * @param aBoard board of the game
     * @param currentPlayer current player
     * @param aGame the game
     * @param pieces number of pieces per player
     */
    public LimitedGameState(Board aBoard, int currentPlayer, IGame aGame,
            int[] pieces) {
        super(aBoard, currentPlayer, aGame);
        nbPieces = pieces;
    }

    public int[] getNbPieces() {
        return nbPieces;
    }
    
    public void decreaseOnePiece(int numPlayer) {
        nbPieces[numPlayer]--;
    }
}
