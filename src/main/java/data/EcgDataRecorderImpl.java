package data;

import business.EcgObserver;
import business.Arduino;
import data.dto.EcgDtoImpl;

import java.sql.Timestamp;

import static java.lang.Double.parseDouble;

public class EcgDataRecorderImpl implements EcgDataRecorder {
    private EcgObserver observer;
    private Arduino arduino = new Arduino("/dev/cu.usbmodem14201"); //indskriv rigtig port;

    @Override
    public void record() { //record svarer til notify()
        System.out.println("Starting recording!");
        new Thread(new Runnable() {
            @Override
            public void run() {

                while(true) {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    String answer = arduino.receiveData();
                    System.out.println("LLOOOOPing" + answer);
                    double ecgData = 0;
                    if (answer!=null && answer.length() > 0){
                        ecgData = parseDouble(answer);
                        System.out.println("Got data: " + ecgData);
                        if(observer != null) {
                            EcgDtoImpl ecgDtoImpl = new EcgDtoImpl();
                            ecgDtoImpl.setTime(new Timestamp(System.currentTimeMillis())); //returnerer aktuel tid i millisekunder, Timestamp er
                            ecgDtoImpl.setVoltage(ecgData);
                            observer.update(ecgDtoImpl);
                        }
                    }


                }

            }

        }).start();
    }

    //port.isClosed();

    @Override
    public void setObserver(EcgObserver observer) {
        this.observer = observer;
    } //vi sætter en observer men til hvad

}



