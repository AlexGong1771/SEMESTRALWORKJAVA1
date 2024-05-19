import javax.swing.ImageIcon;
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class King  extends Piece {
    //trieda King , pracujeme s farbou a v zaleznosti od farby ziskavame obrazok tej farby(black, white)
    public King(Colors color) {
        super(color);


        if (color.equals(Colors.BLACK)) {
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-king.png"));
        } else {
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-king.png"));
        }
    }

    @Override
    public boolean isValidMove(Cell previousCell, Cell sourceCell) {
        return false;
    }

    @Override
    public void move(Cell previousCell, Cell sourceCell, Game game) {
        int rowOffset = previousCell.getRow() - sourceCell.getRow();
        int colOffset = previousCell.getCol() - sourceCell.getCol();
        if (Math.abs(rowOffset) != 1 && Math.abs(colOffset) != 1) {
            if (game.getPieceColored() == (Colors.WHITE) && previousCell.getRow() == 7 && previousCell.getCol() == 4) {
                if (sourceCell.getRow() == 7 && sourceCell.getCol() == 6 && game.getBoard().getCell(7, 5).isOpen() && game.getBoard().getCell(7, 6).isOpen() && game.getBoard().getCell(7, 7).getPiece() instanceof Rook &&game.getBoard().getCell(7, 7).getPiece().getColor().equals(Colors.WHITE)) {
                    game.movePiece();
                    sourceCell = game.getBoard().getCell(7, 5);
                    previousCell = game.getBoard().getCell(7, 7);
                    game.setWhoseMove(Colors.WHITE);

                    game.setSelected( game.getBoard().getCell(7, 5).getBackground());
                    game.movePiece();
                } else if (sourceCell.getRow() == 7 && sourceCell.getCol() == 2 && game.getBoard().getCell(7, 1).isOpen() && game.getBoard().getCell(7, 2).isOpen() && game.getBoard().getCell(7, 3).isOpen() && game.getBoard().getCell(7, 0).getPiece() instanceof Rook && game.getBoard().getCell(7, 0).getPiece().getColor().equals(Colors.WHITE)) {
                    game.movePiece();
                    sourceCell = game.getBoard().getCell(7, 3);
                    previousCell = game.getBoard().getCell(7, 0);
                    game.setWhoseMove(Colors.WHITE);

                    game.movePiece();
                }
            } else if (game.getPieceColored() == (Colors.BLACK) && previousCell.getRow() == 0 && previousCell.getCol() == 4) {
                if (sourceCell.getRow() == 0 && sourceCell.getCol() == 6 && game.getBoard().getCell(0, 5).isOpen() &&game.getBoard().getCell(0, 6).isOpen() && game.getBoard().getCell(0, 7).getPiece() instanceof Rook && game.getBoard().getCell(0, 7).getPiece().getColor().equals(Colors.WHITE)) {
                    game.movePiece();
                    sourceCell = game.getBoard().getCell(0, 5);
                    previousCell = game.getBoard().getCell(0, 7);
                    game.setWhoseMove(Colors.BLACK);

                    game.setSelected(game.getBoard().getCell(0, 5).getBackground());
                    game.movePiece();
                } else if (sourceCell.getRow() == 0 && sourceCell.getCol() == 2 && game.getBoard().getCell(0, 1).isOpen() && game.getBoard().getCell(0, 2).isOpen() && game.getBoard().getCell(0, 3).isOpen() && game.getBoard().getCell(0, 0).getPiece() instanceof Rook && game.getBoard().getCell(0, 0).getPiece().getColor().equals(Colors.BLACK)) {
                   game.movePiece();
                    sourceCell = game.getBoard().getCell(0, 3);
                    previousCell = game.getBoard().getCell(0, 0);
                    game.setWhoseMove(Colors.BLACK);

                    game.movePiece();
                }
            }
        } else {
            this.capture(game);
            game.movePiece();

        }
    }




    @Override
    public void capture(Game game) {
        super.capture(game);
    }
}
