package v6.boardgames.game.crush;

import v6.boardgames.action.Play;
import v6.boardgames.game.Board;
import v6.boardgames.game.Game;
import v6.boardgames.game.GameState;
import v6.boardgames.player.HumanPlayer;
import v6.boardgames.player.IAPlayer;
import v6.boardgames.player.Player;

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
    public void updatePlay(GameState state, Play action) {
        boolean end = false;
        Board board = state.getBoard();
        Player p = state.getCurrentPlayer();
        final char opponentChar = opponent(p).displayChar();
        if (board.getContent(action.getLine(), action.getColumn()) == opponentChar) {
            System.out.println("This cell is occupied by the opponent: "
                    + p.getName() + " wins!");
            state.setWinner(p);
            end = true;
        } else if (board.getContent(action.getLine(), action.getColumn()) == p.displayChar()) {
            System.out.println("This cell is occupied by the player: "
                    + opponent(p).getName() + " wins!");
            state.setWinner(opponent(p));
            end = true;
        } else {
            board.setContent(action.getLine(), action.getColumn(),
                    state.getCurrentPlayer().displayChar());
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
        state.setEnd(end);
    }
}
