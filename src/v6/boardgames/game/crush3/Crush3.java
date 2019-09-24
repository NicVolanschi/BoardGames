package v6.boardgames.game.crush3;

import v6.boardgames.action.Play;
import v6.boardgames.game.Board;
import v6.boardgames.game.LimitedGame;
import v6.boardgames.game.GameState;
import v6.boardgames.game.LimitedGameState;
import v6.boardgames.player.HumanPlayer;
import v6.boardgames.player.IAPlayer;
import v6.boardgames.player.Player;

/**
 * Crush3 game.
 */
public class Crush3 extends LimitedGame {

    /**
     * Constructor.
     */
    public Crush3() {
        super(2, 3); // 2 players, with 3 pieces each
        players[0] = new IAPlayer("Black");
        players[1] = new HumanPlayer("White");
    }

    @Override
    public void updatePlay(GameState state, Play action) {
        LimitedGameState lstate = (LimitedGameState) state;
        // at the beginning, same rules as Crush
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
        lstate.decreaseOnePiece(state.getCurrentPlayerIndex());
        if (!end) {
            // check whether a player can still play
            boolean toBeContinued = false;
            int i = 0;
            while (i < players.length && !toBeContinued) {
                toBeContinued |= (lstate.getNbPieces()[i] > 0);
                i++;
            }
            // if no player can play, end
            if (!toBeContinued) {
                System.out.println("No piece to play: draw!");
                end = true;
            }
        }
        state.setEnd(end);
    }

}
