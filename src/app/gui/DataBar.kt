package app.gui

import lib.sRAD.gui.sComponent.SButton
import lib.sRAD.gui.sComponent.SLabel
import lib.sRAD.gui.sComponent.SPanel
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import java.io.*
import javax.swing.ImageIcon
import javax.swing.JOptionPane

object DataBar: SPanel(EXTERNO, 0, 57, 1290, 32) {

    private var stars: Int
    private var games: Int
    private var cines: Int
    private val btStar: SButton
    private val btGame: SButton
    private val btCine: SButton
    private val lStar: SLabel
    private val lGame: SLabel
    private val lCine: SLabel

    init {
        val file = File("data/datos.ser")
        if(file.exists() && file.isFile) {
            val objectInputStream = ObjectInputStream(FileInputStream("data/datos.ser"))
            stars = objectInputStream.readObject() as Int
            games = objectInputStream.readObject() as Int
            cines = objectInputStream.readObject() as Int
        }
        else {
            stars = 0
            games = 0
            cines = 0
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
                    if(stars >0) moreGames()
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

        btCine = SButton(134,5, ImageIcon("resources/cine.png"))
        btCine.addMouseListener (object : MouseListener {
            override fun mouseClicked(e: MouseEvent?) {
                if (e!!.isControlDown) {
                    if(stars >0) moreCines()
                    else JOptionPane.showMessageDialog(null, "No posee suficientes estrellas", "Error", 0)
                }
                else lessCines()
            }

            override fun mousePressed(e: MouseEvent?) { }

            override fun mouseReleased(e: MouseEvent?) { }

            override fun mouseEntered(e: MouseEvent?) { }

            override fun mouseExited(e: MouseEvent?) { }

        })
        lCine = SLabel(160, 0, 32, 32, "")

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
        games ++
        guardar()
        actualizar()
    }

    fun lessGames() {
        games--
        guardar()
        actualizar()
    }

    fun moreCines() {
        stars--
        cines ++
        guardar()
        actualizar()
    }

    fun lessCines() {
        cines--
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

        add(btCine)
        lCine.text = "$cines"
        add(lCine)

        repaint()
    }

    private fun guardar() {
        try {
            val salida = ObjectOutputStream(FileOutputStream("data/datos.ser"))
            salida.writeObject(stars)
            salida.writeObject(games)
            salida.writeObject(cines)
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar la informacion del data bar", "Error", 0)
        }
    }

}