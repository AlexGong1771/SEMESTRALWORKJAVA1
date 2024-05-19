import javax.swing.ImageIcon; // Import statements
import javax.swing.JLabel;

/**
 * Write a description of class Piece here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

// Abstract class for all types of pieces
public abstract class Piece {

    private Colors color ; // Color of the piece



    private ImageIcon icon; // Icon of the piece
    private JLabel label;   // JLabel to display the piece

    public Piece() {
        label = new JLabel();
    }

    public Piece(Colors color) {
        this.color = color;
        label = new JLabel();
    }



    public void setColor(Colors color) {
        this.color = color;
    }

    // Abstract methods to get the color and type of the piece
    public  Colors getColor(){
        return this.color;
    }




    // Method to set the icon of the JLabel
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        label.setIcon(icon);
    }

    // Method to get the JLabel
    public JLabel getLabel() {
        return label;
    }
    // Abstract methods for move and capture actions
    public abstract boolean isValidMove(Cell previousCell, Cell sourceCell);
    public abstract void move(Cell previousCell, Cell sourceCell);
    public abstract void capture(Cell sourceCell);
}
