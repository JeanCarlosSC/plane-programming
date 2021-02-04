package App

import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SPanel
import javax.swing.JOptionPane

object dataBar: SPanel(0, 57, 1290, 32) {

    init {
        val btAddTarea = SButton(0,0,32,32,"+")
        btAddTarea.addActionListener {
            val tarea = JOptionPane.showInputDialog(null, "Ingrese tarea")
            listaTareas.addTarea(tarea)
        }
        add(btAddTarea)

        border = null
    }

}