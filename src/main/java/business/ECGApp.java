package business;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class ECGApp extends Application {

    public static void run(){
        ECGApp.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane, 1000,1000);
        stage.setTitle("ECG App");
        stage.setScene(scene);
        stage.show();



    }
}
