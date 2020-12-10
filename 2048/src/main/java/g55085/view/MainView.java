package g55085.view;

import Controller.Controller;
import DesignPatern.Observable;
import DesignPatern.Observer;
import g55085.model.Board;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class MainView extends VBox implements Observer {

    private final HBox hBoxGame;
    private final HBox hboxButton;
    private final Button button;
    private final GameFX theGame;
    private final ListViewBis list;
    private final Label score;

    public MainView(Stage primaryStage) {

        primaryStage.setTitle("2048");
        primaryStage.setMinWidth(600);
        primaryStage.setMinHeight(500);
        this.setSpacing(10);
        this.setStyle("-fx-background-color: BurlyWood;");
        //GameLogger gameLogger= new GameLogger(game);

        this.setPadding(new Insets(20, 10, 20, 10));

        hBoxGame = new HBox();
        hBoxGame.setSpacing(50);
        hBoxGame.setPadding(new Insets(10, 10, 10, 10));

        this.getChildren().add(hBoxGame);

        hboxButton = new HBox();
        hboxButton.setAlignment(Pos.BOTTOM_CENTER);

        hboxButton.setSpacing(20);
        hboxButton.setPadding(new Insets(15, 20, 10, 20));
        this.getChildren().add(hboxButton);

        theGame = new GameFX();
        button = new Button("Recommencer");
        button.setStyle("-fx-background-color: \n"
                + "#090a0c,\n"
                + "linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%)"
                + ",\n"
                + "linear-gradient(#20262b, #191d22),\n"
                + "radial-gradient(center 50% 0%, radius 100%,"
                + " rgba(114,131,148,0.9), rgba(255,255,255,0));\n"
                + "-fx-background-radius: 5,4,3,5;\n"
                + "-fx-background-insets: 0,1,2,0;\n"
                + "-fx-text-fill: white;\n"
                + "-fx-effect: dropshadow( three-pass-box ,"
                + "rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n"
                + "-fx-font-family: \"Arial\";\n"
                + "-fx-text-fill: linear-gradient(white, #d0d0d0);\n"
                + "-fx-font-size: 12px;\n"
                + "-fx-padding: 10 20 10 20;");

        list = new ListViewBis();

        Label scorelbl = new Label("Score:");
        scorelbl.setStyle("-fx-font-family: \"Arial\";\n");

        score = new Label();
        score.setStyle("-fx-font-family: \"Arial\";\n");
        hboxButton.setAlignment(Pos.BOTTOM_LEFT);

        hboxButton.getChildren().addAll(button, scorelbl, score);
        hBoxGame.getChildren().addAll(theGame, list);

        Scene scene = new Scene(this, 500, 200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * add a action to button restart
     *
     * @param controller
     */
    public void addAction(Controller controller) {
        button.setOnAction((ActionEvent event) -> {
            controller.buttonRestart();
        });

    }

    public ListViewBis getList() {
        return list;
    }

    public Label getScore() {
        return score;
    }

    /**
     * get the hbox game
     *
     * @return hboxGame
     */
    public HBox gethBoxGame() {
        return hBoxGame;
    }

    /**
     * get the hbox button
     *
     * @return
     */
    public HBox getHboxButton() {
        return hboxButton;
    }

    /**
     * get the button
     *
     * @return button
     */
    public Button getButton() {
        return button;
    }

    /**
     * get the gamefx
     *
     * @return gameFX
     */
    public GameFX getTheGame() {
        return theGame;
    }

    @Override
    public void update(Observable observer, Object arg) {
        getTheGame().updateBoard((Board) arg);
        //getScore().setText((String) arg);
    }

}
