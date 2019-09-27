package v8.boardgames.game.near;

import java.util.HashSet;
import java.util.Set;
import v8.boardgames.action.Play;
import v8.boardgames.game.Board;
import v8.boardgames.game.Coord;
import v8.boardgames.game.Game;
import v8.boardgames.game.GameState;
import v8.boardgames.game.Piece;
import v8.boardgames.player.HumanPlayer;
import v8.boardgames.player.IAPlayer;
import v8.boardgames.player.Player;

/**
 * The Game "Near".
 */
public class Near extends Game {

    /**
     * Constructor.
     */
    public Near() {
        super(2);
        players[0] = new HumanPlayer("Black");
        players[1] = new IAPlayer("White");
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

    @Override
    public void updatePlay(GameState state, Play action) {
        Board board = state.getBoard();
        Player player = state.getCurrentPlayer();
        final Piece boardContent = board.getContent(action.getCoord());
        if (boardContent != null) {
            System.out.println("This cell is occupied: "
                    + opponent(player).getName() + " wins!");
            state.setWinner(opponent(player));
            state.setEnd(true);
        } else {
            // check whether there is one piece of the opponent around
            final Coord coord = action.getCoord();
            boolean nearOpponent = coord
                    .near() // around
                    .filter(c -> board.getContent(c) != null) // non-empty
                    .anyMatch(c
                            -> !board.getContent(c).getPlayer().equals(player));
            if (nearOpponent) {
                // fill all empty cells around
                coord.near()
                        .filter(c -> board.getContent(c) == null)
                        .forEach(c -> board.setContent(c, state.takeAPiece(player)));
            }
            // finally, put a piece on the chosen cell
            Piece piece = state.takeAPiece(player);
            board.setContent(coord, piece);
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
    }
}
