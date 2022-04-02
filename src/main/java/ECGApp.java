import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class ECGApp extends Application {

    public static void run() {
        launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        /*Group root = new Group();
        Scene scene = new Scene(root, Color.BLACK);
        Stage stage = new Stage();
        //Image icon = new Image("icon.png");
        //stage.getIcons().add(icon);
        stage.setTitle("ECG App");
        stage.setWidth(500);
        stage.setHeight(500);

        Text text = new Text();
        text.setText("Dato");
        text.setX(50);
        text.setY(50);
        text.setFont(Font.font("Verdana",20));
        text.setFill(Color.WHITE);
        root.getChildren().add(text);

         */
        String version = System.getProperty("javafx.version");
        Label label1 = new Label("Hello"+version);
        Label label2 = new Label ("Hej IT");
        GridPane gridPane = new GridPane();
        //gridPane.setGridLinesVisible(true); //hjælpelinjer til at finde afstand mellem labels
        gridPane.add(label1,0,0);
        gridPane.add(label2,2,2);
        Scene scene = new Scene(gridPane, 640,480);
        stage.setScene(scene);
        stage.show();
    }
}
