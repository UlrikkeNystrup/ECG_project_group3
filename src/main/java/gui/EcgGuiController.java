package gui;

import business.EcgObserver;
import business.EcgController;
import business.EcgControllerImpl;
import data.EcgData;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

public class EcgGuiController implements EcgObserver {
    public Polyline ecgLine;
    private EcgController ecgController = new EcgControllerImpl();



    public void startEkg(MouseEvent mouseEvent) {
        ecgController.startRecording();
        ecgController.registerObserver(this);
    }

    @Override
    public void handle(EcgData ecgData) {
    //    ekgView.setText(ekgView.getText()+"\n" + ekgData);
        ecgLine.getPoints().addAll(ecgData.getTime(),ecgData.getVoltage());

    }
}
