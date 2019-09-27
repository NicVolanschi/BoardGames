package v8.boardgames.game;

import java.util.Map;
import java.util.Set;
import v8.boardgames.player.Player;

/**
 * Abstract class for a game.
 */
public abstract class Game implements IGame {
    
    /**
     * All players.
     */
    protected Player[] players;
    
    /**
     * Constructor.
     * 
     * @param nbPlayers number of players
     */
    public Game(int nbPlayers) {
        players = new Player[2];
    }

    /**
     * Returns the opponent, in a 2-players game.
     * 
     * @param p a player
     * @return her opponent
     */
    public Player opponent(Player p) {
        return p.getName().equals(players[0].getName()) ? players[1] : players[0];
    }

    @Override
    public GameState initialState() {
        return new GameState(new Board(), 0, this);
    }

    @Override
    public Player[] players() {
        return players;
    }

    @Override
    public Piece deserializePiece(char charPiece,
            Map<Player, Set<Piece>> amongPieces) {
        // default implementation, where the player has only one kind of pieces,
        // and uses its character to represent it.
        for (Player p : amongPieces.keySet()) {
            if (p.displayChar() == charPiece) {
                Set<Piece> available = amongPieces.get(p);
                if (available.isEmpty()) {
                    return null;
                } else {
                    return available.iterator().next();
                }
            }
        }
        return null;
    }
}
