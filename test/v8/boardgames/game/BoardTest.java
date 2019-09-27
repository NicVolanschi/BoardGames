package v8.boardgames.game;

import java.util.Optional;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import v8.boardgames.player.IAPlayer;
import v8.boardgames.player.Player;

public class BoardTest {

    /**
     * Test Board constructor.
     */
    @Test
    public void testBoard() {
        Board board = new Board();
        // content contains only empty cells:
        for (int lin = 0; lin < Board.NB_LIN; lin++) {
            for (int col = 0; col < Board.NB_COL; col++) {
                assertNull(board.getContent(new Coord(lin, col)));
            }
        }
    }

    @Test
    public void testConstants() {
        assertEquals(4, Board.NB_LIN);
        assertEquals(4, Board.NB_COL);
        assertEquals(' ', Board.EMPTY_CELL);
    }

    @Test
    public void testDisplayEmptyBoardNoSep() {
        String emptyBoardNoSep
                = "   A B C D \n"
                + "a         \n"
                + "b         \n"
                + "c         \n"
                + "d         \n";
        Board board = new Board();
        assertEquals(emptyBoardNoSep, board.display(false));
    }

    @Test
    public void testDisplayEmptyBoardSep() {
        String emptyBoardSep
                = "   A B C D \n"
                + "  +-+-+-+-+\n"
                + "a | | | | |\n"
                + "  +-+-+-+-+\n"
                + "b | | | | |\n"
                + "  +-+-+-+-+\n"
                + "c | | | | |\n"
                + "  +-+-+-+-+\n"
                + "d | | | | |\n"
                + "  +-+-+-+-+\n";
        Board board = new Board();
        assertEquals(emptyBoardSep, board.display(true));
    }

    @Test
    public void testDisplayNonEmptyBoard() {
        Board board = new Board();
        Player black = new IAPlayer("Black");
        Player white = new IAPlayer("White");
        board.setContent(new Coord(2, 1), new Piece(white));
        board.setContent(new Coord(3, 0), new Piece(black));
        String boardDisp
                = "   A B C D \n"
                + "a         \n"
                + "b         \n"
                + "c    W    \n"
                + "d  B      \n";
        assertEquals(boardDisp, board.display(false));
    }

    /**
     * Test of getContent and setContent methods, of class Board.
     */
    @Test
    public void testGetSetContent() {
        Board board = new Board();
        int l = 2;
        int c = 1;
        Coord coord = new Coord(l, c);
        assertNull(board.getContent(coord));
        Player player = new IAPlayer("my name");
        Piece p = new Piece(player);
        board.setContent(coord, p);
        assertEquals(p, board.getContent(coord));
    }

    /**
     * Test of inBoard method, of class Board.
     */
    @Test
    public void testInBoard() {
        assertTrue(Board.inBoard(new Coord(0, 0)));
        assertTrue(Board.inBoard(new Coord(0, Board.NB_COL - 1)));
        assertTrue(Board.inBoard(new Coord(Board.NB_LIN - 1, 0)));
        assertTrue(Board.inBoard(new Coord(Board.NB_LIN - 1, Board.NB_COL - 1)));
        assertFalse(Board.inBoard(new Coord(-1, 0)));
        assertFalse(Board.inBoard(new Coord(0, Board.NB_COL)));
        assertFalse(Board.inBoard(new Coord(-1, Board.NB_COL)));
        assertFalse(Board.inBoard(new Coord(0, -1)));
        assertFalse(Board.inBoard(new Coord(Board.NB_LIN, 0)));
        assertFalse(Board.inBoard(new Coord(Board.NB_LIN, -1)));
    }

    @Test
    public void testNextRightCellOpponent() {
        Board board = new Board();
        Player player1 = new IAPlayer("Player 1");
        Player player2 = new IAPlayer("Player 2");
        board.setContent(new Coord(2, 3), new Piece(player1));
        board.setContent(new Coord(2, 2), new Piece(player2));
        board.setContent(new Coord(2, 0), new Piece(player2));
        Optional<Coord> rightCoord ;
        {
            rightCoord = board.nextRightCellOpponent(new Coord(2, 0), player2);
            assertTrue(rightCoord.isPresent());
            assertEquals(new Coord(2, 3), rightCoord.get());
        }
        {
            rightCoord = board.nextRightCellOpponent(new Coord(2, 0), player1);
            assertTrue(rightCoord.isPresent());
            assertEquals(new Coord(2, 2), rightCoord.get());
        }
        {
            rightCoord = board.nextRightCellOpponent(new Coord(2, 2), player2);
            assertTrue(rightCoord.isPresent());
            assertEquals(new Coord(2, 3), rightCoord.get());
        }
        {
            rightCoord = board.nextRightCellOpponent(new Coord(2, 2), player1);
            assertFalse(rightCoord.isPresent());
        }
        {
            rightCoord = board.nextRightCellOpponent(new Coord(2, 3), player2);
            assertFalse(rightCoord.isPresent());
        }
    }
}
