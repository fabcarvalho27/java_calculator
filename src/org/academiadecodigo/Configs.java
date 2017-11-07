package org.academiadecodigo;

import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;

/**
 * Created by codecadet on 07/11/2017.
 */
public abstract class Configs {

    //General
    public static final String calculatorFont = "Courier";
    public static final FontWeight calculatorFontWeight = FontWeight.NORMAL;
    public static final int buttonsEachRow = 4;
    public static final int buttonsEachCol = 4;

    //Grid
    public static final Pos gridPosition = Pos.CENTER;
    public static final double gridWidth = 300;
    public static final double gridHeight = 300;

    //Buttons
    public static final double buttonWidth = gridWidth / 4;
    public static final double buttonHeight = gridHeight / 5;
    public static final int buttonFontSize = 28;

    //Screen
    public static final int screenColsWidth = 4;
    public static final int screenRowsHeight = 1;
    public static final double screenHeight = gridHeight / 4;
    public static final int screenFontSize = 50;

}
