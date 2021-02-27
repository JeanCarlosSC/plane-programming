package app.logic

import java.io.*
import javax.swing.JOptionPane

object Listas {
    val listas: MutableList<Lista>

    init {
        //carga los datos
        val file = File("data/listas.ser")
        listas = if(file.exists() && file.isFile) {
            val data = ObjectInputStream(FileInputStream("data/listas.ser"))
            data.readObject() as MutableList<Lista>
        } else {
            mutableListOf()
        }
    }

    fun isNotEmpty() = listas.isNotEmpty()

    fun insertNewList(name: String) {
        listas.add(Lista(name))
    }

    fun getNombres(): Array<String> {
        val nombres = mutableListOf<String>()
        for (i in listas) {
            nombres.add(i.nombre)
        }
        return nombres.toTypedArray()
    }

    private fun guardar() {
        try {
            val salida = ObjectOutputStream(FileOutputStream("data/listas.ser"))
            salida.writeObject(listas)
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el último cambio en las listas", "Error",
                JOptionPane.ERROR_MESSAGE)
            e.printStackTrace()
        }
    }
}