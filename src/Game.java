import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JPanel;
import javax.swing.JFrame;

//hlavna trieda Game kde sa pouziva ten algoritmus kazdej figurky
public class Game  implements MouseListener {
    private JFrame frame = new JFrame();
    private Board board = new Board();

    private static Cell previousCell ;
    private static Cell sourceCell ;
    private Colors pieceColored;



    private Colors whoseMove;
    private static boolean active = false;
    private boolean capture = false;
    private Color selected;




    public void setSelected(Color selected) {
        this.selected = selected;
    }

    public void setWhoseMove(Colors whoseMove) {
        this.whoseMove = whoseMove;
    }

    public Game() {
        this.frame.setLayout(new GridBagLayout());
        this.frame.setTitle("Hary Potter Chess Game");
        GridBagConstraints c = new GridBagConstraints();
        c.fill = 1;
        c.gridx = 0;
        c.gridy = 0;
        this.frame.add(this.board.getjPanel(), c);
        c.insets = new Insets(50, 50, 50, 50);
        c.gridx = 9;
        c.gridy = 0;
        this.board.initializeChessBoard();
        this.whoseMove = Colors.WHITE;

        for (int i = 0; i < 8; ++i) {
            for (int j = 0; j < 8; ++j) {
                this.board.getCell(i, j).getjPanel().addMouseListener(this);
            }
        }
        this.frame.setSize(700, 700);
        this.frame.setLocationRelativeTo(null);
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setVisible(true);
        this.frame.setResizable(false);

    }


    public void setCapture(boolean capture) {
        this.capture = capture;
    }


    //policko zisti ze si klikol na ake

    public void mouseClicked(MouseEvent e) {
        JPanel panel = (JPanel)e.getSource();
        sourceCell = (Cell)panel.getClientProperty("cell");
        if (!sourceCell.isOpen()) {
            this.pieceColored = sourceCell.getPiece().getColor();
        }

        if (!active && !sourceCell.isOpen()) {
            active = true;
            previousCell = sourceCell;
            this.selected = previousCell.getjPanel().getBackground();
            previousCell.getjPanel().setBackground(new Color(0, 175, 3));
            if (!java.util.Objects.equals(previousCell.getPiece().getColor(), this.whoseMove)) {
                this.clear();
            }
        } else if (active && previousCell.getPiece().getColor().equals(this.whoseMove)) {
            //////////////////////////// POLOMORFIZMUS ////////////////////////////////////////
            Piece pieceType = previousCell.getPiece();
            pieceType.move(previousCell, sourceCell, this);
            ///////////////////////////////////////////////////////////////////////////////////

        }

    }



    //tato metoda vipise nam ci bol ten pohyb a ked on bol , cize ked figurka ide do noveho obdlznika nam vipise bol pohyb
    public void movePiece ( ) {
        System.out.println ( "Bol pohyb" );
        if ( this.capture && !sourceCell.isOpen() && !previousCell.getPiece().getColor().equals(this.pieceColored)  ) {
            sourceCell.getjPanel().remove ( sourceCell.getPiece().getLabel());
            sourceCell.setPiece ( null );
            this.capture = false;
        }

        previousCell.getjPanel().setBackground ( this.selected );
        sourceCell.getjPanel().add ( previousCell.getPiece().getLabel());
        sourceCell.setPiece ( previousCell.getPiece ( ) );
        sourceCell.getjPanel().revalidate ( );
        this.board.getjPanel().repaint ( );
        active = false;
        previousCell.setStatus ( true );
        previousCell.setPiece ( null );
        sourceCell.setStatus ( false );
        previousCell = null;
        if ( this.whoseMove.equals ( Colors.WHITE ) ) {
            this.whoseMove = Colors.BLACK;
        } else {
            this.whoseMove = Colors.WHITE;
        }

    }
    //ked sme nechodili fogurkou alebo ne nas cas chodit
    public void clear ( ) {
        System.out.println ( "Nebol ziadny pohyb alebo musi chodit super" );
        previousCell.getjPanel().setBackground ( this.selected );
        active = false;
        this.capture = false;
        previousCell = null;
        sourceCell = null;
    }



    public void mouseEntered (MouseEvent e) {
    }

    public void mouseExited (MouseEvent e) {
    }

    public void mousePressed (MouseEvent e) {
    }

    public void mouseReleased (MouseEvent e) {
    }

    public Colors getPieceColored() {
        return this.pieceColored;
    }

    public Board getBoard() {
        return this.board;
    }


}


