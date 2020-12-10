package g55085.view;

import g55085.model.Board;
import g55085.model.Brick;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;

/**
 *
 * @author Thomas Geller (g55085) <g55085@etu.he2b.be>
 */
public class GameFX extends TilePane {

    public GameFX() {
        
        this.setMaxSize(USE_PREF_SIZE, USE_PREF_SIZE);
        this.setVgap(5);
        this.setHgap(5);
        this.setPrefColumns(4);

    }

    public void updateBoard(Board board) {
        this.getChildren().clear();
        Brick[][] tableau = board.getTab();
        for (Brick[] tableau1 : tableau) {
            for (Brick tableau11 : tableau1) {
                Case label = new Case(tableau11.getValue());
                label.setFont(new Font(30.0));
                
                switch (tableau11.getValue()) {
                    case 0:
                        label.setStyle(" -fx-background-color: aliceblue;");
                        break;
                    case 2:
                        label.setStyle(" -fx-background-color: BlanchedAlmond;");
                        break;
                    case 4:
                        label.setStyle(" -fx-background-color: DarkSalmon;");
                        break;
                    case 8:
                        label.setStyle(" -fx-background-color: Coral;");
                        break;
                    case 16:
                        label.setStyle(" -fx-background-color: Orange;");
                        break;
                    case 32:
                        label.setStyle("-fx-background-color: OrangeRed;");
                        break;
                    case 64:
                        label.setStyle(" -fx-background-color: Red;");
                        break;
                    case 128:
                        label.setStyle("-fx-background-color: Magenta;");
                        break;
                    case 256:
                        label.setStyle("-fx-background-color: Lime;");
                        break;
                    case 512:
                        label.setStyle("-fx-background-color: DarkGoldenRod;");
                        break;
                    case 1024:
                        label.setStyle("-fx-background-color: GoldenRod;");
                        break;
                    case 2048:
                        label.setStyle("-fx-background-color: Gold;");
                        break;
                }
                this.getChildren().add(label);
            }
        }

    }

}
