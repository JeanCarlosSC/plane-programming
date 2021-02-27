package lib.sRAD.gui.sComponent;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import static lib.sRAD.gui.component.Resource.fontText;
import static lib.sRAD.gui.component.Theme.*;

public class SComboBox extends JComboBox {

    public static final int DECORADO = 1;

    public SComboBox(int type, int x, int y, int width, int height, String[] opciones) {
        super(opciones);
        if (type == DECORADO) {
            setProperties(x, y, width, height, fontText, fFg, btBg, pB);
        }
    }

    public void setProperties(int x, int y, int width, int height, Font font, Color foreground, Color background, Border border) {
        setSize(width, height);
        setLocation(x, y);
        setBorder(border);
        setFont(font);
        setForeground(foreground);
        setBackground(background);
    }

}
