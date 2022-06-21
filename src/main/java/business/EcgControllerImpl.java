package business;

import data.DummyEcgRecorder;
import data.EcgDataRecorderImpl;
import data.dao.EcgDaoImpl;
import data.EcgDataRecorder;
import data.dto.EcgDtoImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//denne klasse er både subjekt og observer, da den implementerer de to interfaces?
public class EcgControllerImpl implements EcgController, EcgObserver {
    private static String CPR; //attribut fra fx:id i gui.fxml filen
    //private EcgDataRecorder ecgDataRecorder = new DummyEcgRecorder(25);
    private EcgDataRecorder ecgDataRecorder = new EcgDataRecorderImpl();
    private EcgObserver observer;
    Consumer consumer = new Consumer();
    private int counter =0;
    //private EcgDaoImpl ecgDaoImpl = new EcgDaoImpl();


    @Override
    public void startRecording(String text) { //denne metode er defineret i interfacet EcgController
        this.CPR = text;
        ecgDataRecorder.record(); //record() kaldes på DummyEcgDataRecorder objekt, metoden er implementeret i DummyEcgRecorder
        ecgDataRecorder.setObserver(this);
        new Thread(consumer).start();
    }


    @Override
    public void registerObserver(EcgObserver ecgObserver) {
        this.observer = ecgObserver;
    }


    @Override
    public void update(EcgDtoImpl ecgDtoImpl) {
        if(observer!=null){
           // if (counter ==0) {
                observer.update(ecgDtoImpl);
               // counter = 5;}
            //else{ counter--;} //vi laver en counter, medfører at brugergrænsefladen kun opdtateres ved hver femte datasæt (så brugergrænsefladen kan følge med)
        }
        ecgDtoImpl.setPatientId(CPR); //indsætter data for patientId fra tekstfeltet CPR
        if (CPR != null && !CPR.isEmpty()) { //kun hvis der skrives et CPR i tekstfeltet skal data gemmes

            consumer.enqueue(ecgDtoImpl);
            //This wakes up the consumer to save data
            consumer.notifyOnEmpty();
        }
            //ecgDaoImpl.save(); //save() metoden er implementeret i EcgDaoImpl klassen
        }
    }



