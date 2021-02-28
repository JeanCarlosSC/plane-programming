package lib.sRAD.gui.component;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Resource {

//----------------------------------------COLOUR PALETTES---------------------------------------------------------------
    //basic
    public final static Color BLACK = new Color(0, 0, 0);
    public final static Color RED = new Color(255, 0, 0);
    public final static Color WHITE = new Color(255, 255, 255);

    //green complementary cake
    public final static Color GCC1 = new Color(122, 179, 102);
    public final static Color GCC2 = new Color(193, 255, 171);
    public final static Color GCC3 = new Color(212, 255, 196);
    public final static Color GCC4 = new Color(179, 84, 167);
    public final static Color GCC5 = new Color(255, 171, 245);

    //azul gris celeste análogo
    public final static Color AGCA1 = new Color(74, 75, 246);
    public final static Color AGCA2 = new Color(63, 104, 212);
    public final static Color AGCA3 = new Color(82, 164, 235);
    public final static Color AGCA4 = new Color(63, 181, 212);
    public final static Color AGCA5 = new Color(74, 246, 235);

    //monochrome dark blue
    public final static Color MDB1 = new Color(46, 49, 107);
    public final static Color MDB2 = new Color(78, 80, 107);
    public final static Color MDB3 = new Color(79, 84, 184);
    public final static Color MDB4 = new Color(101, 107, 235);
    public final static Color MDB5 = new Color(174, 177, 238);

    //warning paleta
    public final static Color WP1 = new Color(72, 140, 3);
    public final static Color WP2 = new Color(132, 217, 4);
    public final static Color WP3 = new Color(242, 203, 5);
    public final static Color WP4 = new Color(242, 159, 5);
    public final static Color WP5 = new Color(242, 68, 5);

    //special palette 1
    public final static Color SP1 = new Color(169, 105, 0);
    public final static Color SP2 = new Color(232, 145, 0);
    public final static Color SP3 = new Color(255, 225, 0);
    public final static Color SP4 = new Color(58, 117, 181);
    public final static Color SP5 = new Color(82, 125, 181);
    public final static Color SP6 = new Color(70, 147, 171);
    public final static Color SP7 = new Color(72, 206, 247);

    //others and specials
    public final static Color blackTransparent = new Color(0F, 0F, 0F, 0.8F);
    public final static Color transparentMustard = new Color(1F, 1F, 0F, 0.5F);
    public final static Color transparent = new Color(0F, 0F, 0F, 0F);
    public final static Color superLightGray = new Color(120, 120, 120);
    public final static Color megaDarkWhite = new Color(180, 180, 180);
    public final static Color semiDarkWhite = new Color(210, 210, 210);

//--------------------------------------COLOR THEMES--------------------------------------------------------------------
    //tema amigable
    public final static Color TA1 = new Color(184, 84, 80);
    public final static Color TA2 = new Color(108, 142, 191);
    public final static Color TA3 = new Color(214, 182, 86);
    public final static Color TA4 = new Color(255, 89, 89);
    public final static Color TA5 = new Color(248, 206, 204);
    public final static Color TA6 = new Color(218, 232, 252);
    public final static Color TA7 = new Color(255, 242, 204);

    //Dark Theme based on Intellij Idea
    public final static Color DTII1 = new Color(49, 51, 53); //second background
    public final static Color DTII2 = new Color(43, 43, 43); //console background
    public final static Color DTII3 = new Color(50, 53, 55); //main background
    public final static Color DTII4 = new Color(60, 63, 65);
    public final static Color DTII5 = new Color(81, 81, 81); //mainToolbar bottom border
    public final static Color DTII6 = new Color(85, 85, 85);//console border
    public final static Color DTII7 = new Color(124, 123, 119); //comment font
    public final static Color DTII8 = new Color(114, 115, 122); //var names without use font
    public final static Color DTII9 = new Color(152, 118, 168); //var names in use font
    public final static Color DTII10 = new Color(106, 135, 89); //string font
    public final static Color DTII11 = new Color(98,148, 82); //javadoc font
    public final static Color DTII12 = new Color(199,118,50); //reserve word font
    public final static Color DTII13 = new Color(104,150,186); //numbers font
    public final static Color DTII14 = new Color(187,187,187); //main color font
// -----------------------------------------FONT------------------------------------------------------------------------
    //Windows standard (es windows porque funciona en windows, es decir, no se ha basado en fuentes del SO)
    public final static Font fontTitle = new Font("Gill Sans MT Condensed", Font.BOLD, 64);
    public final static Font fontTitle1 = new Font("Arial", Font.BOLD, 28);
    public final static Font fontTitle2 = new Font("Arial", Font.BOLD, 18);
    public final static Font fontTitleMini = new Font("Arial", Font.PLAIN, 14); //used in title of mainBar, buttons
    public final static Font fontVersion = new Font("Arial", Font.PLAIN, 14);

    public final static Font fontText = new Font("Arial", Font.PLAIN, 17);
    public final static Font WSFS = new Font("Arial", Font.ITALIC, 20); //windows standard font subtitle
    public final static Font fontEcuation = new Font("Arial Narrow", Font.ITALIC, 20);
    public final static Font fontTextMini = new Font("Arial Narrow", Font.PLAIN, 14);
    public final static Font fontTextBig = new Font("Arial", Font.PLAIN, 18);
    public final static Font fontTextBold = new Font("Calibri", Font.BOLD, 18);

    //Linux standard
    public final static Font LST = new Font("Gill Sans MT Condensed", Font.BOLD, 40);//linux standard title
    public final static Font LSS = new Font("Arial", Font.ITALIC, 25);//linux standard subtitle
    public final static Font fontTextLinux = new Font("Liberation Serif", Font.PLAIN, 18);
    public final static Font fontTextBoldLinux = new Font("Liberation Serif", Font.BOLD, 18);

//----------------------------------------CURSORS-----------------------------------------------------------------------
//standard
    public final static Cursor defaultCursor = new Cursor(0);
    public final static Cursor crosshairCursor = new Cursor(1);
    public final static Cursor textCursor = new Cursor(2);
    public final static Cursor waitCursor = new Cursor(3);
    public final static Cursor nResizeCursor = new Cursor(8);
    public final static Cursor eResizeCursor = new Cursor(11);
    public final static Cursor handCursor = new Cursor(12);
    public final static Cursor moveCursor = new Cursor(13);

//----------------------------------------BORDER (B)----------------------------------------------------------------
    //standard
    public final static Border blackBorder = BorderFactory.createLineBorder(BLACK, 2, false);

    //Dark Theme based on Intellij Idea
    public final static Border transparentBorder = BorderFactory.createLineBorder(transparent, 2, false);
    public final static Border blackBorderTransparent = BorderFactory.createLineBorder(blackTransparent, 2, false);
    public final static Border DTII1Border = BorderFactory.createLineBorder(DTII3, 2, false);
    public final static Border grayBorder = BorderFactory.createLineBorder(DTII7, 2, false);
    public final static Border DTII4Border = BorderFactory.createLineBorder(DTII6, 2, false);
    public final static Border DTII4BorderRounded = BorderFactory.createLineBorder(DTII6, 2, true);
    public final static Border darkGrayBorder = BorderFactory.createLineBorder(DTII1, 2, false);

    //tema amigable
    public final static Border ta2Border = BorderFactory.createLineBorder(TA3, 2, false);
    public final static Border ta4Border = BorderFactory.createLineBorder(TA1, 2, false);
    public final static Border ta6Border = BorderFactory.createLineBorder(TA2, 2, false);

    //special palette 1
    public final static Border darkOcherBorder = BorderFactory.createLineBorder(SP1, 2, false);

    //azul gris celeste análogo
    public final static Border agca4Border = BorderFactory.createLineBorder(AGCA4, 2, false);

    //warning paleta
    public final static Border wp2Border = BorderFactory.createLineBorder(WP2, 2, false);

}
