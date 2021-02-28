package app.gui.vista

import app.gui.Ventana
import app.logic.Listas
import lib.sRAD.gui.component.VentanaEmergente
import lib.sRAD.gui.sComponent.*
import javax.swing.ImageIcon

object PListas: SPanel(EXTERNO, 0, 89, 1276, 627) {
    private val btAddList = SButton(576, 32, 128, 32, "Añadir lista")
    var cbListas = SComboBox(SComboBox.DECORADO, 192, 32, 128, 32, Listas.getNombres())

    init {
        btAddList.addActionListener { addList() }
        actualizar()
    }

    fun actualizar() {
        val index = if(Listas.size > 0 && cbListas.selectedIndex == -1) 0 else cbListas.selectedIndex
        cbListas = SComboBox(SComboBox.DECORADO, 416, 32, 128, 32, Listas.getNombres())
        cbListas.selectedIndex = index
        cbListas.addActionListener { actualizar() }

        removeAll()
        add(btAddList)
        if (Listas.isNotEmpty()) {
            //ComboBox
            add(cbListas)

            //pItems
            val pItems = SPanel(INTERNO, 0, 0, 748, 464)

            val items = Listas.getListAt(cbListas.selectedIndex).items
            for (i in items.indices) {
                val btCompletar = SButton(32, 32 + i*32, ImageIcon("resources/mushroom.png"))
                btCompletar.addActionListener{
                    Listas.removeItemAt(cbListas.selectedIndex, i)
                    actualizar()
                }
                pItems.add(btCompletar)

                val item = SLabel(64, 25 + i*32, 684, 28, items[i])
                pItems.add(item)
            }
            if(64+items.size*32 > 434){
                pItems.setSize(pItems.width, 64+items.size*32)
            }
            else {
                pItems.setSize(pItems.width, 464)
            }

            val scroll = SScrollPane(256, 96, 768, 484, pItems)
            add(scroll)

            //btAddItem
            val btAddItem = SButton(736, 32, 128, 32, "Añadir item")
            btAddItem.addActionListener { addItem(cbListas.selectedIndex) }
            add(btAddItem)
        }
        updateUI()
    }

    private fun addItem(indexList: Int) {
        val ventana = VentanaEmergente(Ventana, 380, 140)

        val lItem = SLabel(32, 32, 300, 28, "Inserte item")
        ventana.add(lItem)

        val tfItem = STextField(210, 30, 128, 32)
        ventana.add(tfItem)

        val btConfirm = SButton(76, 80, 100, 32, "AÑADIR")
        btConfirm.addActionListener {
            if (tfItem.isNotEmpty) {
                Listas.insertItemAt(indexList, tfItem.text)
            }
            ventana.cerrar()
            actualizar()
        }
        ventana.add(btConfirm)

        val btCancel = SButton(208, 80, 100, 32, "CANCELAR")
        btCancel.addActionListener { ventana.cerrar() }
        ventana.add(btCancel)

        ventana.lanzar()
    }

    private fun addList() {
        val ventana = VentanaEmergente(Ventana, 380, 140)

        val lNombre = SLabel(32, 32, 300, 28, "Inserte nombre de lista")
        ventana.add(lNombre)

        val tfNombre = STextField(210, 30, 128, 32)
        ventana.add(tfNombre)

        val btConfirm = SButton(76, 80, 100, 32, "AÑADIR")
        btConfirm.addActionListener {
            if (tfNombre.isNotEmpty) {
                Listas.insertNewList(tfNombre.text)
            }
            ventana.cerrar()
            actualizar()
        }
        ventana.add(btConfirm)

        val btCancel = SButton(208, 80, 100, 32, "CANCELAR")
        btCancel.addActionListener { ventana.cerrar() }
        ventana.add(btCancel)

        ventana.lanzar()
    }
}