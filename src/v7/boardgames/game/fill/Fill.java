package v7.boardgames.game.fill;

import java.util.HashSet;
import java.util.Set;
import v7.boardgames.action.Play;
import v7.boardgames.game.Board;
import v7.boardgames.game.Game;
import v7.boardgames.game.GameState;
import v7.boardgames.game.Piece;
import v7.boardgames.player.HumanPlayer;
import v7.boardgames.player.IAPlayer;
import v7.boardgames.player.Player;

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
        Player player = state.getCurrentPlayer();
        final Piece boardContent
                = board.getContent(action.getLine(), action.getColumn());
        if (boardContent != null) {
            System.out.println("This cell is occupied: "
                    + opponent(player).getName() + " wins!");
            state.setWinner(opponent(player));
            state.setEnd(true);
        } else {
            Piece piece = state.takeAPiece(player);
            board.setContent(action.getLine(), action.getColumn(), piece);
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
    }

    @Override
    public Set<Piece> initPieces(Player p) {
        Set<Piece> pieces = new HashSet<>();
        // maximum is one piece per cell
        for (int i = 0; i < Board.NB_LIN * Board.NB_COL; i++) {
            pieces.add(new Piece(p));
        }
        return pieces;
    }
}
