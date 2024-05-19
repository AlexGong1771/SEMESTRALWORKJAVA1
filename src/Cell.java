import javax.swing.JPanel;


//trieda Cell dava nam prave tie obdlznicky co mame na pole
public class Cell extends JPanel {




    private Piece piece;
    private boolean open = true;
    private int row;
    private int col;
    //tu urobime tie riaky a stlbce
    public Cell (int row , int col) {
        this.row = row;
        this.col = col;

    }
    // metoda isOpen dava nam true /false ked sme na tom obdlzniku ci nie na nom.
    public boolean isOpen ( ) {
        return this.open;
    }

    public void setStatus (boolean status) {
        this.open = status;
    }

    public Piece getPiece ( ) {
        return this.piece;
    }

    public void setPiece (Piece piece) {
        this.piece = piece;
    }
    //ukazuje poziciu figorky
    public void setPosition (int row , int col) {
        this.row = row;
        this.col = col;
    }

    public int getRow ( ) {
        return this.row;
    }

    public int getCol ( ) {
        return this.col;
    }

}


