package business;

import data.DummyEcgRecorder;
import data.dao.EcgDaoImpl;
import data.EcgDataRecorder;
import data.dto.EcgDtoImpl;

import java.util.ArrayList;
import java.util.List;

//denne klasse er både subjekt og observer, da den implementerer de to interfaces?
public class EcgControllerImpl implements EcgController, EcgObserver {
    private static String CPR; //attribut fra fx:id i gui.fxml filen
    private EcgDataRecorder ecgDataRecorder = new DummyEcgRecorder();
    private EcgObserver observer;
    List<EcgDtoImpl> ecgDtoList = new ArrayList<EcgDtoImpl>(); //har tilføjet denne linje
    private EcgDaoImpl ecgDaoImpl = new EcgDaoImpl();

    @Override
    public void startRecording(String text) { //denne metode er defineret i interfacet EcgController
        this.CPR = text;
        ecgDataRecorder.record(); //record() kaldes på DummyEcgDataRecorder objekt, metoden er implementeret i DummyEcgRecorder
        ecgDataRecorder.setObserver(this);
    }

    @Override
    public void registerObserver(EcgObserver ecgObserver) {
        this.observer = ecgObserver;
    }


    @Override
    public void update(EcgDtoImpl ecgDtoImpl) {
        if(observer!=null){
            observer.update(ecgDtoImpl);
        }
        ecgDtoImpl.setPatientId(CPR); //indsætter data for patientId fra tekstfeltet CPR
        if (CPR != null && !CPR.isEmpty()) { //kun hvis der skrives et CPR i tekstfeltet skal data gemmes
            ecgDaoImpl.save(ecgDtoList); //save() metoden er implementeret i EcgDaoImpl klassen
        }
    }
}
