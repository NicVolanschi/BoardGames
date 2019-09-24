package v5.boardgames.player;

import v5.boardgames.game.Action;
import v5.boardgames.game.GameState;

/**
 * Abstract class for a player.
 */
public abstract class Player {
    
    /**
     * Name of the player.
     */
    private final String name;
    
    /**
     * Internal code indicating that a player has not been found.
     */
    private final static int PLAYER_NOT_FOUND = -1;
    
    /**
     * Constructor
     * 
     * @param aName name of the player
     */
    public Player(String aName) {
        name = aName;
    }
    
    /**
     * Player chooses the action she wants to play.
     * 
     * @param g current state of the game
     * @return action the player wants to play
     */
    public abstract Action play(GameState g);
    
    public String getName() {
        return name;
    }

    /**
     * Character to be displayed on the board for the player.
     * By default, it's the first letter of her name.
     * 
     * @return character to be displayed on the board 
     */
    public char displayChar() {
        return name.charAt(0);
    }
    
    /**
     * Find a player from her displayed character
     * @param c the displayed character
     * @param players the set of players
     * @return the player with this character
     */
    public static Player fromChar(char c, Player[] players) {
        int i = indexFromChar(c, players);
        return i == PLAYER_NOT_FOUND ? null : players[i];
    }
    
    /**
     * Find a player's index from her displayed character
     * @param c the displayed character
     * @param players the set of players
     * @return the player with this character
     */
    public static int indexFromChar(char c, Player[] players) {
        for (int i = 0; i < players.length; i++) {
            if (c == players[i].displayChar()) {
                return i;
            }
        }
        return PLAYER_NOT_FOUND;
    }
    
    @Override
    public String toString() {
        return name;
    }
}
