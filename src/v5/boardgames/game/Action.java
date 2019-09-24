package v5.boardgames.game;

/**
 * An action of a player. Immutable class.
 */
public class Action {

    /**
     * Type of action.
     */
    private final ActionType type;

    /**
     * Line chosen by the player.
     */
    private final int line;

    /**
     * Column chosen by the player.
     */
    private final int column;

    /**
     * Constructor.
     *
     * @param aType type of action
     * @param aLine line (if Play)
     * @param aColumn column (if Play)
     */
    public Action(ActionType aType, int aLine, int aColumn) {
        type = aType;
        line = aLine;
        column = aColumn;
    }

    /**
     * Returns the "Quit" action.
     *
     * @return the "Quit" action
     */
    public static Action actionQuit() {
        return new Action(ActionType.QUIT, -1, -1);
    }

    /**
     * Returns the "Save" action.
     *
     * @return the "Save" action
     */
    public static Action actionSave() {
        return new Action(ActionType.SAVE, -1, -1);
    }

    /**
     * Returns the "Load" action.
     *
     * @return the "Load" action
     */
    public static Action actionLoad() {
        return new Action(ActionType.LOAD, -1, -1);
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public ActionType getType() {
        return type;
    }

    @Override
    public String toString() {
        switch (type) {
            case LOAD:
                return "Load";
            case PLAY:
                return "(" + (char) ('a' + line) + "," + (char) ('A' + column) + ")";
            case SAVE:
                return "Save";
            case QUIT:
                return "Quit";
        }
        return "";
    }
}
