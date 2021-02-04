package App

import lib.sRAD.gui.sComponent.SFrame
import lib.sRAD.gui.sComponent.SMenuBar
import javax.swing.JMenu
import javax.swing.JMenuItem
import javax.swing.JPopupMenu

class App: SFrame() {

    init {


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