package gui;

import business.EcgObserver;
import business.EcgController;
import business.EcgControllerImpl;
import data.dto.EcgDto;
import data.dto.EcgDtoImpl;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;

public class EcgGuiController implements EcgObserver {
    public Polyline ecgLine;
    private EcgController ecgController = new EcgControllerImpl();


    public void startEcg(MouseEvent mouseEvent) {
        ecgController.startRecording();
        ecgController.registerObserver(this);
    }

    @Override
    public void handle(EcgDtoImpl ecgDtoImpl) {
    //    ekgView.setText(ekgView.getText()+"\n" + ekgData);
        ecgLine.getPoints().addAll(ecgDtoImpl.getTime(),ecgDtoImpl.getVoltage());

    }
}
