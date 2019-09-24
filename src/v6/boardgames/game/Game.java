package v6.boardgames.game;

import v6.boardgames.player.Player;

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
}
