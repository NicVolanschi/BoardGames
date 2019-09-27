package v8.boardgames.game.crush3;

import org.junit.Test;
import static org.junit.Assert.*;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.Coord;
import v8.boardgames.game.GameState;

public class Crush3Test {
    
    /**
     * Test of updatePlay method, of class Crush3.
     * White looses as she plays on a cell she occupies.
     */
    @Test
    public void testUpdatePlay1() {
        // game
        final Crush3 crush3 = new Crush3();
        // initial game state
        GameState state = crush3.initialState();
        Board board = state.getBoard();
        // check it
        Coord coord1 = new Coord(0, 0);
        assertNull(board.getContent(coord1));
        // simulate some steps
        // step 1: Black plays
        crush3.updatePlay(state, new Play(coord1));
        assertEquals('B', board.getContent(coord1).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 =new Coord(2, 0);
        crush3.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        Coord coord3 = new Coord(0, 2);
        crush3.updatePlay(state, new Play(coord3));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        crush3.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }
    
    /**
     * Test of updatePlay method, of class Crush3.
     * Draw, when both players put all their pieces.
     */
    @Test
    public void testUpdatePlay3() {
        // game
        final Crush3 crush = new Crush3();
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
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 =new Coord(2, 0);
        crush.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        Coord coord3 = new Coord(0, 2);
        crush.updatePlay(state, new Play(coord3));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        Coord coord4 = new Coord(1, 0);
        crush.updatePlay(state, new Play(coord4));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertFalse(state.isEnd());
        // step 5: Black plays
        Coord coord5 = new Coord(2, 3);
        crush.updatePlay(state, new Play(coord5));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertEquals('B', board.getContent(coord5).character());
        assertFalse(state.isEnd());
        // step 6: White plays
        Coord coord6 = new Coord(3, 3);
        crush.updatePlay(state, new Play(coord6));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertEquals('B', board.getContent(coord5).character());
        assertEquals('W', board.getContent(coord6).character());
        assertTrue(state.isEnd());
        assertNull(state.getWinner());
    }    

    
    /**
     * Test of updatePlay method, of class Crush3.
     * Black wins as she plays on a cell that White occupies.
     */
    @Test
    public void testUpdatePlay2() {
        // game
        final Crush3 crush3 = new Crush3();
        // initial game state
        GameState state = crush3.initialState();
        Board board = state.getBoard();
        boolean end;
        // check it
        Coord coord1 = new Coord(0, 0);
        assertNull(board.getContent(coord1));
        // simulate some steps
        // step 1: Black plays
        crush3.updatePlay(state, new Play(coord1));
        assertEquals('B', board.getContent(coord1).character());
        assertFalse(state.isEnd());
        // step 2: White plays
        Coord coord2 =new Coord(2, 0);
        crush3.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertFalse(state.isEnd());
        // step 3: Black plays
        Coord coord3 = new Coord(0, 2);
        crush3.updatePlay(state, new Play(coord3));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertFalse(state.isEnd());
        // step 4: White plays
        Coord coord4 = new Coord(1, 0);
        crush3.updatePlay(state, new Play(coord4));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertFalse(state.isEnd());
        // step 5: Black plays
        crush3.updatePlay(state, new Play(coord2));
        assertEquals('B', board.getContent(coord1).character());
        assertEquals('W', board.getContent(coord2).character());
        assertEquals('B', board.getContent(coord3).character());
        assertEquals('W', board.getContent(coord4).character());
        assertTrue(state.isEnd());
        assertEquals('B', state.getWinner().displayChar());
    }    
}
