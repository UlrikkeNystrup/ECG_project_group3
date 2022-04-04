import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class ECGApp extends Application {

    public static void run(){
        ECGApp.launch();
    }

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui.fxml"));
        AnchorPane anchorPane = loader.load();
        Scene scene = new Scene(anchorPane, 600,600);
        stage.setScene(scene);
        stage.show();



    }
}
