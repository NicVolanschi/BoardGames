package v8.boardgames.player;

import static org.junit.Assert.*;
import org.junit.Test;
import v8.boardgames.action.IAction;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.GameState;
import v8.boardgames.game.fill.Fill;

public class IAPlayerTest {
    
    /**
     * Test of play method, of class IAPlayer.
     */
    @Test
    public void testPlay() {
        Fill game = new Fill();
        GameState g = game.initialState();
        IAPlayer player = new IAPlayer("Black");
        IAction action = player.play(g);
        assertTrue(action instanceof Play);
        Play play = (Play)action;
        int line = play.getCoord().getLine();
        int column = play.getCoord().getColumn();
        assertTrue(0 <= line && line <= Board.NB_LIN);
        assertTrue(0 <= column && column <= Board.NB_COL);
    }
}
