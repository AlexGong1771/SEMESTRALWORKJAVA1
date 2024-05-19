import javax.swing.ImageIcon;
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Knight extends Piece {

    public Knight(Colors color) {
        super(color);


        if (color.equals(Colors.BLACK)) {
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-knight.png"));
        } else {
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-knight.png"));
        }
    }

    @Override
    public boolean isValidMove(Cell previousCell, Cell sourceCell) {
        return false;
    }

    @Override
    public void move(Cell previousCell, Cell sourceCell , Game game ) {
        if ( ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 1 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 1 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 1 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 1 ) ) {
            game.clear ( );
        } else {
            this.capture(game);
            game.movePiece ( );
        }
    }

    @Override
    public void capture(Game game) {
        game.setCapture(true);
    }




}
