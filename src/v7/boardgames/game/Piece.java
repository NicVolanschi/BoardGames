package v7.boardgames.game;

import v7.boardgames.player.Player;

/**
 * A piece of a game.
 */
public class Piece {
    
    /**
     * The player owning this piece.
     */
    private final Player player;
    
    /**
     * Constructor.
     * 
     * @param aPlayer player owning this piece 
     */
    public Piece (final Player aPlayer) {
        this.player = aPlayer;
    }

    public Player getPlayer() {
        return player;
    }
    
    /**
     * The character representing this piece on the board (and in saved file).
     * 
     * @return character for this piece
     */
    public char character() {
        return player.displayChar();
    }
}
