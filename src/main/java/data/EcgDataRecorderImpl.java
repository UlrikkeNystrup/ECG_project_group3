package data;

import business.Arduino;
import business.EcgObserver;
import data.dto.EcgDtoImpl;

import java.sql.Timestamp;

public class EcgDataRecorderImpl implements EcgDataRecorder {
    private EcgObserver observer;

    private Arduino port =new Arduino("/dev/cu.usbmodem14201"); //indskriv rigtig port;

    @Override
    public void record() { //record svarer til notify()
        port.isOpen();

          new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = port.receiveData();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
          ).start();
          port.isClosed();
        }




    @Override
    public void setObserver(EcgObserver observer) {
        this.observer=observer;
    } //vi sætter en observer men til hvad
}


