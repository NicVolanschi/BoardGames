package v4.boardgames.game;

/**
 * All types of actions.
 */
public enum ActionType {
    /**
     * Put a piece on a cell.
     */
    PLAY, 
    
    /**
     * Quit game.
     */
    QUIT,
    
    /**
     * Save game.
     */
    SAVE,
    
    /**
     * Load game.
     */
    LOAD;
}
