package App

import lib.sRAD.gui.component.VentanaEmergente
import lib.sRAD.gui.sComponent.*
import javax.swing.JMenu
import javax.swing.JMenuItem

class App: SFrame() {

    var panelInferior: SPanel = listas

    init {
        add(panelInferior)
        add(dataBar)

        addMenuBar()
        setMainBar("My app")
        setProperties()
    }

    private fun addMenuBar() {
        val menuBar = SMenuBar()

        val menuOption = JMenu("File")
        menuBar.add(menuOption)

        val option1 = JMenuItem("Help")
        option1.addActionListener { openHelp() }
        menuOption.add(option1)

        add(menuBar)
    }

    private fun openHelp() {
        val ventanaEmergente = VentanaEmergente(this, 600, 520)

        val taEquivalencia = STextArea(32, 32, 500, 400,
                "1 cine = 1 episodio (15 - 30min)\n"+
                        "5 cine = 1 pelicula estándar (31min - 2h)\n"+
                        "1 game = 1 round de etherlords 2"
        )
        ventanaEmergente.add(taEquivalencia)

        val btnCerrar = SButton(230, 435, 128, 50, "CERRAR")
        btnCerrar.addActionListener { ventanaEmergente.cerrar() }
        ventanaEmergente.add(btnCerrar)

        ventanaEmergente.lanzar()
    }

}