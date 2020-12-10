package main;

import Controller.Controller;
import g55085.model.Game;
import g55085.model.Model;
import g55085.view.MainView;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Controller controller = new Controller(new Game(), new MainView(primaryStage));
        controller.startGame();

    }
}
