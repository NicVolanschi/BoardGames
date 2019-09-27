package v6.boardgames.game;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

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
                assertEquals(Board.EMPTY_CELL, board.getContent(lin, col));
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
        board.setContent(2, 1, 'W');
        board.setContent(3, 0, 'B');
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
        assertEquals(Board.EMPTY_CELL, board.getContent(l,c));
        board.setContent(l, c, 'B');
        assertEquals('B', board.getContent(l,c));
    }
}
