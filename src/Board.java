import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
//tato trieda Board sluzi na to aby sme sa zobrazili to pole a tie obdlzniky a na nich nase figurky
public class Board  {
    public JPanel getjPanel() {
        return this.jPanel;
    }

    private final JPanel jPanel = new JPanel();
    private Cell[][] cell = new Cell[ 8 ][ 8 ];
    private  Color black ;
    private  Color white;
    private Pawn[] blackPawn = new Pawn[ 8 ];
    private Bishop[] blackBishop = new Bishop[ 2 ];
    private Knight[] blackKnight = new Knight[ 2 ];
    private Rook[] blackRook = new Rook[ 2 ];
    private King blackKing = new King ( Colors.BLACK);
    private Queen blackQueen = new Queen ( Colors.BLACK );
    private Pawn[] whitePawn = new Pawn[ 8 ];
    private Bishop[] whiteBishop = new Bishop[ 2 ];
    private Knight[] whiteKnight = new Knight[ 2 ];
    private Rook[] whiteRook = new Rook[ 2 ];
    private King whiteKing = new King ( Colors.WHITE );
    private Queen whiteQueen = new Queen ( Colors.WHITE );
    //tu ukazujeme ten Board
    public Board ( ) {
        this.initializePieces ( );
        this.jPanel.setLayout ( new GridLayout ( 8 , 8 ) );
        this.black = new Color(196, 152, 70, 255);
        this.white = new Color(255, 255, 255);
        for ( int i = 0 ; i < 8 ; ++i ) {
            for ( int j = 0 ; j < 8 ; ++j ) {
                if ( ( i + j ) % 2 == 0 ) {
                    this.cell[ i ][ j ] = new Cell ( i , j );
                    this.cell[ i ][ j ].setBackground ( this.white );
                } else {
                    this.cell[ i ][ j ] = new Cell ( i , j );
                    this.cell[ i ][ j ].setBackground ( this.black );
                }

                this.cell[ i ][ j ].setPosition ( i , j );
                this.jPanel.add ( this.cell[ i ][ j ] );
            }
        }

    }
    //davame ten obdlznik
    public Cell getCell (int i, int j) {
        return this.cell[i][j];
    }

    public void setCell (int i, int j, Cell cell) {
        this.cell[i][j] = cell;
    }
    //inicializujeme kazdu figurku davame jej farbu
    public void initializePieces ( ) {
        int i;
        for ( i = 0; i < 8 ; ++i ) {
            this.blackPawn[ i ] = new Pawn ( Colors.BLACK );
            this.whitePawn[ i ] = new Pawn ( Colors.WHITE );
        }

        for ( i = 0; i < 2 ; ++i ) {
            this.blackBishop[ i ] = new Bishop ( Colors.BLACK);
            this.whiteBishop[ i ] = new Bishop ( Colors.WHITE );
            this.blackKnight[ i ] = new Knight ( Colors.BLACK );
            this.whiteKnight[ i ] = new Knight ( Colors.WHITE);
            this.blackRook[ i ] = new Rook ( Colors.BLACK );
            this.whiteRook[ i ] = new Rook ( Colors.WHITE );
        }

    }
    //davame tie figurky na ich pozicie
    public void initializeChessBoard ( ) {
        for ( int i = 0 ; i < 8 ; ++i ) {
            this.cell[ 1 ][ i ].add ( this.blackPawn[ i ].getLabel() );
            this.cell[ 6 ][ i ].add ( this.whitePawn[ i ].getLabel());
            this.cell[ 1 ][ i ].setPiece ( this.blackPawn[ i ] );
            this.cell[ 6 ][ i ].setPiece ( this.whitePawn[ i ] );
        }

        this.cell[ 0 ][ 0 ].add ( this.blackRook[ 0 ].getLabel() );
        this.cell[ 0 ][ 7 ].add ( this.blackRook[ 1 ].getLabel() );
        this.cell[ 7 ][ 0 ].add ( this.whiteRook[ 0 ].getLabel() );
        this.cell[ 7 ][ 7 ].add ( this.whiteRook[ 1 ].getLabel() );
        this.cell[ 0 ][ 0 ].setPiece ( this.blackRook[ 0 ] );
        this.cell[ 0 ][ 7 ].setPiece ( this.blackRook[ 1 ] );
        this.cell[ 7 ][ 0 ].setPiece ( this.whiteRook[ 0 ] );
        this.cell[ 7 ][ 7 ].setPiece ( this.whiteRook[ 1 ] );
        this.cell[ 0 ][ 1 ].add ( this.blackKnight[ 0 ].getLabel() );
        this.cell[ 0 ][ 6 ].add ( this.blackKnight[ 1 ].getLabel() );
        this.cell[ 7 ][ 1 ].add ( this.whiteKnight[ 0 ].getLabel() );
        this.cell[ 7 ][ 6 ].add ( this.whiteKnight[ 1 ].getLabel());
        this.cell[ 0 ][ 1 ].setPiece ( this.blackKnight[ 0 ] );
        this.cell[ 0 ][ 6 ].setPiece ( this.blackKnight[ 1 ] );
        this.cell[ 7 ][ 1 ].setPiece ( this.whiteKnight[ 0 ] );
        this.cell[ 7 ][ 6 ].setPiece ( this.whiteKnight[ 1 ] );
        this.cell[ 0 ][ 2 ].add ( this.blackBishop[ 0 ].getLabel() );
        this.cell[ 0 ][ 5 ].add ( this.blackBishop[ 1 ].getLabel() );
        this.cell[ 7 ][ 2 ].add ( this.whiteBishop[ 0 ].getLabel());
        this.cell[ 7 ][ 5 ].add ( this.whiteBishop[ 1 ].getLabel() );
        this.cell[ 0 ][ 2 ].setPiece ( this.blackBishop[ 0 ] );
        this.cell[ 0 ][ 5 ].setPiece ( this.blackBishop[ 1 ] );
        this.cell[ 7 ][ 2 ].setPiece ( this.whiteBishop[ 0 ] );
        this.cell[ 7 ][ 5 ].setPiece ( this.whiteBishop[ 1 ] );
        this.cell[ 0 ][ 3 ].add ( this.blackQueen.getLabel() );
        this.cell[ 0 ][ 4 ].add ( this.blackKing.getLabel());
        this.cell[ 7 ][ 3 ].add ( this.whiteQueen.getLabel() );
        this.cell[ 7 ][ 4 ].add ( this.whiteKing.getLabel() );
        this.cell[ 0 ][ 3 ].setPiece ( this.blackQueen );
        this.cell[ 0 ][ 4 ].setPiece ( this.blackKing );
        this.cell[ 7 ][ 3 ].setPiece ( this.whiteQueen );
        this.cell[ 7 ][ 4 ].setPiece ( this.whiteKing );
        this.setAsNotOpen ( );
    }

    public void setAsNotOpen ( ) {
        for ( int i = 0 ; i < 8 ;   ++i ) {
            for ( int j = 0 ; j < 8 ; ++j ) {
                this.cell[ i ][ j ].setStatus ( i != 0 && i != 1 && i != 6 && i != 7 );
            }
        }

    }
}

