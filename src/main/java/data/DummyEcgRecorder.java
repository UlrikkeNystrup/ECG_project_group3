package data;

import business.EcgObserver;
import data.dto.EcgDtoImpl;

import java.sql.Timestamp;

//Subject klasse, implementerer subject interface
//denne klasse genererer simulerede EKG data
public class DummyEcgRecorder implements EcgDataRecorder {
    private EcgObserver observer;

    @Override
    public void record() { //her implementers record() metoden, svarer til metode man plejer at kalde notify()
        new Thread(new Runnable() { //opretter et Thread objekt med Runnable interfacet som parameter
            @Override
            public void run() { //arver run() metoden fra Thread klassen og overskriver den
                try {
                    //Dumy data generering
                    while(true) {
                        EcgDtoImpl ecgDtoImpl = new EcgDtoImpl();
                        ecgDtoImpl.setTime(new Timestamp(System.currentTimeMillis())); //returnerer aktuel tid i millisekunder, Timestamp er
                        ecgDtoImpl.setVoltage(Math.random()*200*(-1)+200); //minus 1, for at vende koordinatsystemet, ganger med 200 for at forstørre
                        if(observer != null) {
                            observer.notify(ecgDtoImpl); //notify() svarer til det man normalt kalder update() metode
                        } //så når notify() kaldes (her record() ), så kaldes update() metoden (her notify() )
                        Thread.sleep(25); //venter 25 ms.
                    }
                } catch (InterruptedException e) { //fordi vi bruger sleep() metoden
                    e.printStackTrace();
                }
            }
        }).start(); //starter tråden
    }

    @Override
    public void setObserver(EcgObserver observer) {
        this.observer=observer;
    } //vi implementerer en metode, der kan sætte en observer
    //setObserver() kaldes i EcgControllerImpl
}
