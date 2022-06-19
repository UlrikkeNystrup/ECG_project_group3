package data;

import business.EcgObserver;
import business.Arduino;

public class EcgDataRecorderImpl implements EcgDataRecorder {
    private EcgObserver observer;
    private Arduino port = new Arduino("/dev/cu.usbmodem14201"); //indskriv rigtig port;

    @Override
    public void record() { //record svarer til notify()
        port.isOpen();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    String answer = port.receiveData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                port.isClosed();
            }

        }).start();
    }


    @Override
    public void setObserver(EcgObserver observer) {
        this.observer = observer;
    } //vi sætter en observer men til hvad

}



