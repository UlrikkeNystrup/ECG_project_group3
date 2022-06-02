package gui;

import business.EcgObserver;
import business.EcgController;
import business.EcgControllerImpl;
import data.dto.EcgDto;
import data.dto.EcgDtoImpl;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Polyline;

//denne klasse implementerer Observer interfacet, så er en Observer
// Vil gerne vide når der er sket ændringer med Observable/subject DummyEcgRecorder.
public class EcgGuiController implements EcgObserver {
    public Polyline ecgLine;
    public TextField CPR;
    public Button startknap; //bruges ikke endnu, men skal bruges til at ændre farven+teksten på startknap til stopknap
    private EcgController ecgController = new EcgControllerImpl();
    long startTime = 0;

//metode til håndtering af "museevent", hvis der trykkes på knappen "Start måling"
    public void startEcg(MouseEvent mouseEvent) { //denne metode udføres ved muse-klik på knappen "Start Måling"
        ecgController.startRecording(CPR.getText()); //startRecording() kommer fra EcgControllerImpl
        //startknap.setBackground(new Background(new BackgroundFill(new Paint(new ))));
        startTime = System.currentTimeMillis();
        ecgController.registerObserver(this);
    }

    @Override
    public void notify(EcgDtoImpl ecgDtoImpl) { //notify() svarer til den metode man plejer at kalde update()
    //    ekgView.setText(ekgView.getText()+"\n" + ekgData);
        ecgLine.getPoints().addAll(((ecgDtoImpl.getTime().getTime()*1.0)-startTime)/25,ecgDtoImpl.getVoltage());
        //når man ganger med 1.0 så konverteres fra long til double. Dividerer med 25, for at få stregen længere ned på skærmen
    }
}
