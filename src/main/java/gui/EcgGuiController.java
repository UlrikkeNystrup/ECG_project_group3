package gui;

import business.EcgObserver;
import business.EcgController;
import business.EcgControllerImpl;
import data.dto.EcgDto;
import data.dto.EcgDtoImpl;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Polyline;


public class EcgGuiController implements EcgObserver {
    public Polyline ecgLine;
    public TextField CPR;
    private EcgController ecgController = new EcgControllerImpl();
    long startTime = 0;


    public void startEcg(MouseEvent mouseEvent) {
        ecgController.startRecording(CPR.getText());
        startTime = System.currentTimeMillis();
        ecgController.registerObserver(this);
    }

    @Override
    public void handle(EcgDtoImpl ecgDtoImpl) {
    //    ekgView.setText(ekgView.getText()+"\n" + ekgData);
        ecgLine.getPoints().addAll(((ecgDtoImpl.getTime().getTime()*1.0)-startTime)/25,ecgDtoImpl.getVoltage());
        //når man ganger med 1.0 så konverteres fra long til double. Dividerer med 25, for at få stregen længere ned på skærmen
    }
}
