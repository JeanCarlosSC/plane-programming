package lib.sRAD.gui.sComponent;

import javax.swing.*;

public class SOptionPane {
    public static void exitMessage() {
        if(JOptionPane.showConfirmDialog(null, "Desea salir?") == 0) {
            System.exit(0);
        }
    }
}
