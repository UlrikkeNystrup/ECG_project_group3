package data;

import business.EcgObserver;
import data.dto.EcgDtoImpl;

import java.sql.Timestamp;

//Subject
public class DummyEcgRecorder implements EcgDataRecorder {
    private EcgObserver observer;

    @Override
    public void record() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Dummy data generering
                    while(true) {
                        EcgDtoImpl ecgDtoImpl = new EcgDtoImpl();
                        ecgDtoImpl.setTime(new Timestamp(System.currentTimeMillis())); //returnerer aktuel tid i millisekunder, Timestamp er
                        ecgDtoImpl.setVoltage(Math.random()*200*(-1)+200);
                        if(observer != null) {
                            observer.handle(ecgDtoImpl);
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
    }
}
