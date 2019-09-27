package v6.boardgames.player;

import static org.junit.Assert.*;
import org.junit.Test;
import v6.boardgames.action.IAction;
import v6.boardgames.action.Play;
import v6.boardgames.game.Board;
import v6.boardgames.game.GameState;
import v6.boardgames.game.fill.Fill;

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
        int line = play.getLine();
        int column = play.getColumn();
        assertTrue(0 <= line && line <= Board.NB_LIN);
        assertTrue(0 <= column && column <= Board.NB_COL);
    }
}
