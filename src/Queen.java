import javax.swing.ImageIcon;
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Queen extends Piece {
    //trieda Rook , pracujeme s farbou a v zaleznosti od farby ziskavame obrazok tej farby(black, white)
    public Queen(Colors color) {
        super(color);


        if (color.equals(Colors.BLACK)){
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-queen.png"));
        } else{
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\WHITEQUEEN.png"));
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