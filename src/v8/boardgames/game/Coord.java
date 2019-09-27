package v8.boardgames.game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Coordinates of a cell of the board. Immutable class.
 */
public class Coord {

    /**
     * Line.
     */
    private final int line;

    /**
     * Column.
     */
    private final int column;

    /**
     * Constructor
     *
     * @param aLine line of these coordinates
     * @param aColumn column of these coordinates
     */
    public Coord(final int aLine, final int aColumn) {
        line = aLine;
        column = aColumn;
    }

    /**
     * Stream of coordinates next to this one.
     *
     * @return coordinates next to this one.
     */
    public Stream<Coord> near() {
        List<Coord> near = new ArrayList<>();
        for (int delta : Arrays.asList(-1, 1)) {
            Coord nCoord1 = new Coord(line, column + delta);
            Coord nCoord2 = new Coord(line + delta, column);
            Stream.of(nCoord1, nCoord2)
                    .filter(c -> Board.inBoard(c))
                    .forEach(c -> near.add(c));
        }
        return near.stream();
    }

    /**
     * Computes the next coordinates in a given direction, satisfying a given
     * predicate.
     *
     * @param stepL number of lines during a move
     * @param stepC number of columns during a move
     * @param condition predicate to be verified by the resulting coordinates
     * @param board the board on which the predicate is tested
     * @return the first coordinates in the given direction satisfying the
     * predicate
     */
    public Optional<Coord> nextCoord(final int stepL, final int stepC,
            final Predicate<Piece> condition, final Board board) {
        if (stepL == 0 && stepC == 0) {
            throw new IllegalArgumentException("Direction must not be null.");
        }
        Coord c = this.plusVector(stepL, stepC);
        while (Board.inBoard(c) && !condition.test(board.getContent(c))) {
            c = c.plusVector(stepL, stepC);
        }
        return (Board.inBoard(c) ? Optional.of(c) : Optional.empty());
    }
    
    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public Coord plusVector(int stepL, int stepC) {
        return new Coord(line + stepL, column + stepC);
    }

    @Override
    public String toString() {
        return "(" + (char) ('a' + line) + "," + (char) ('A' + column) + ")";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.line;
        hash = 37 * hash + this.column;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Coord other = (Coord) obj;
        if (this.line != other.line) {
            return false;
        }
        if (this.column != other.column) {
            return false;
        }
        return true;
    }
}
