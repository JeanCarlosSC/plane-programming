package app.logic

import java.io.*
import javax.swing.JOptionPane

object Listas {
    var size = 0
    val listas: MutableList<Lista> = mutableListOf()

    init {
        //carga los datos
        val file = File("data/listas.ser")
        if(file.exists() && file.isFile) {
            val data = ObjectInputStream(FileInputStream("data/listas.ser"))
            size = (data.readObject() as String).toInt()
            for (i in 0 until size) {
                val nombre = data.readObject() as String
                val items = data.readObject() as MutableList<String>
                listas.add(Lista(nombre, items))
            }
        }
    }

    fun isNotEmpty() = size > 0

    fun insertNewList(name: String) {
        listas.add(Lista(name, mutableListOf()))
        size++
        guardar()
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
            salida.writeObject(size.toString())
            for (i in listas) {
                salida.writeObject(i.nombre)
                salida.writeObject(i.items)
            }
        }
        catch (e: Exception) {
            JOptionPane.showMessageDialog(null, "No se pudo guardar el último cambio en las listas", "Error",
                JOptionPane.ERROR_MESSAGE)
            e.printStackTrace()
        }
    }

    fun getListAt(selectedIndex: Int): Lista {
        return listas[selectedIndex]
    }

    fun insertItemAt(indexList: Int, item: String) {
        listas[indexList].items.add(item)
        guardar()
    }

    fun removeItemAt(indexList: Int, indexItem: Int) {
        listas[indexList].items.removeAt(indexItem)
        guardar()
    }
}