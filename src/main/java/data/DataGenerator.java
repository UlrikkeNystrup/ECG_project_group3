package data;

import business.EcgObserver;
import data.dto.EcgDtoImpl;
import java.security.Timestamp;

public class DataGenerator implements Runnable, EcgDataRecorder{

    private final long waitingTime;

    public DataGenerator(long waitingTime){
        this.waitingTime =waitingTime;
    }

    private EcgObserver observer;

    @Override
    public void run() {
        while (true) {
            try {
                //Simulate sample frequency
                Thread.sleep(waitingTime);
                if (this.observer != null) {
                    //Some random data:
                    EcgDtoImpl dataDTO = new EcgDtoImpl();
                    EcgDtoImpl.setVoltage(Math.random()*200*(-1)+200);
                    EcgDtoImpl.setTime(new Timestamp(System.currentTimeMillis()));
                    //System.out.println("Generated some data: " + dataDTO);
                    observer.update(EcgDtoImpl);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void registerObserver(EcgObserver observer) {
        this.observer = observer;

    }
}
