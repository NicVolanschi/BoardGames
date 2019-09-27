package v8.boardgames.game.crush;

import java.util.HashSet;
import java.util.Set;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.Game;
import v8.boardgames.game.GameState;
import v8.boardgames.game.Piece;
import v8.boardgames.player.HumanPlayer;
import v8.boardgames.player.IAPlayer;
import v8.boardgames.player.Player;

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
        Player player = state.getCurrentPlayer();
        final Piece boardContent = board.getContent(action.getCoord());
        if (boardContent != null) {
            if (!boardContent.getPlayer().equals(player)) {
                System.out.println("This cell is occupied by the opponent: "
                        + player.getName() + " wins!");
                state.setWinner(player);
                end = true;
            } else {
                System.out.println("This cell is occupied by the player: "
                        + opponent(player).getName() + " wins!");
                state.setWinner(opponent(player));
                end = true;
            }
        } else {
            Piece piece = state.takeAPiece(player);
            board.setContent(action.getCoord(), piece);
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
        state.setEnd(end);
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
