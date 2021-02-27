package lib.sRAD.gui.tool;

import javax.swing.*;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.awt.geom.RoundRectangle2D;

public class AdvancedGraphBuilder {

    public static Border getBlurredBorder(Color colorBase, int grosor) {
        Border bordeFinal = null;
        Border bordeInicial = BorderFactory.createLineBorder(colorBase, 1, true);
        var siguienteColor = new Color(colorBase.getRed() + 5, colorBase.getGreen() + 5, colorBase.getBlue() + 5);
        var contador = 0;
        while (siguienteColor.getRed() < 251 && siguienteColor.getGreen() < 251 && siguienteColor.getBlue() < 251 && contador < grosor) {
            Border bordeExterno = BorderFactory.createLineBorder(siguienteColor, 1, true);
            if (contador == 0)
                bordeFinal = BorderFactory.createCompoundBorder(bordeExterno, bordeInicial);
            else {
                bordeFinal = BorderFactory.createCompoundBorder(bordeExterno, bordeFinal);
            }
            siguienteColor = new Color(siguienteColor.getRed() + 5, siguienteColor.getGreen() + 5, siguienteColor.getBlue() + 5);
            contador++;
        }
        return bordeFinal;
    }

    public static Border getRoundedBorder(Color color, int radio, Boolean esLineal, Image imagen) {
        return new Border() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int ancho, int alto) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                Area area;
                Component padreContenedor = c.getParent();
                RoundRectangle2D rectanguloBordeado = new RoundRectangle2D.Double();
                rectanguloBordeado.setRoundRect(
                        Double.valueOf(x), Double.valueOf(y), ancho - 1.0, alto - 1.0, Double.valueOf(radio), Double.valueOf(radio)
                );
                if (esLineal) {
                    drawBackground(c, padreContenedor, imagen, g2, ancho, alto);
                    area = drawBorder(c, g2, color, x, y, ancho, alto, rectanguloBordeado);
                } else {
                    area = drawBorder(c, g2, color, x, y, ancho, alto, rectanguloBordeado);
                    drawBackground(c, padreContenedor, imagen, g2, ancho, alto);
                }
                g2.setClip(null);
                g2.draw(area);
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(2, 2, 2, 2);
            }

            @Override
            public boolean isBorderOpaque() {
                return false;
            }
        };
    }

    public static AbstractBorder getCircularBorder(Color color, boolean esLineal, Image imagen) {
        return new AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int ancho, int alto) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_STROKE_CONTROL, RenderingHints.VALUE_STROKE_NORMALIZE);
                Area area;
                Component padreContenedor = c.getParent();
                Ellipse2D circulo = new Ellipse2D.Double();
                circulo.setFrameFromCenter(new Point(x + ancho / 2, y + alto / 2), new Point(ancho, alto));
                if (esLineal) {
                    drawBackground(c, padreContenedor, imagen, g2, ancho, alto);
                    area = drawBorder(c, g2, color, x, y, ancho, alto, circulo);
                }
                else {
                    area = drawBorder(c, g2, color, x, y, ancho, alto, circulo);
                    drawBackground(c, padreContenedor, imagen, g2, ancho, alto);
                }
                g2.setClip(null);
                g2.draw(area);
            }
        };
    }

    public static void drawBackground(Component c, Component padreContenedor, Image imagen, Graphics2D g2, int ancho, int alto) {
        if (imagen != null) {
            g2.drawImage(
                    imagen,
                    0, 0, imagen.getWidth(null), imagen.getHeight(null),
                    c.getX(), c.getY(), imagen.getWidth(null) + c.getX(), imagen.getHeight(null) + c.getY(),
                    c
            );
        }
        else {
            g2.setColor(padreContenedor.getBackground());
            g2.fillRect(0, 0, ancho, alto);
        }
    }

    public static Area drawBorder(Component c, Graphics2D g2, Color color, int x, int y, int ancho, int alto, RectangularShape figura) {
        if (color == null) {
            g2.setPaint(c.getBackground());
        }
        else {
            g2.setPaint(color);
        }
        Area area = new Area(figura);
        Rectangle rectangulo = new Rectangle(0, 0, ancho, alto);
        Area regionBorde = new Area(rectangulo);
        regionBorde.subtract(area);
        g2.setClip(regionBorde);;
        return area;
    }

}
