package v7.boardgames.game.crush3;

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
 * Crush3 game.
 */
public class Crush3 extends Game {

    /**
     * Constructor.
     */
    public Crush3() {
        super(2); // 2 players
        players[0] = new IAPlayer("Black");
        players[1] = new HumanPlayer("White");
    }

    @Override
    public void updatePlay(GameState state, Play action) {
        // at the beginning, same rules as Crush
        boolean end = false;
        Board board = state.getBoard();
        Player player = state.getCurrentPlayer();
        final Piece boardContent
                = board.getContent(action.getLine(), action.getColumn());
        if (boardContent != null) {
            // already something in this cell
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
            // nothing in this cell: add the new piece
            Piece piece = state.takeAPiece(player);
            board.setContent(action.getLine(), action.getColumn(), piece);
            int next = (state.getCurrentPlayerIndex() + 1) % 2;
            state.setCurrentPlayer(next);
        }
        if (!end) {
            // check whether a player can still play
            boolean toBeContinued = false;
            int i = 0;
            while (i < players.length && !toBeContinued) {
                toBeContinued |= (state.piecesOfPlayer(players[i]).size() > 0);
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

    @Override
    public Set<Piece> initPieces(Player p) {
        Set<Piece> pieces = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            pieces.add(new Piece(p));
        }
        return pieces;
    }
}
