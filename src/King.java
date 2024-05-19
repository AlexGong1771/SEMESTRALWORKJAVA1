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
        super(color );


        if (color.equals(Colors.BLACK)){
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-king.png"));
        } else{
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-king.png"));
        }
    }

    @Override
    public boolean isValidMove(Cell previousCell, Cell sourceCell) {
        return false;
    }

    @Override
    public void move(Cell previousCell, Cell sourceCell) {

    }

    @Override
    public void capture(Cell sourceCell) {

    }




}
