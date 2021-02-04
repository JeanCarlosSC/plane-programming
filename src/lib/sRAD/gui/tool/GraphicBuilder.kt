package lib.sRAD.gui.tool

import lib.sRAD.gui.component.Resource.*
import java.awt.*
import javax.swing.*
import javax.swing.border.Border

//JTextArea-----------------------------------------------------------------------------------------
fun JTextArea.setProperties(x: Int, y: Int, width: Int, height: Int, editable: Boolean = true, lineWrap: Boolean = true, text: String? = "",
                            foreground: Color? = darkWhite, background: Color? = darkGray, font: Font? = fontText, border: Border? = semiDarkGray2Border,
                            hAlignment: Float = JTextArea.LEFT_ALIGNMENT
) {
    this.setBounds(x, y, width, height)
    this.text = text
    this.isEditable = editable
    this.foreground = foreground
    this.font = font
    this.background = background
    this.caretColor = foreground
    this.border = border
    this.wrapStyleWord = lineWrap
    this.lineWrap = lineWrap
    this.alignmentX = hAlignment
}
