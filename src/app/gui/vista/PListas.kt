package app.gui.vista

import app.gui.Ventana
import app.logic.Listas
import lib.sRAD.gui.component.VentanaEmergente
import lib.sRAD.gui.sComponent.*

object PListas: SPanel(EXTERNO, 0, 89, 1276, 627) {
    private val btAddList = SButton(32, 32, 128, 32, "Añadir lista")

    init {
        btAddList.addActionListener { addList() }
        actualizar()
    }

    fun actualizar() {
        removeAll()
        add(btAddList)
        if (Listas.isNotEmpty()) {
            val cbListas = SComboBox(SComboBox.DECORADO, 160, 32, 128, 32, Listas.getNombres())
            add(cbListas)
        }
    }

    private fun addList() {
        val ventana = VentanaEmergente(Ventana, 600, 400)

        val lNombre = SLabel(32, 32, 300, 28, "Inserte nombre de lista")
        add(lNombre)

        val tfNombre = STextField(64, 64, 128, 32)
        add(tfNombre)

        val btConfirm = SButton(96, 96, 100, 32, "Añadir")
        btConfirm.addActionListener {
            if (tfNombre.isNotEmpty) {
                Listas.insertNewList(tfNombre.text)
            }
            actualizar()
        }
        add(btConfirm)

        val btCancel = SButton(228, 96, 100, 32, "CANCELAR")
        btCancel.addActionListener { ventana.cerrar() }
        add(btCancel)

        ventana.lanzar()
    }
}