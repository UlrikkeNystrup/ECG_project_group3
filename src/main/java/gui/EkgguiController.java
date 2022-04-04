package gui;

import business.EKGObserver;
import business.EkgController;
import business.EkgControllerImpl;
import data.EKGData;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

public class EkgguiController implements EKGObserver {
    EkgController ekgController = new EkgControllerImpl();
    @FXML
    public TextArea ekgView;

    public void startEkg(MouseEvent mouseEvent) {
        ekgController.startrecording();
        ekgController.registerObserver(this);
    }

    @Override
    public void handle(EKGData ekgData) {
        ekgView.setText(ekgView.getText()+"\n" + ekgData);

    }
}
