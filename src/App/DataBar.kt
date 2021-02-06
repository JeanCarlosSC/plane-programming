package App

import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SLabel
import lib.sRAD.gui.sComponent.SPanel
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.io.*
import javax.swing.ImageIcon
import javax.swing.JOptionPane

object dataBar: SPanel(0, 57, 1290, 32) {

    private var stars: Int
    private val btStar: SButton
    private val lStar: SLabel

    init {
        val file = File("datos.ser")
        if(file.exists() && file.isFile) {
            stars = ObjectInputStream(FileInputStream("datos.ser")).readObject() as Int
        }
        else {
            stars = 0
        }

        btStar = SButton(10,5, ImageIcon("resources/star.png"))
        btStar.addMouseListener (object : MouseListener {
            override fun mouseClicked(e: MouseEvent?) {
                if (e!!.isControlDown) {
                    stars++
                }
                else {
                    stars--
                }
                guardar()
                actualizar()
            }

            override fun mousePressed(e: MouseEvent?) {
            }

            override fun mouseReleased(e: MouseEvent?) {
            }

            override fun mouseEntered(e: MouseEvent?) { }

            override fun mouseExited(e: MouseEvent?) { }

        })

        lStar = SLabel(32, 0, 32, 32, "")

        border = null

        actualizar()
    }

    fun moreStars() {
        stars++
        guardar()
        actualizar()
    }

    private fun actualizar() {
        removeAll()
        add(btStar)
        lStar.text = "$stars"
        add(lStar)
        repaint()
    }

    private fun guardar() {
        try {
            val salida = ObjectOutputStream(FileOutputStream("datos.ser"))
            salida.writeObject(stars)
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la cantidad de estrellas", "Error", 0)
        }
    }

}