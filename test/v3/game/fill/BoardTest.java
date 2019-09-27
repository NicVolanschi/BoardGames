package v3.game.fill;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

public class BoardTest {

    /**
     * Test Board constructor.
     */
    @Test
    public void testBoard() {
        Board board = new Board();
        // content has been initialized:
        assertNotNull(board.content);
        // content has the right size:
        assertEquals(Board.NB_LIN, board.content.length);
        assertEquals(Board.NB_COL, board.content[0].length);
        // content contains only empty cells:
        for (int lin = 0; lin < Board.NB_LIN; lin++) {
            for (int col = 0; col < Board.NB_COL; col++) {
                assertEquals(Board.EMPTY_CELL, board.content[lin][col]);
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
        board.content[2][1] = 'W';
        board.content[3][0] = 'B';
        String boardDisp
                = "   A B C D \n"
                + "a         \n"
                + "b         \n"
                + "c    W    \n"
                + "d  B      \n";
        assertEquals(boardDisp, board.display(false));
    }
}
