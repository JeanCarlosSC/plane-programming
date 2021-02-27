package lib.sRAD.gui.sComponent;

import lib.sRAD.gui.component.Theme;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

import static lib.sRAD.gui.component.Resource.DTII4Border;
import static lib.sRAD.gui.component.Resource.fontText;

public class SPasswordField extends JPasswordField {

    public SPasswordField(int x, int y, int width, int height) {
        setProperties(x, y, width, height);
    }

    public void setProperties(int x, int y, int width, int height) {
        setProperties(x, y, width, height, true, Theme.fFg, Theme.bg2, fontText, DTII4Border, LEFT);
    }

    public void setProperties(int x, int y, int width, int height, Boolean editable, Color foreground, Color background, Font font, Border border,
                              int hAlignment) {
        this.setBounds(x, y, width, height);
        setEditable(editable);
        setForeground(foreground);
        setFont(font);
        setBackground(background);
        setCaretColor(foreground);
        setBorder(border);
        setHorizontalAlignment(hAlignment);
    }

    /**
     * Renovación del método getPassword() en javax.swing.JPasswordField.
     * @return password ingresada en el password field en forma de String.
     */
    public String getClave() {
        String clave = "";
        char[] chars = getPassword();
        for (char i: chars) {
            clave += i;
        }
        return clave;
    }

}
