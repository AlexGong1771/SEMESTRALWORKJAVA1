import javax.swing.ImageIcon;
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Rook extends Piece {
    //trieda Rook , pracujeme s farbou a v zaleznosti od farby ziskavame obrazok tej farby(black, white)
    public Rook(Colors color) {
        super(color );


        if (color.equals(Colors.BLACK)){
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-rook.png"));
        } else{
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\WHITEROOK.png"));
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
