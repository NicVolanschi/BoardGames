package v8.boardgames.game.near;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;

public class NearTest {
    
    /**
     * Test of updatePlay method, of class Near.
     * White looses as she plays on a cell occupied by Black.
     */
    @Test
    public void testUpdatePlay1() {
        // game
        final Near crush = new Near();
        // initial game state
        GameState state = crush.initialState();
        Board board = state.getBoard();
        // check it
        Coord coord1 = new Coord(0, 0);
        assertNull(board.getContent(coord1));
        // simulate some steps
        // step 1: Black plays
        crush.updatePlay(state, new Play(coord1));
        assertEquals('B', board.getContent(coord1).character());
        assertNull(board.getContent(new Coord(1, 0)));
        assertNull(board.getContent(new Coord(0, 1)));
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 = new Coord(2, 0);
        crush.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertNull(board.getContent(new Coord(1, 0)));
        assertNull(board.getContent(new Coord(0, 1)));
        assertFalse(state.isEnd());
        // step 3: Black plays
        Coord coord3 = new Coord(1, 0);
        crush.updatePlay(state, new Play(coord3));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('B', board.getContent(new Coord(0, 0)).character());
        assertEquals('B', board.getContent(new Coord(1, 1)).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        crush.updatePlay(state, new Play(new Coord(1, 1)));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }
}
