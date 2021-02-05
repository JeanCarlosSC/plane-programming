package App

import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SLabel
import lib.sRAD.gui.sComponent.SPanel
import java.io.*
import javax.swing.JOptionPane

object listaTareas: SPanel(0, 89, 1276, 627) {

    val tareas: MutableList<String>
    val btAddTarea: SButton

    init {
        btAddTarea = SButton(0,0,32,32,"+")
        btAddTarea.addActionListener {
            val tarea = JOptionPane.showInputDialog(null, "Ingrese tarea")
            addTarea(tarea)
        }

        val file = File("tareas.ser")
        if(file.exists() && file.isFile) {
            tareas = ObjectInputStream(FileInputStream("tareas.ser")).readObject() as MutableList<String>
        }
        else {
            tareas = mutableListOf()
        }
        actualizar()
    }

    private fun guardar() {
        try {
            val salida = ObjectOutputStream(FileOutputStream("tareas.ser"))
            salida.writeObject(tareas)
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la tarea", "Error", 0)
        }
    }

    fun addTarea(tarea: String) {
        tareas.add(tarea)
        guardar()
        actualizar()
    }

    fun actualizar () {
        removeAll()
        add(btAddTarea)

        if (tareas.isNotEmpty()) {
            for (i in tareas.indices) {
                val tarea = SLabel(32, 32+i*64, 400, 30, tareas[i])
                add(tarea)
            }
        }
        repaint()
    }

}