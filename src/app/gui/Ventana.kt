package app.gui

import app.gui.vista.Resumen
import app.gui.vista.PListas
import lib.sRAD.gui.sComponent.*
import javax.swing.JMenu
import javax.swing.JMenuItem

object Ventana: SFrame() {

    var contenedor: SPanel = Resumen

    init {
        add(contenedor)
        add(DataBar)
        add(MenuBar)
        setMainBar("My app")
        setProperties()
    }

    fun setVistaListas() {
        setVista(PListas)
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