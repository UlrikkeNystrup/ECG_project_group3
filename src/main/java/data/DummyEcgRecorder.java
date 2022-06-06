package data;

import business.EcgObserver;
import data.dto.EcgDtoImpl;

import java.sql.Timestamp;

//Subject
//denne klasse genererer simulerede EKG data
public class DummyEcgRecorder implements EcgDataRecorder {
    private EcgObserver observer;

    @Override
    public void record() { //Notify
        new Thread(new Runnable() { //Bruger runnable interfacet
            @Override
            public void run() {
                try {
                    //Dumy data generering
                    while(true) {
                        EcgDtoImpl ecgDtoImpl = new EcgDtoImpl();
                        ecgDtoImpl.setTime(new Timestamp(System.currentTimeMillis())); //returnerer aktuel tid i millisekunder, Timestamp er
                        ecgDtoImpl.setVoltage(Math.random()*200*(-1)+200);
                        if(observer != null) {
                            observer.notify(ecgDtoImpl); //kalder handle() eller Update()
                        }
                        Thread.sleep(25);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    @Override
    public void setObserver(EcgObserver observer) {
        this.observer=observer;
    } //vi implementerer en metode der kan sætte en observer
}
