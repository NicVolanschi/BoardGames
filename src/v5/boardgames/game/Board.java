package v5.boardgames.game;

/**
 * Board of the Fill game.
 */
public class Board {

    /**
     * Number of lines of the board.
     */
    public static final int NB_LIN = 4;

    /**
     * Number of columns of the board.
     */
    public static final int NB_COL = 4;

    /**
     * Content of an empty cell.
     */
    public static final char EMPTY_CELL = ' ';

    /**
     * Content of the board.
     */
    private final char content[][];

    /**
     * Constructor.
     */
    public Board() {
        content = new char[NB_LIN][NB_COL];
        for (int lin = 0; lin < NB_LIN; lin++) {
            for (int col = 0; col < NB_COL; col++) {
                content[lin][col] = EMPTY_CELL;
            }
        }
    }

    /**
     * Display this board.
     *
     * @param separators indicates whether separators should be displayed
     * @return a String representing this board.
     */
    public String display(boolean separators) {
        final StringBuilder sb = new StringBuilder();
        // first line : name of columns
        sb.append("   ");
        for (int col = 0; col < NB_COL; col++) {
            sb.append((char) ('A' + col));
            sb.append(" ");
        }
        sb.append(System.lineSeparator());
        // following lines
        for (int lin = 0; lin < NB_LIN; lin++) {
            sb.append(separators ? separatorsLine() : "");
            sb.append((char) ('a' + lin));
            sb.append(" ");
            for (int col = 0; col < NB_COL; col++) {
                sb.append(separators ? "|" : " ");
                sb.append(content[lin][col]);
            }
            sb.append(separators ? "|" : "");
            sb.append(System.lineSeparator());
        }
        sb.append(separators ? separatorsLine() : "");
        return sb.toString();
    }

    /**
     * A horizontal line of separator characters.
     *
     * @return the line
     */
    private StringBuilder separatorsLine() {
        final StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int col = 0; col < NB_COL; col++) {
            sb.append("+-");
        }
        sb.append("+");
        sb.append(System.lineSeparator());
        return sb;
    }

    /**
     * Returns the char of a given cell.
     * @param line line of the cell
     * @param col column of the cell
     * @return the char at this cell
     */
    public char getContent(int line, int col) {
        return content[line][col];
    }
    
    /**
     * Sets the content of a cell.
     * 
     * @param line line of the cell
     * @param col column of the cell
     * @param contentChar the char to be set at this cell
     */
    public void setContent(int line, int col, char contentChar) {
        content[line][col] = contentChar;
    }
}
