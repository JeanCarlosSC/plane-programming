package app.gui

import app.dataBar
import app.gui.panel.Resumen
import app.listas
import lib.sRAD.gui.sComponent.*
import javax.swing.JMenu
import javax.swing.JMenuItem

object Ventana: SFrame() {

    var contenedor: SPanel = Resumen

    init {
        add(contenedor)
        add(dataBar)
        add(MenuBar)
        setMainBar("My app")
        setProperties()
    }

    fun setVistaListas() {
        setVista(listas)
    }

    fun setVistaResumen() {
        setVista(Resumen)
    }

    private fun setVista(vista: SPanel) {
        remove(contenedor)
        contenedor = vista
        add(contenedor)
        contenedor.repaint()
    }
}

object MenuBar: SMenuBar() {
    init {
        val mVistas = JMenu("Vistas")
        add(mVistas)

        val miResumen = JMenuItem("Resumen")
        miResumen.addActionListener { Ventana.setVistaResumen() }
        mVistas.add(miResumen)

        val miListas = JMenuItem("Listas")
        miListas.addActionListener { Ventana.setVistaListas() }
        mVistas.add(miListas)
    }
}