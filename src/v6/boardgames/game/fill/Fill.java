package v6.boardgames.game.fill;

import v6.boardgames.action.Play;
import v6.boardgames.game.Board;
import v6.boardgames.game.Game;
import v6.boardgames.game.GameState;
import v6.boardgames.player.HumanPlayer;
import v6.boardgames.player.IAPlayer;
import v6.boardgames.player.Player;

/**
 * A 2-player game where each one wants to fill the board.
 */
public class Fill extends Game {

    /**
     * Constructor.
     */
    public Fill() {
        super(2);
        players[0] = new HumanPlayer("Black");
        players[1] = new IAPlayer("White");
    }

    @Override
    public void updatePlay(GameState state, Play action) {
        Board board = state.getBoard();
        Player p = state.getCurrentPlayer();
        if (board.getContent(action.getLine(), action.getColumn()) != ' ') {
            System.out.println("This cell is occupied: "
                    + opponent(p).getName() + " wins!");
            state.setWinner(opponent(p));
            state.setEnd(true);
        } else {
            board.setContent(action.getLine(), action.getColumn(),
                    state.getCurrentPlayer().displayChar());
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
    }
}
