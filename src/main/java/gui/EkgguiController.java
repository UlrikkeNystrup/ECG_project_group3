package gui;

import business.EKGObserver;
import business.EkgController;
import business.EkgControllerImpl;
import data.EKGData;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

public class EkgguiController implements EKGObserver {
    public Polyline ekgLine;
    private EkgController ekgController = new EkgControllerImpl();



    public void startEkg(MouseEvent mouseEvent) {
        ekgController.startRecording();
        ekgController.registerObserver(this);
    }

    @Override
    public void handle(EKGData ekgData) {
    //    ekgView.setText(ekgView.getText()+"\n" + ekgData);
        ekgLine.getPoints().addAll(ekgData.getTime(),ekgData.getVoltage());

    }
}
