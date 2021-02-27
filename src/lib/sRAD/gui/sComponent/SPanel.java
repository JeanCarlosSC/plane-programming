package lib.sRAD.gui.sComponent;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

import static lib.sRAD.gui.component.Theme.pB;
import static lib.sRAD.gui.component.Theme.pBg;

public class SPanel extends JPanel {

    //Formas pre-establecidas
    public static final int INTERNO = 0;//panel interno de un scroll que no requiere borde
    public static final int EXTERNO = 1;//panel independiente que requiere borde

    /**
     * Constructor de javax.swing.JPanel
     */
    public SPanel() {
        super();
    }

    /**
     * Constructor especializado
     * @param type Integer que recibe la forma pre-establecida en la que se configura el panel.
     * @param x Posición x del panel.
     * @param y Posición y del panel.
     * @param width Ancho del panel.
     * @param height Alto del panel.
     */
    public SPanel(int type, int x, int y, int width, int height) {
        switch (type) {
            case INTERNO -> setProperties(x, y, width, height, pBg, null);
            case EXTERNO -> setProperties(x, y, width, height, pBg, pB, null);
        }
    }

    /**
     * Constructor personalizado
     * @param x Posición x del panel.
     * @param y Posición y del panel.
     * @param width Ancho del panel.
     * @param height Alto del panel.
     * @param background Color de fondo del panel.
     * @param border Borde del panel.
     * @param layout Layout del panel.
     */
    public SPanel(int x, int y, int width, int height, Color background, Border border, LayoutManager layout) {
        setProperties(x, y, width, height, background, border, layout);
    }

    /**
     * Cambia el tamaño del panel y lo establece como preferred size por defecto.
     * @param width Ancho del panel.
     * @param height Alto del panel
     */
    public void setSize(int width, int height) {
        super.setSize(width, height);
        setPreferredSize(new Dimension(width, height));
    }

    public void setProperties(int x, int y, int width, int height, Color background, LayoutManager layout) {
        setSize(width, height);
        setLocation(x, y);
        setBackground(background);
        setLayout(layout);
    }

    public void setProperties(int x, int y, int width, int height, Color background, Border border, LayoutManager layout) {
        setProperties(x, y, width, height, background, layout);
        setBorder(border);
    }

}
