import javax.swing.ImageIcon;

/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Bishop  extends Piece {
    //trieda Rook , pracujeme s farbou a v zaleznosti od farby ziskavame obrazok tej farby(black, white)
    private String color;
    private ImageIcon icon ;
    public Bishop(String color) {
        if ( color.equals ( "white" )  ) {
            this.color = "white" ;
            this.icon = new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-bishop.png");

            this.setIcon(this.icon);
        } else {
            this.color = "black" ;
            this.icon = new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-bishop.png");
            this.setIcon(this.icon);
        }
    }
    //vrati farbu

    public String getColor()  {
        return this.color;
    }
    //vrati typ figurky

    public String getType()  {
        return "bishop";
    }

    @Override
    public void handleMove(Cell sourceCell) {

    }


}

