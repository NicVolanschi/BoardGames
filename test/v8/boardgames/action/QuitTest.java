package v8.boardgames.action;

import org.junit.Test;
import static org.junit.Assert.*;
import v8.boardgames.game.GameState;
import v8.boardgames.game.IGame;
import v8.boardgames.game.fill.Fill;

public class QuitTest {
    
    /**
     * Test of perform method, of class Quit.
     */
    @Test
    public void testPerform() {
        IGame game = new Fill();
        GameState state = game.initialState();
        (new Quit()).perform(game, state);
        assertTrue(state.isEnd());
    }
    
}
