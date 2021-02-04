package lib.sRAD.gui.sComponent;

import javax.swing.*;

import static lib.sRAD.gui.component.Resource.semiDarkGray2Border;
import static lib.sRAD.gui.component.Resource.DTII1;
import static lib.sRAD.gui.tool.AdvancedGraphBuilderKt.getCustomScroll;

public class SScrollPane extends JScrollPane {

    public void setProperties(int x, int y, int width, int height){
        this.setBounds(x, y, width, height);
        this.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        this.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        this.verticalScrollBar.setUI(getCustomScroll());
        this.horizontalScrollBar.setUI(getCustomScroll());
        this.setBackground(DTII1);
        this.setBorder(semiDarkGray2Border);
    }

}
