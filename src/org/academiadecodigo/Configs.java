package org.academiadecodigo;

import javafx.geometry.Pos;
import javafx.scene.text.FontWeight;

/**
 * Created by codecadet on 07/11/2017.
 */
public abstract class Configs {

    //General
    public static final String CALCULATOR_FONT = "Courier";
    public static final FontWeight CALCULATOR_FONT_WEIGHT = FontWeight.NORMAL;
    public static final int BUTTONS_EACH_ROW = 4;
    public static final int BUTTONS_EACH_COL = 4;

    //Grid
    public static final Pos GRID_POSITION = Pos.CENTER;
    public static final double GRID_WIDTH = 300;
    public static final double GRID_HEIGHT = 300;

    //Buttons
    public static final double BUTTON_WIDTH = GRID_WIDTH / 4;
    public static final double BUTTON_HEIGHT = GRID_HEIGHT / 5;
    public static final int BUTTON_FONT_SIZE = 28;

    //Screen
    public static final int SCREEN_COLS_WIDTH = 4;
    public static final int SCREEN_ROWS_HEIGHT = 1;
    public static final double SCREEN_HEIGHT = GRID_HEIGHT / 4;
    public static final int SCREEN_FONT_SIZE = 50;

}
