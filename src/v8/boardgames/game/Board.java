package v8.boardgames.game;

import java.util.Optional;
import java.util.function.Predicate;
import v8.boardgames.player.Player;

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
    private final Piece content[][];

    /**
     * Constructor.
     */
    public Board() {
        content = new Piece[NB_LIN][NB_COL];
        for (int lin = 0; lin < NB_LIN; lin++) {
            for (int col = 0; col < NB_COL; col++) {
                content[lin][col] = null;
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
                char disp = ' ';
                if (content[lin][col] != null) {
                    disp = content[lin][col].character();
                }
                sb.append(disp);
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
     * Returns the piece of a given cell.
     * 
     * @param coord coordinates of the cell
     * @return the piece at this cell, or null if it contains no piece
     */
    public Piece getContent(Coord coord) {
        return content[coord.getLine()][coord.getColumn()];
    }
    
    /**
     * Sets the content of a cell.
     * 
     * @param coord coordinates of the cell
     * @param piece the piece to be set at this cell
     */
    public void setContent(Coord coord, Piece piece) {
        content[coord.getLine()][coord.getColumn()] = piece;
    }
    
    /**
     * Checks whether some coordinates are inside the board.
     * 
     * @param coord coordinates to check
     * @return true iff the coordinates are inside the board
     */
    public static boolean inBoard(final Coord coord) {
        return coord.getLine() >= 0 
                && coord.getLine() < Board.NB_LIN
                && coord.getColumn() >= 0
                && coord.getColumn() < Board.NB_COL;
    }

    /**
     * Returns the next non-empty cell to the right of a cell, occupied by the
     * opponent
     * 
     * @param coord the source cell
     * @param player the current player
     * @return the next celle to the right of the source cell, occupied by the 
     * opponent
     */
    public Optional<Coord> nextRightCellOpponent(
            final Coord coord, final Player player) {
        final Predicate<Piece> rightCellOpp = 
                p -> p != null && !p.getPlayer().equals(player);
        return coord.nextCoord(0, 1, rightCellOpp, this);
    }
}
