package App

import App.dataBar.moreStars
import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SPanel
import lib.sRAD.gui.sComponent.SScrollPane
import lib.sRAD.gui.sComponent.STextArea
import java.io.*
import javax.swing.ImageIcon
import javax.swing.JOptionPane

object listaTareas: SPanel(0, 89, 1276, 627) {

    val tareas: MutableList<String>
    val btAddTarea: SButton
    val pTareas = SPanel(2, 2, 790, 500)

    init {
        btAddTarea = SButton(832,32,32,32,"+")
        btAddTarea.addActionListener {
            val tarea = JOptionPane.showInputDialog(null, "Ingrese tarea")
            addTarea(tarea)
        }
        add(btAddTarea)

        pTareas.border = null
        val scrollTareas = SScrollPane(32, 32, 800, 550)
        scrollTareas.setViewportView(pTareas)
        add(scrollTareas)

        //load
        val file = File("tareas.ser")
        if(file.exists() && file.isFile) {
            tareas = ObjectInputStream(FileInputStream("tareas.ser")).readObject() as MutableList<String>
        }
        else tareas = mutableListOf()
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

    private fun actualizar () {
        pTareas.removeAll()

        if (tareas.isNotEmpty()) {
            for (i in tareas.indices) {
                val mushroom = SButton(38, 44+i*96, ImageIcon("resources/mushroom.png"))
                mushroom.addActionListener {
                    tareas.removeAt(i)
                    guardar()
                    moreStars()
                    actualizar()
                }
                pTareas.add(mushroom)

                val tarea = STextArea(64, 44+i*96, 800, 64, tareas[i])
                pTareas.add(tarea)
            }
            pTareas.setSize(790, if(tareas.size>6)tareas.size*100+32 else 800)
        }
        repaint()
    }

}