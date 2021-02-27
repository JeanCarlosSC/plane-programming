package lib.sRAD.gui.sComponent;

import javax.swing.*;
import java.awt.*;

import static lib.sRAD.gui.component.Theme.*;

public class STabbedPane extends JTabbedPane {

    //configuraciones pre-establecidas
    public static final int DECORADO = 1; //se basa en los colores del tema actual

    public STabbedPane(int type, int x, int y, int width, int height) {
        if(type == DECORADO){
            setProperties(x, y, width, height, tpBg, tpFg);
        }
    }

    public void setProperties(int x, int y, int width, int height, Color background, Color foreground) {
        setSize(width, height);
        setLocation(x, y);
        setBackground(background);
        setForeground(foreground);
    }

}
