//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

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
        stage.setOnCloseRequest((WindowEvent windowEvent)->System.exit(1));
    }
}
