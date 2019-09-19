package v2.game.fill;

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
        assertEquals(board.NB_LIN, board.content.length);
        assertEquals(board.NB_COL, board.content[0].length);
        // content contains only empty cells:
        for (int lin = 0; lin < board.NB_LIN; lin++) {
            for (int col = 0; col < board.NB_COL; col++) {
                assertEquals(board.EMPTY_CELL, board.content[lin][col]);
            }
        }
    }

    @Test
    public void testConstants() {
        Board board = new Board();
        assertEquals(4, board.NB_LIN);
        assertEquals(4, board.NB_COL);
        assertEquals(' ', board.EMPTY_CELL);
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
