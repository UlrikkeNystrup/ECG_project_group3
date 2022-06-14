package business;

import data.DummyEcgRecorder;
import data.dao.EcgDaoImpl;
import data.EcgDataRecorder;
import data.dto.EcgDtoImpl;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//denne klasse er både subjekt og observer, da den implementerer de to interfaces?
public class EcgControllerImpl implements EcgController, EcgObserver {
    private static String CPR; //attribut fra fx:id i gui.fxml filen
    private EcgDataRecorder ecgDataRecorder = new DummyEcgRecorder(5);
    private EcgObserver observer;
    Consumer consumer = new Consumer();
    //private EcgDaoImpl ecgDaoImpl = new EcgDaoImpl();


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
            observer.update(ecgDtoImpl); //hvilken updatemetode bliver kaldt?
        }
        ecgDtoImpl.setPatientId(CPR); //indsætter data for patientId fra tekstfeltet CPR
        if (CPR != null && !CPR.isEmpty()) { //kun hvis der skrives et CPR i tekstfeltet skal data gemmes
            consumer = new Consumer();
            new Thread(consumer).start();
            consumer.enqueue(ecgDtoImpl);
            //This wakes up the consumer to save data
            consumer.notifyOnEmpty();
        }
            //ecgDaoImpl.save(); //save() metoden er implementeret i EcgDaoImpl klassen
        }
    }



