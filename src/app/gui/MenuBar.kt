package app.gui

import lib.sRAD.gui.sComponent.SMenuBar
import javax.swing.JMenu
import javax.swing.JMenuItem

object MenuBar: SMenuBar() {
    init {
        val mVistas = JMenu("Cambiar vista")
        add(mVistas)

        val miResumen = JMenuItem("Vista de resumen")
        miResumen.addActionListener { Ventana.setVistaResumen() }
        mVistas.add(miResumen)

        val miListas = JMenuItem("Vista de listas")
        miListas.addActionListener { Ventana.setVistaListas() }
        mVistas.add(miListas)
    }
}
