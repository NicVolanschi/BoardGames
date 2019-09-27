package v7.boardgames.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import org.junit.Test;
import v7.boardgames.player.IAPlayer;
import v7.boardgames.player.Player;

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
                assertNull(board.getContent(lin, col));
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
        board.setContent(2, 1, new Piece(white));
        board.setContent(3, 0, new Piece(black));
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
        assertNull(board.getContent(l,c));
        Player player = new IAPlayer("my name");
        Piece p = new Piece(player);
        board.setContent(l, c, p);
        assertEquals(p, board.getContent(l,c));
    }
}
