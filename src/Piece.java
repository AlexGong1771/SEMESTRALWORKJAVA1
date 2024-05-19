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

    private String color = "white"; // Color of the piece
    private String type;git


    private ImageIcon icon; // Icon of the piece
    private JLabel label;   // JLabel to display the piece

    public Piece() {
        label = new JLabel();
    }

    public Piece(String color, String type) {
        this.color = color;
        this.type = type;
        label = new JLabel();
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Abstract methods to get the color and type of the piece
    public  String getColor(){
        return this.color;
    }



    public  String getType(){
        return this.type;
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
    public abstract void handleMove(Cell sourceCell);
}
