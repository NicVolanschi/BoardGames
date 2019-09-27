package v7.boardgames.game;

import java.util.Set;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import v7.boardgames.action.Play;
import v7.boardgames.player.HumanPlayer;
import v7.boardgames.player.IAPlayer;
import v7.boardgames.player.Player;

public class GameTest {

    /**
     * A minimal implementation.
     */
    class TestGame extends Game {

        public TestGame() {
            super(2);
            players[0] = new HumanPlayer("Black");
            players[1] = new IAPlayer("White");
        }

        @Override
        public void updatePlay(GameState state, Play action) {
        }

        @Override
        public Set<Piece> initPieces(Player p) {
            return null;
        }
    }
    
    @Test
    public void testOpponent() {
        final Game game = new TestGame();
        assertEquals(game.players[1], game.opponent(game.players[0]));
        assertEquals(game.players[0], game.opponent(game.players[1]));
    }
    
    @Test
    public void testInitialState() {
        final Game game = new TestGame();
        final GameState init = game.initialState();
        Assert.assertNotNull(init.getBoard());
        assertEquals(0, init.getCurrentPlayerIndex());
    }
    
    @Test
    public void testPlayers() {
        final Game game = new TestGame();
        assertEquals(2, game.players.length);
        assertEquals("Black", game.players[0].getName());
        assertEquals("White", game.players[1].getName());
    }
}
