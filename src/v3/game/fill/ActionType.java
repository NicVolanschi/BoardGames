package v3.game.fill;

/**
 * All types of actions.
 */
enum ActionType {
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
