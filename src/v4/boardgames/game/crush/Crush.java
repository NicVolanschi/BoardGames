package v4.boardgames.game.crush;

import v4.boardgames.game.GameState;
import v4.boardgames.game.Board;
import v4.boardgames.game.Action;
import v4.boardgames.game.IGame;

/**
 * Crush game: place a piece on the same cell as your opponent.
 */
public class Crush implements IGame {

    @Override
    public void updatePlay(GameState state, Action action) {
        Board board = state.getBoard();
        final char playerChar = state.isBlack() ? 'B' : 'W';
        final char opponentChar = state.isBlack() ? 'W' : 'B';
        if (board.getContent(action.getLine(), action.getColumn()) == opponentChar) {
            System.out.println("This cell is occupied by your opponent: "
                    + (state.isBlack() ? "Black" : "White") + " wins!");
            state.setWinner(playerChar);
            state.setEnd(true);
        } else if (board.getContent(action.getLine(), action.getColumn()) == playerChar) {
            System.out.println("This cell is occupied by you: "
                    + (state.isBlack() ? "White" : "Black") + " wins!");
            state.setWinner(opponentChar);
            state.setEnd(true);
        } else {
            board.setContent(action.getLine(), action.getColumn(), playerChar);
            state.setBlack(!state.isBlack());
        }
    }
}
