package app.gui

import app.gui.vista.Resumen
import app.gui.vista.PListas
import lib.sRAD.gui.sComponent.*

object Ventana: SFrame() {

    private var contenedor: SPanel = Resumen

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