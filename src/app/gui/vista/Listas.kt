package app

import app.DataBar.moreStars
import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SPanel
import lib.sRAD.gui.sComponent.SScrollPane
import lib.sRAD.gui.sComponent.STextArea
import java.io.*
import javax.swing.ImageIcon
import javax.swing.JOptionPane

object Listas: SPanel(SPanel.EXTERNO, 0, 89, 1276, 627) {

    //estados
    val TAREAS = 0
    val SHOPPING = 1
    var current: Int = TAREAS
    //listas
    val tareas: MutableList<String>
    val shopping: MutableList<String>
    //gui
    val btAddItem: SButton //agrega item
    val btMode: SButton // cambia de lista
    val contentPane = SPanel(SPanel.EXTERNO, 2, 2, 790, 500)

    init {
        btAddItem = SButton(832,32,32,32,"+")
        btAddItem.addActionListener {
            val item = JOptionPane.showInputDialog(null, "Ingrese item")
            addItem(item)
        }
        add(btAddItem)

        btMode = SButton(864,32,32,32,"M")
        btMode.addActionListener {
            current = if (current == TAREAS) SHOPPING else TAREAS
            actualizar()
        }
        add(btMode)

        contentPane.border = null
        val scrollTareas = SScrollPane(32, 32, 800, 550)
        scrollTareas.setViewportView(contentPane)
        add(scrollTareas)

        //cargar listas
        val file = File("data/listas.ser")
        if(file.exists() && file.isFile) {
            val listas = ObjectInputStream(FileInputStream("data/listas.ser"))
            tareas = listas.readObject() as MutableList<String>
            shopping = listas.readObject() as MutableList<String>
        }
        else {
            tareas = mutableListOf()
            shopping = mutableListOf()
        }
        //actualizar
        actualizar()
    }

    private fun guardar() {
        try {
            val salida = ObjectOutputStream(FileOutputStream("data/listas.ser"))
            salida.writeObject(tareas)
            salida.writeObject(shopping)
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar cambio en listas", "Error", 0)
        }
    }

    fun addItem(text: String) {
        if(current == TAREAS)
            tareas.add(text)
        else shopping.add(text)

        guardar()
        actualizar()
    }

    private fun actualizar () {
        contentPane.removeAll()

        if(current == TAREAS && tareas.isNotEmpty()) {
            for (i in tareas.indices) {
                val mushroom = SButton(38, 44 + i * 96, ImageIcon("resources/mushroom.png"))
                mushroom.addActionListener {
                    tareas.removeAt(i)
                    guardar()
                    moreStars()
                    actualizar()
                }
                contentPane.add(mushroom)

                val tarea = STextArea(64, 44 + i * 96, 800, 64, tareas[i])
                contentPane.add(tarea)
            }
            contentPane.setSize(790, if (tareas.size > 6) tareas.size * 100 + 32 else 800)
        }
        else if (current == SHOPPING && shopping.isNotEmpty()) {
            for (i in shopping.indices) {
                val mushroom = SButton(38, 44 + i * 96, ImageIcon("resources/mushroom.png"))
                mushroom.addActionListener {
                    shopping.removeAt(i)
                    guardar()
                    actualizar()
                }
                contentPane.add(mushroom)

                val item = STextArea(64, 44 + i * 96, 800, 64, shopping[i])
                contentPane.add(item)
            }
            contentPane.setSize(790, if (tareas.size > 6) tareas.size * 100 + 32 else 800)
        }

        repaint()
    }

}