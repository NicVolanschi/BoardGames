package v8.boardgames.game;

import java.util.Optional;
import java.util.function.Predicate;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import v8.boardgames.player.IAPlayer;
import v8.boardgames.player.Player;

public class CoordTest {

    /**
     * Test of constructor Coord().
     */
    @Test
    public void testCoord() {
        Coord coord = new Coord(2, 3);
        assertNotNull(coord);
        assertEquals(2, coord.getLine());
        assertEquals(3, coord.getColumn());
    }

    /**
     * Test of method near() of class Coord.
     */
    @Test
    public void testNear() {
        {
            // corner 1
            final Coord coord = new Coord(0, 0);
            final Coord near1 = new Coord(0, 1);
            final Coord near2 = new Coord(1, 0);
            assertEquals(2, coord.near().count());
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near1)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near2)));
        }
        {
            // corner 2
            final Coord coord = new Coord(0, Board.NB_COL - 1);
            final Coord near1 = new Coord(0, Board.NB_COL - 2);
            final Coord near2 = new Coord(1, Board.NB_COL - 1);
            assertEquals(2, coord.near().count());
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near1)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near2)));
        }
        {
            // corner 3
            final Coord coord = new Coord(Board.NB_LIN - 1, 0);
            final Coord near1 = new Coord(Board.NB_LIN - 2, 0);
            final Coord near2 = new Coord(Board.NB_LIN - 1, 1);
            assertEquals(2, coord.near().count());
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near1)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near2)));
        }
        {
            // corner 4
            final Coord coord = new Coord(Board.NB_LIN - 1, Board.NB_COL - 1);
            final Coord near1 = new Coord(Board.NB_LIN - 2, Board.NB_COL - 1);
            final Coord near2 = new Coord(Board.NB_LIN - 1, Board.NB_COL - 2);
            assertEquals(2, coord.near().count());
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near1)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near2)));
        }
        {
            // middle
            final Coord coord = new Coord(1, 1);
            final Coord near1 = new Coord(0, 1);
            final Coord near2 = new Coord(1, 0);
            final Coord near3 = new Coord(2, 1);
            final Coord near4 = new Coord(1, 2);
            assertEquals(4, coord.near().count());
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near1)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near2)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near3)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near4)));
        }
        {
            // border
            final Coord coord = new Coord(1, Board.NB_COL - 1);
            final Coord near1 = new Coord(0, Board.NB_COL - 1);
            final Coord near2 = new Coord(1, Board.NB_COL - 2);
            final Coord near3 = new Coord(2, Board.NB_COL - 1);
            assertEquals(3, coord.near().count());
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near1)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near2)));
            assertTrue(coord.near().anyMatch(crd -> crd.equals(near3)));
        }
    }

    /**
     * Test of method near() of class Coord.
     */
    @Test
    public void testNextCoord() {
        final Board board = new Board();
        final Player player1 = new IAPlayer("Player 1");
        final Player player2 = new IAPlayer("Player 2");
        board.setContent(new Coord(3, 1), new Piece(player1));
        board.setContent(new Coord(1, 1), new Piece(player2));
        final Predicate<Piece> nonEmptyCell = p -> p != null;
        {
            Optional<Coord> coord = 
                    (new Coord(1, 1)).nextCoord(1, 0, nonEmptyCell, board);
            assertTrue(coord.isPresent());
            assertEquals(new Coord(3, 1), coord.get());
        }
        // TODO : to be continued...
    }
}
