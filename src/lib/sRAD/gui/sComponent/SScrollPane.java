package lib.sRAD.gui.sComponent;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.*;

import static lib.sRAD.gui.component.Resource.*;

public class SScrollPane extends JScrollPane {

    public SScrollPane(int x, int y, int width, int height) {
        setProperties(x, y, width, height);
    }

    public SScrollPane(int x, int y, int width, int height, Component component) {
        setProperties(x, y, width, height);
        setViewportView(component);
    }

    public void setProperties(int x, int y, int width, int height){
        setBounds(x, y, width, height);
        setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        verticalScrollBar.setUI(getCustomScroll());
        horizontalScrollBar.setUI(getCustomScroll());
        setBackground(DTII1);
        setBorder(DTII4Border);
    }

    //Advanced graphic builder
    public static BasicScrollBarUI getCustomScroll() {
        return getCustomScroll(7, 10, DTII1, gray, darkBlueGray);
    }

    public static BasicScrollBarUI getCustomScroll(int grosor, int radio, Color colorFondo, Color colorBarraNormal, Color colorBarraArrastrada) {
        return new BasicScrollBarUI() {
            private Dimension d = new Dimension();
            @Override
            protected JButton createDecreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                JButton boton = new JButton();
                boton.setPreferredSize(d);
                return boton;
            }

            @Override
            protected void paintTrack(Graphics g, JComponent c, Rectangle r) {
                g.setColor(colorFondo);
                g.fillRect(r.x, r.y, r.width, r.height);
            }

            @Override
            protected void paintThumb(Graphics g, JComponent c, Rectangle r) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                JScrollBar sb = (JScrollBar) c;
                if (!sb.isEnabled()) {
                    return;
                }
                else if (isDragging) {
                    g2.setPaint(colorBarraArrastrada);
                }
                else if (isThumbRollover()) {
                    g2.setPaint(colorBarraNormal);
                }
                else {
                    g2.setPaint(colorBarraNormal);
                }
                if (r.width < r.height) {
                    g2.fillRoundRect((r.width - grosor) / 2, r.y, grosor, r.height, radio, radio);
                }
                else {
                    g2.fillRoundRect(r.x, (r.height - grosor) / 2, r.width, grosor, radio, radio);
                }
            }
        };
    }

}
