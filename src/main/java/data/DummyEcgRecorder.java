//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data;

import business.EcgObserver;
import data.dto.EcgDtoImpl;

import java.sql.Timestamp;
import java.util.UUID;

//Subject
//denne klasse genererer simulerede EKG data

public class DummyEcgRecorder implements EcgDataRecorder {
    private EcgObserver observer;

    private final long waitingTime;

    public DummyEcgRecorder(long waitingTime){
        this.waitingTime =waitingTime;
    }


    @Override
    public void record() { //record svarer til notify()
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
                            observer.update(ecgDtoImpl);
                        }
                        Thread.sleep(waitingTime);
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
    } //vi sætter en observer
}
