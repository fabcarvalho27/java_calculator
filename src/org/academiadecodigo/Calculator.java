package org.academiadecodigo;

import javafx.application.Application;
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
public class Calculator extends Application {

    private GridPane grid;
    private Button[][] buttons;
    private Brain brain = new Brain(this);
    private Label screen =


    @Override
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

        primaryStage.setScene(new Scene(grid, Configs.gridWidth, Configs.gridHeight));
        primaryStage.setTitle("FC Calculator");

    }

    public void createGrid(boolean visibleLines) {
        grid = new GridPane();

        //grid configurations
        grid.setAlignment(Configs.gridPosition);
        grid.setGridLinesVisible(visibleLines);
        grid.setPrefSize(Configs.gridWidth, Configs.gridWidth);
    }

    public void createButtons() {

        //Buttons structure
        String[][] buttonsLabel = new String[][]{
                {"7", "4", "1", "DEL"},
                {"8", "5", "2", "0"},
                {"9", "6", "3", "="},
                {"+", "-", "*", "/"}
        };

        buttons = new Button[Configs.buttonsEachCol][Configs.buttonsEachRow];

        for (int x = 0; x < Configs.buttonsEachCol; x++) {
            for (int y = 0; y < Configs.buttonsEachRow; y++) {

                //create button
                buttons[x][y] = new Button(buttonsLabel[x][y]);

                //button configurations
                buttons[x][y].setFont(Font.font(Configs.calculatorFont, Configs.calculatorFontWeight, Configs.buttonFontSize));
                buttons[x][y].setPrefSize(Configs.buttonWidth, Configs.buttonHeight);


                //add button to grid
                grid.add(buttons[x][y], x, y + 1, 1, 1);
            }
        }
    }

    public void createScreen() {

        String screenText = "0";    //Default screen value

        Label screen = new Label(screenText);

        //Screen configurations
        screen.setPrefHeight(Configs.screenHeight);
        screen.setFont(Font.font(Configs.calculatorFont, Configs.calculatorFontWeight, Configs.screenFontSize));
        GridPane.setHalignment(screen, HPos.RIGHT);

        //add screen to grid
        grid.add(screen, 0, 0, Configs.screenColsWidth, Configs.screenRowsHeight);

    }

    public void createEventsHandle() {

        EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                brain.handleButton(((Button) (event.getSource())).getText());
            }
        };

        for (int x = 0; x < Configs.buttonsEachCol; x++) {
            for (int y = 0; y < Configs.buttonsEachRow; y++) {
                buttons[x][y].setOnAction(handler);

            }
        }

    }


    public static void main(String[] args) {
        launch(args);
    }
}
