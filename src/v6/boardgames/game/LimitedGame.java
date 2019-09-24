package v6.boardgames.game;

/**
 * A game with a limited number of pieces.
 */
public abstract class LimitedGame extends Game {
    
    /**
     * Initial number of pieces per player.
     */
    private final int initNbPieces;

    /**
     * Constructor.
     * 
     * @param nbPlayers number of players
     * @param nbPieces number of pieces per player, at the beginning
     */
    public LimitedGame(int nbPlayers, int nbPieces) {
        super(nbPlayers);
        initNbPieces = nbPieces;
    }

    @Override
    public GameState initialState() {
        final int nbPlayers = players.length;
        int[] pieces = new int[nbPlayers];
        for (int i = 0; i < nbPlayers; i++) {
            pieces[i] = initNbPieces;
        }
        return new LimitedGameState(new Board(), 0, this, pieces);
    }
}
