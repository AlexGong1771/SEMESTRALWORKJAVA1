import javax.swing.ImageIcon;

/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Bishop  extends Piece {

    public Bishop(Colors color) {
        super(color);


        if (color.equals(Colors.BLACK)) {
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-bishop.png"));
        } else {
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-bishop.png"));
        }
    }


    @Override
    public void move(Cell previousCell, Cell sourceCell , Game game ) {
        int rowOffset = previousCell.getRow ( ) - sourceCell.getRow ( );
        int colOffset = previousCell.getCol ( ) - sourceCell.getCol ( );
        if ( Math.abs ( rowOffset ) == Math.abs ( colOffset ) ) {
            this.capture(game);
            game.movePiece ( );
        } else {
            game.clear ( );
        }
    }

    @Override
    public void capture(Game game) {
        super.capture(game);
    }





}

