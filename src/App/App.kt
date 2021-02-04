package App

import lib.sRAD.gui.sComponent.SFrame
import lib.sRAD.gui.sComponent.SMenuBar
import lib.sRAD.gui.sComponent.SPanel
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.JPopupMenu

class App: SFrame() {

    var panelInferior: SPanel = listaTareas

    init {
        add(panelInferior)
        add(dataBar)

        addMenuBar()
        setMainBar("My app")
        setProperties()
    }

    private fun addMenuBar() {
        val menuBar = SMenuBar()

        val menuOption = JMenu("menuopcion")
        menuBar.add(menuOption)

        val option1 = JMenuItem("opcion 1")
        menuOption.add(option1)

        add(menuBar)
    }

}