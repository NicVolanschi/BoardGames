package v8.boardgames.game.fill;

import org.junit.Test;
import static org.junit.Assert.*;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;

public class FillTest {
    
    /**
     * Test of updatePlay method, of class Fill.
     * White looses as she plays on a cell she occupies.
     */
    @Test
    public void testUpdatePlay1() {
        // game
        final Fill fill = new Fill();
        // initial game state
        GameState state = fill.initialState();
        Board board = state.getBoard();
        boolean end;
        // check it
        Coord coord1 = new Coord(0, 0);
        assertNull(board.getContent(coord1));
        // simulate some steps
        // step 1: Black plays
        fill.updatePlay(state, new Play(coord1));
        assertEquals('B', board.getContent(coord1).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 = new Coord(2, 0);
        fill.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        Coord coord3 = new Coord(0, 2);
        fill.updatePlay(state, new Play(coord3));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        fill.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }
    
    /**
     * Test of updatePlay method, of class Fill.
     * Black looses as she plays on a cell that White occupies.
     */
    @Test
    public void testUpdatePlay2() {
        // game
        final Fill fill = new Fill();
        // initial game state
        GameState state = fill.initialState();
        Board board = state.getBoard();
        // check it
        Coord coord1 = new Coord(0, 0);
        assertNull(board.getContent(coord1));
        // simulate some steps
        // step 1: Black plays
        fill.updatePlay(state, new Play(coord1));
        assertEquals('B', board.getContent(coord1).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 = new Coord(2, 0);
        fill.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        Coord coord3 = new Coord(0, 2);
        fill.updatePlay(state, new Play(coord3));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        Coord coord4 = new Coord(1, 0);
        fill.updatePlay(state, new Play(coord4));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertFalse(state.isEnd());
        // step 5: Black plays
        fill.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertTrue(state.isEnd());
        assertEquals('W', state.getWinner().displayChar());
    }    
}
