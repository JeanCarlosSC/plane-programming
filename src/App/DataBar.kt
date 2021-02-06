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
    private var games: Int

    private val btStar: SButton
    private val btGame: SButton

    private val lStar: SLabel
    private val lGame: SLabel

    init {
        val file = File("datos.ser")
        if(file.exists() && file.isFile) {
            val objectInputStream = ObjectInputStream(FileInputStream("datos.ser"))
            stars = objectInputStream.readObject() as Int
            games = objectInputStream.readObject() as Int
        }
        else {
            stars = 0
            games = 0
        }

        btStar = SButton(10,5, ImageIcon("resources/star.png"))
        btStar.addMouseListener (object : MouseListener {
            override fun mouseClicked(e: MouseEvent?) {
                if (e!!.isControlDown) moreStars()
                else lessStars()
            }

            override fun mousePressed(e: MouseEvent?) { }

            override fun mouseReleased(e: MouseEvent?) { }

            override fun mouseEntered(e: MouseEvent?) { }

            override fun mouseExited(e: MouseEvent?) { }

        })
        lStar = SLabel(32, 0, 32, 32, "")

        btGame = SButton(70,10, ImageIcon("resources/game.png"))
        btGame.addMouseListener (object : MouseListener {
            override fun mouseClicked(e: MouseEvent?) {
                if (e!!.isControlDown) {
                    if(stars>0) moreGames()
                    else JOptionPane.showMessageDialog(null, "No posee suficientes estrellas", "Error", 0)
                }
                else lessGames()
            }

            override fun mousePressed(e: MouseEvent?) { }

            override fun mouseReleased(e: MouseEvent?) { }

            override fun mouseEntered(e: MouseEvent?) { }

            override fun mouseExited(e: MouseEvent?) { }

        })
        lGame = SLabel(96, 0, 32, 32, "")

        border = null

        actualizar()
    }

    fun moreStars() {
        stars++
        guardar()
        actualizar()
    }

    fun lessStars() {
        stars--
        guardar()
        actualizar()
    }

    fun moreGames() {
        stars--
        games += 4
        guardar()
        actualizar()
    }

    fun lessGames() {
        games--
        guardar()
        actualizar()
    }

    private fun actualizar() {
        removeAll()

        add(btStar)
        lStar.text = "$stars"
        add(lStar)

        add(btGame)
        lGame.text = "$games"
        add(lGame)

        repaint()
    }

    private fun guardar() {
        try {
            val salida = ObjectOutputStream(FileOutputStream("datos.ser"))
            salida.writeObject(stars)
            salida.writeObject(games)
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion del data bar", "Error", 0)
        }
    }

}