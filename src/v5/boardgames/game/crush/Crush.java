package v5.boardgames.game.crush;

import v5.boardgames.game.Action;
import v5.boardgames.game.Board;
import v5.boardgames.game.Game;
import v5.boardgames.game.GameState;
import v5.boardgames.player.HumanPlayer;
import v5.boardgames.player.IAPlayer;
import v5.boardgames.player.Player;

/**
 * Crush game: place a piece on the same cell as your opponent.
 */
public class Crush extends Game {

    /**
     * Constructor.
     */
    public Crush() {
        super(2);
        players[0] = new IAPlayer("Black");
        players[1] = new HumanPlayer("White");
    }

    @Override
    public void updatePlay(GameState state, Action action) {
        Board board = state.getBoard();
        Player p = state.getCurrentPlayer();
        final char opponentChar = opponent(p).displayChar();
        if (board.getContent(action.getLine(), action.getColumn()) == opponentChar) {
            System.out.println("This cell is occupied by the opponent: "
                    + p.getName() + " wins!");
            state.setWinner(p);
            state.setEnd(true);
        } else if (board.getContent(action.getLine(), action.getColumn()) == p.displayChar()) {
            System.out.println("This cell is occupied by the player: "
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
