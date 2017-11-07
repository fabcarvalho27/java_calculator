package org.academiadecodigo;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        UserInterface userInterface = new UserInterface();

        userInterface.start(primaryStage);
    }
}
