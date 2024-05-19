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
    public void move(Cell previousCell, Cell sourceCell ,Game game ) {
         int rowOffset = 1;
        int  colOffset = 6;

        if (previousCell.getPiece().getColor() == Colors.BLACK) {
            rowOffset = -1;
            colOffset = 1;
        }
        //zistuje kde bol ten panacik to je ten pohyb
        if (previousCell.getRow() == colOffset && previousCell.getRow() == sourceCell.getRow() + rowOffset + rowOffset && previousCell.getCol() == sourceCell.getCol()) {
            game.movePiece();
        } else if (previousCell.getRow() == sourceCell.getRow() + rowOffset && previousCell.getCol() == sourceCell.getCol()) {
            game.movePiece();
        } else if (!sourceCell.isOpen() && previousCell.getRow() == sourceCell.getRow() + rowOffset && Math.abs(previousCell.getCol() - sourceCell.getCol()) == 1) {
            capture(game);
            game.movePiece();
        } else {
            game.clear();

        }


    }

    @Override
    public void capture(Game game) {
        super.capture(game);
    }
}
