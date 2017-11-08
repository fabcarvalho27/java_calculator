package org.academiadecodigo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * Created by codecadet on 07/11/2017.
 */
public class UserInterface {

    private GridPane grid;
    private Button[][] buttons;
    private Brain brain = new Brain(this);
    private Label screen;

    public void start(Stage primaryStage) throws Exception {

        createGrid(false);

        //add buttons to grid
        createButtons();

        //create screen
        createScreen();

        //create scene
        createScene(primaryStage);

        //create events
        createEventsHandle();

        //show stage
        primaryStage.show();

    }

    private void createScene(Stage primaryStage) {

        primaryStage.setScene(new Scene(grid, Configs.GRID_WIDTH, Configs.GRID_HEIGHT));
        primaryStage.setTitle("FC Calculator");

    }

    private void createGrid(boolean visibleLines) {
        grid = new GridPane();

        //grid configurations
        grid.setAlignment(Configs.GRID_POSITION);
        grid.setGridLinesVisible(visibleLines);
        grid.setPrefSize(Configs.GRID_WIDTH, Configs.GRID_WIDTH);
    }

    private void createButtons() {

        //Buttons structure
        String[][] buttonsLabel = new String[][]{
                {"7", "4", "1", "AC"},
                {"8", "5", "2", "0"},
                {"9", "6", "3", "="},
                {"+", "-", "*", "/"}
        };

        buttons = new Button[Configs.BUTTONS_EACH_COL][Configs.BUTTONS_EACH_ROW];

        for (int x = 0; x < Configs.BUTTONS_EACH_COL; x++) {
            for (int y = 0; y < Configs.BUTTONS_EACH_ROW; y++) {

                //create button
                buttons[x][y] = new Button(buttonsLabel[x][y]);

                //button configurations
                buttons[x][y].setFont(Font.font(Configs.CALCULATOR_FONT, Configs.CALCULATOR_FONT_WEIGHT, Configs.BUTTON_FONT_SIZE));
                buttons[x][y].setPrefSize(Configs.BUTTON_WIDTH, Configs.BUTTON_HEIGHT);


                //add button to grid
                grid.add(buttons[x][y], x, y + 1, 1, 1);
            }
        }
    }

    private void createScreen() {

        String screenText = "0";    //Default screen value

        screen = new Label(screenText);

        //Screen configurations
        screen.setPrefHeight(Configs.SCREEN_HEIGHT);
        screen.setFont(Font.font(Configs.CALCULATOR_FONT, Configs.CALCULATOR_FONT_WEIGHT, Configs.SCREEN_FONT_SIZE));
        GridPane.setHalignment(screen, HPos.RIGHT);

        //add screen to grid
        grid.add(screen, 0, 0, Configs.SCREEN_COLS_WIDTH, Configs.SCREEN_ROWS_HEIGHT);

    }

    private void createEventsHandle() {

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                brain.handleButton(((Button) (event.getSource())).getText());
            }
        };

        for (int x = 0; x < Configs.BUTTONS_EACH_COL; x++) {
            for (int y = 0; y < Configs.BUTTONS_EACH_ROW; y++) {
                buttons[x][y].setOnAction(handler);

            }
        }

    }

    public Label getScreen() {
        return screen;
    }
}
