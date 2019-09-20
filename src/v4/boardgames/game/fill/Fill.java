package v4.boardgames.game.fill;

import v4.boardgames.game.Action;
import v4.boardgames.game.Board;
import v4.boardgames.game.GameState;
import v4.boardgames.game.IGame;

/**
 * A 2-player game where each one wants to fill the board.
 */
public class Fill implements IGame {

    @Override
    public void updatePlay(GameState state, Action action) {
        Board board = state.getBoard();
        if (board.getContent(action.getLine(), action.getColumn()) != ' ') {
            System.out.println("This cell is occupied: "
                    + (state.isBlack() ? "White" : "Black") + " wins!");
            state.setEnd(true);
            state.setWinner(state.isBlack() ? 'W' : 'B');
        } else {
            board.setContent(action.getLine(), action.getColumn(), 
                    state.isBlack() ? 'B' : 'W');
            state.setBlack(!state.isBlack());
        }
    }
}
