package lib.sRAD.gui.component;

import lib.sRAD.gui.sComponent.SButton;
import lib.sRAD.gui.sComponent.SFrame;
import lib.sRAD.gui.sComponent.SLabel;
import lib.sRAD.gui.sComponent.SPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import static lib.sRAD.gui.component.Resource.*;

public class MainBar extends SPanel {
    private final static ImageIcon iBtExitOn = new ImageIcon("resources/sRAD/mainBar/btExitOn.png");
    private final static ImageIcon iBtExitOff = new ImageIcon("resources/sRAD/mainBar/btExitOff.png");
    private final static ImageIcon iBtMinOff = new ImageIcon("resources/sRAD/mainBar/btMinOff.png");
    private final static ImageIcon iBtMinOn = new ImageIcon("resources/sRAD/mainBar/btMinOn.png");
    private static int frameWidth = 1280;
    private static SButton btExit = null;
    private static SButton btMin = null;

    private final SPanel mainPanel;
    private final SLabel lLogo = new SLabel();
    private final SLabel lTitle = new SLabel();
    private int x0 = 0;
    private int y0 = 0;

    /**
     * Constructor decorado por defecto
     * @param frame frame que agrega el main bar
     */
    public MainBar(SFrame frame) {
        this(frame, 1280, true, Theme.bg2, DTII5);
    }

    /**
     * Constructor personalizado
     * @param frame frame donde se insertará el main bar
     * @param screenWidth ancho del frame
     * @param move si es true, el frame se moverá deslizando el main bar
     * @param backgroundColor background del main bar
     * @param borderColor color del borde del main bar
     */
    public MainBar(SFrame frame, int screenWidth, Boolean move, Color backgroundColor, Color borderColor) {
        super();
        frameWidth  = screenWidth;

        mainPanel = new SPanel(0, 0, screenWidth, 27, backgroundColor, null, null);

        if(move){
            mainPanel.addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    if(e.getSource() == mainPanel) {
                        frame.setLocation(e.getXOnScreen() - x0, e.getYOnScreen() - y0);
                    }
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    if(e.getSource() == mainPanel) {
                        x0 = e.getX();
                        y0 = e.getY();
                    }
                }
            });
        }
        add(mainPanel);

        mainPanel.add(getBtMin(frame));
        mainPanel.add(getBtExit());

        mainPanel.add(lLogo);
        mainPanel.add(lTitle);

        setProperties(0, 0, screenWidth, 29, borderColor, null);
    }

    /**
     * Botón para TERMINAR EJECUCIÓN
     * @return botón decorado e implementado
     */
    public static SButton getBtExit() {
        if (btExit == null) {
            btExit = new SButton(frameWidth - 48, 0, iBtExitOff, defaultCursor);
            btExit.addMouseListener (new MouseListener() {
                @Override
                public void mouseExited(MouseEvent e) {
                    if(e.getSource() == btExit) {
                        btExit.setIcon(iBtExitOff);
                    }
                }

                @Override
                public void mouseClicked(MouseEvent e) {
                    if(e.getSource() == btExit) {
                        if(JOptionPane.showConfirmDialog(null, "Desea salir?") == 0) {
                            System.exit(0);
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e) {}

                @Override
                public void mouseReleased(MouseEvent e) {}

                @Override
                public void mouseEntered(MouseEvent e) {
                    if(e.getSource() == btExit)
                        btExit.setIcon(iBtExitOn);
                }
            });
        }
        return btExit;
    }

    /**
     * botón decorado para minimizar ventanas
     * @param frame ventana que se minimizará
     * @return botón para minimizar frame
     */
    public static SButton getBtMin(SFrame frame) {
        if (btMin == null) {
            btMin =new SButton(frameWidth - 75, 0, iBtMinOff, defaultCursor);
            btMin.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    frame.setExtendedState(SFrame.ICONIFIED);
                }

                @Override
                public void mousePressed(MouseEvent e) { }

                @Override
                public void mouseReleased(MouseEvent e) { }

                @Override
                public void mouseEntered(MouseEvent e) {
                    btMin.setIcon(iBtMinOn);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    btMin.setIcon(iBtMinOff);
                }
            });
        }
        return btMin;
    }

    /**
     * Establece logo al main bar
     * @param icon logo
     */
    public void setLogo(ImageIcon icon) {
        ImageIcon iLogo = new ImageIcon(icon.getImage().getScaledInstance(16, 16, Image.SCALE_DEFAULT));
        lLogo.setProperties(5, 5, iLogo);
    }

    /**
     * Establece título al main bar
     * @param title título
     */
    public void setTitle(String title) {
        lTitle.setProperties(370, 0, 570, 28, title, fontTitleMini, Theme.mbFg, SwingConstants.CENTER);
    }

}
