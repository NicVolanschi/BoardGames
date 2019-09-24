package v5.boardgames.game.fill;

import v5.boardgames.game.Action;
import v5.boardgames.game.Board;
import v5.boardgames.game.Game;
import v5.boardgames.game.GameState;
import v5.boardgames.player.HumanPlayer;
import v5.boardgames.player.IAPlayer;
import v5.boardgames.player.Player;

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
    public void updatePlay(GameState state, Action action) {
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
