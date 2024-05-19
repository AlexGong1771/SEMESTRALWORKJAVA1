import javax.swing.ImageIcon; // Naše importy
import javax.swing.JLabel;

/**
 * Abstraktná trieda reprezentujúca šachovú figúrku.
 * Táto trieda poskytuje základné atribúty a metódy spoločné pre všetky šachové figúrky,
 * ako farba, ikona a label.
 * Každá konkrétna šachová figúrka (ako Kráľ, Veža, atď.) bude rozširovať túto triedu.
 *
 *
 */
public abstract class Piece {

    private Colors color; // Farba figúrky
    private ImageIcon icon; // Ikona reprezentujúca figúrku vizuálne
    private JLabel label;   // JLabel na zobrazenie figúrky na šachovnici




    /**
     * Konštruktor inicializujúci farbu a label figúrky.
     *
     * @param color Farba figúrky (čierna alebo biela).
     */
    public Piece(Colors color) {
        this.color = color;
        this.label = new JLabel();
    }

    /**
     * Metóda na získanie farby figúrky.
     *
     * @return Farba figúrky.
     */
    public Colors getColor() {
        return this.color;
    }

    /**
     * Metóda na nastavenie ikony JLabel.
     *
     * @param icon Ikona, ktorá sa má nastaviť na JLabel.
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
        this.label.setIcon(icon);
    }

    /**
     * Metóda na získanie JLabel figúrky.
     *
     * @return JLabel figúrky.
     */
    public JLabel getLabel() {
        return this.label;
    }

    /**
     * Abstraktná metóda na pohyb figúrky.
     * Táto metóda musí byť implementovaná v každej podtriede.
     *
     * @param previousCell Bývalé pole, na ktorom figúrka stála.
     * @param sourceCell Pole, na ktoré sa figúrka pohybuje.
     * @param game Aktuálny stav hry.
     */
    public abstract void move(Cell previousCell, Cell sourceCell, Game game);

    /**
     * Metóda na zachytenie figúrky.
     * Môže byť predefinovaná v podtriedach na konkrétne správanie.
     *
     * @param game Aktuálny stav hry.
     */
    public void capture(Game game) {
        game.setCapture(true);
    }
}
