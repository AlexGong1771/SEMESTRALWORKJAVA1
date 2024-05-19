import javax.swing.ImageIcon;
/**
 * Write a description of class Rook here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */



public class Pawn extends Piece {
    //trieda Rook , pracujeme s farbou a v zaleznosti od farby ziskavame obrazok tej farby(black, white)
//    private String color;
//    private ImageIcon icon ;
//
//    public Pawn(String color) {
//        if ( color.equals ( "white" )  ) {
//            this.color = "white" ;
//            this.icon = new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-pawn.png");
//            this.setIcon(this.icon);
//        } else {
//            this.color = "black" ;
//            this.icon = new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-pawn.png");
//            this.setIcon(this.icon);
//        }
//    }


    public Pawn(String color) {
        super(color ,"pawn");


        if (color.equals("black")){
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\black-pawn.png"));
        } else{
            super.setIcon(new ImageIcon("C:\\Users\\42194\\IdeaProjects\\SEMESTRALWORKJAVA\\res\\obrazky\\white-pawn.png"));
        }
    }
//vrati farbu

//    public String getColor()  {
//        return this.color;
//    }
    //vrati typ figurky



    @Override
    public void handleMove(Cell sourceCell) {

    }


}
