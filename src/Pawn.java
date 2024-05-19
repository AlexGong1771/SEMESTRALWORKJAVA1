import javax.swing.ImageIcon;
/**
 * Write a description of class Rook here.
 *
 * @author (Olexii Gongalschi)
 * @version (a version number or a date)
 */



public class Pawn extends Piece {
    //trieda Pawn , pracujeme s farbou a v zaleznosti od farby ziskavame obrazok tej farby(black, white)

    public Pawn(Colors color) {
        super(color);


        if (color.equals(Colors.BLACK)){
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-pawn.png"));
        } else{
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-pawn.png"));
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
