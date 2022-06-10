package business;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ECGApp extends Application { //anvender Arv, Application class er en abstrakt klasse

    public static void run(){
        ECGApp.launch();
    } //metode, der er nødvendig i denne java-version

    @Override
    public void start(Stage stage) throws Exception { //implementerer start() metoden fra Application class
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml")); //loader fra fxml filen
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane);
        stage.setTitle("ECG App");
        stage.setScene(scene);
        stage.show();
    }
}
