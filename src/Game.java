import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JFrame;

//hlavna trieda Game kde sa pouziva ten algoritmus kazdej figurky
public class Game  implements MouseListener {
    private JFrame frame = new JFrame();
    private static  Board board = new Board ( );

    private static Cell previousCell = null;
    private static Cell sourceCell = null;
    private static  Colors pieceColored  ;

    private static Colors whoseMove ;
    private static boolean active = false;
    private static boolean capture = false;
    private Color selected;


    public Game ( ) {
        frame.setLayout ( new GridBagLayout ( ) );
        frame.setTitle("Hary Potter Chess Game");
        GridBagConstraints c = new GridBagConstraints ( );
        c.fill = 1;
        c.gridx = 0;
        c.gridy = 0;
        frame.add ( board.getjPanel(), c );
        c.insets = new Insets ( 50 , 50 , 50 , 50 );
        c.gridx = 9;
        c.gridy = 0;
        board.initializeChessBoard ( );
        whoseMove = Colors.WHITE;

        for ( int i = 0 ; i < 8 ; ++i ) {
            for ( int j = 0 ; j < 8 ; ++j ) {
                board.getCell(i, j).addMouseListener ( this );
            }
        }
        frame.setSize(700, 700);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);

    }
    //policko zisti ze si klikol na ake
    public void mouseClicked (MouseEvent e) {
        sourceCell = (Cell)e.getSource ( );
        if ( !sourceCell.isOpen ( ) ) {
            Game.pieceColored = sourceCell.getPiece ( ).getColor ( );
            //System.out.println("Koniec hry!!!");

        }

        if ( !active && !sourceCell.isOpen ( ) ) {
            active = true;
            previousCell = sourceCell;
            this.selected = previousCell.getBackground ( );
            previousCell.setBackground ( new Color ( 0 , 175 , 3 ) );
            //sourceCell.setBackground(new Color(175, 0, 70));
            if ( !java.util.Objects.equals ( previousCell.getPiece ( ).getColor ( ) , whoseMove ) ) {
                this.clear ( );
            }
        } else if ( active && previousCell.getPiece ( ).getColor ( ).equals ( whoseMove ) ) {
           Piece pieceType = previousCell.getPiece ( );
            Colors pieceColor ;
            pieceColor = previousCell.getPiece ( ).getColor ( );
            int rowOffset;
            int colOffset;
            if ( pieceType instanceof Pawn ) {
                rowOffset = 1;
                colOffset = 6;
                if ( pieceColor.equals(Colors.BLACK) ) {
                    rowOffset = -1;
                    colOffset = 1;
                }
                //zistuje kde bol ten panacik to je ten pohyb
                if ( previousCell.getRow ( ) == colOffset && previousCell.getRow ( ) == sourceCell.getRow ( ) + rowOffset + rowOffset && previousCell.getCol ( ) == sourceCell.getCol ( ) ) {
                    this.movePiece ( );
                } else if ( previousCell.getRow ( ) == sourceCell.getRow ( ) + rowOffset && previousCell.getCol ( ) == sourceCell.getCol ( ) ) {
                    this.movePiece ( );
                } else if ( !sourceCell.isOpen ( ) && previousCell.getRow ( ) == sourceCell.getRow ( ) + rowOffset && Math.abs ( previousCell.getCol ( ) - sourceCell.getCol ( ) ) == 1 ) {
                    capture = true;
                    this.movePiece ( );
                } else {
                    this.clear ( );
                }
            } else if ( pieceType instanceof Knight ) {
                if ( ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 1 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 2 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 1 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) + 1 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) + 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 1 ) && ( previousCell.getRow ( ) != sourceCell.getRow ( ) - 2 || previousCell.getCol ( ) != sourceCell.getCol ( ) - 1 ) ) {
                    this.clear ( );
                } else {
                    capture = true;
                    this.movePiece ( );
                }
            } else if ( pieceType instanceof  Rook ) {
                if ( previousCell.getRow ( ) != sourceCell.getRow ( ) && previousCell.getCol ( ) != sourceCell.getCol ( ) ) {
                    this.clear ( );
                } else {
                    capture = true;
                    this.movePiece ( );
                }
            } else if ( pieceType instanceof Bishop ) {
                rowOffset = previousCell.getRow ( ) - sourceCell.getRow ( );
                colOffset = previousCell.getCol ( ) - sourceCell.getCol ( );
                if ( Math.abs ( rowOffset ) == Math.abs ( colOffset ) ) {
                    capture = true;
                    this.movePiece ( );
                } else {
                    this.clear ( );
                }
            } else if ( pieceType instanceof Queen ) {
                rowOffset = previousCell.getRow ( ) - sourceCell.getRow ( );
                colOffset = previousCell.getCol ( ) - sourceCell.getCol ( );
                if ( Math.abs ( rowOffset ) != Math.abs ( colOffset ) && previousCell.getRow ( ) != sourceCell.getRow ( ) && previousCell.getCol ( ) != sourceCell.getCol ( ) ) {
                    this.clear ( );
                } else {
                    capture = true;
                    this.movePiece ( );
                }
            } else if ( pieceType instanceof King ) {
                rowOffset = previousCell.getRow ( ) - sourceCell.getRow ( );
                colOffset = previousCell.getCol ( ) - sourceCell.getCol ( );
                if ( Math.abs ( rowOffset ) != 1 && Math.abs ( colOffset ) != 1 ) {
                    if ( pieceColored.equals ( Colors.WHITE ) && previousCell.getRow ( ) == 7 && previousCell.getCol ( ) == 4 ) {
                        if ( sourceCell.getRow ( ) == 7 && sourceCell.getCol ( ) == 6 && board.getCell(7, 5).isOpen ( ) && board.getCell(7, 6).isOpen ( ) && board.getCell( 7 , 7 ).getPiece ( )instanceof Rook && board.getCell(7, 7).getPiece ( ).getColor ( ).equals ( Colors.WHITE ) ) {
                            this.movePiece ( );
                            sourceCell = board.getCell( 7 , 5 );
                            previousCell = board.getCell( 7 , 7 );
                            whoseMove = Colors.WHITE;

                            this.selected = board.getCell( 7 , 5 ).getBackground ( );
                            this.movePiece ( );
                        } else if ( sourceCell.getRow ( ) == 7 && sourceCell.getCol ( ) == 2 && board.getCell( 7 , 1 ).isOpen ( ) && board.getCell( 7 , 2 ).isOpen ( ) && board.getCell( 7 , 3 ).isOpen ( ) && board.getCell( 7 , 0 ).getPiece ( ) instanceof  Rook && board.getCell( 7 , 0 ).getPiece ( ).getColor ( ).equals ( Colors.WHITE) ) {
                            this.movePiece ( );
                            sourceCell = board.getCell( 7 , 3 );
                            previousCell = board.getCell( 7 , 0 );
                            whoseMove = Colors.WHITE;

                            this.movePiece ( );
                        }
                    } else if ( pieceColored.equals ( Colors.BLACK ) && previousCell.getRow ( ) == 0 && previousCell.getCol ( ) == 4 ) {
                        if ( sourceCell.getRow ( ) == 0 && sourceCell.getCol ( ) == 6 && board.getCell( 0 , 5 ).isOpen ( ) && board.getCell( 0 , 6 ).isOpen ( ) && board.getCell( 0 , 7 ).getPiece ( ) instanceof Rook && board.getCell( 0 , 7 ).getPiece ( ).getColor ( ).equals ( Colors.WHITE ) ) {
                            this.movePiece ( );
                            sourceCell = board.getCell( 0 , 5 );
                            previousCell = board.getCell( 0 , 7 );
                            whoseMove = Colors.BLACK;

                            this.selected = board.getCell( 0 , 5 ).getBackground ( );
                            this.movePiece ( );
                        } else if ( sourceCell.getRow ( ) == 0 && sourceCell.getCol ( ) == 2 && board.getCell( 0 , 1 ).isOpen ( ) && board.getCell( 0 , 2 ).isOpen ( ) && board.getCell( 0 , 3 ).isOpen ( ) && board.getCell( 0 , 0 ).getPiece ( )instanceof Rook && board.getCell( 0 , 0 ).getPiece ( ).getColor ( ).equals ( Colors.BLACK ) ) {
                            this.movePiece ( );
                            sourceCell = board.getCell( 0 , 3 );
                            previousCell = board.getCell( 0 , 0 );
                            whoseMove = Colors.BLACK;

                            this.movePiece ( );
                        }
                    }
                } else {
                    capture = true;
                    this.movePiece ( );
                }
            } else {
                this.clear ( );
            }
        }

    }
    //tato metoda vipise nam ci bol ten pohyb a ked on bol , cize ked figurka ide do noveho obdlznika nam vipise bol pohyb
    public void movePiece ( ) {
        System.out.println ( "Bol pohyb" );


        if ( capture && !sourceCell.isOpen ( ) && !previousCell.getPiece ( ).getColor ( ).equals( pieceColored ) ) {
            sourceCell.remove ( sourceCell.getPiece ( ) .getLabel());
            sourceCell.setPiece ( null );
            capture = false;
        }

        previousCell.setBackground ( this.selected );
        sourceCell.add ( previousCell.getPiece ( ) .getLabel());
        sourceCell.setPiece ( previousCell.getPiece ( ) );
        sourceCell.revalidate ( );
        board.getjPanel().repaint ( );
        active = false;
        previousCell.setStatus ( true );
        previousCell.setPiece ( null );
        sourceCell.setStatus ( false );
        previousCell = null;
        if ( whoseMove.equals ( Colors.WHITE ) ) {
            whoseMove = Colors.BLACK;
        } else {
            whoseMove = Colors.WHITE;
        }

    }
    //ked sme nechodili fogurkou alebo ne nas cas chodit
    public void clear ( ) {
        System.out.println ( "Nebol ziadny pohyb alebo musi chodit super" );
        previousCell.setBackground ( this.selected );
        active = false;
        capture = false;
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
}

