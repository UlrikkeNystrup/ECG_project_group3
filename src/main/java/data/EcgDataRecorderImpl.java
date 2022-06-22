//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data;

import business.EcgObserver;
import business.Arduino;
import data.dto.EcgDtoImpl;

import java.io.IOException;
import java.sql.Timestamp;

import static java.lang.Double.parseDouble;

public class EcgDataRecorderImpl implements EcgDataRecorder {
    private EcgObserver observer;
    private Arduino arduino = new Arduino("/dev/cu.usbmodem14201"); //indskriv rigtig port;


    @Override
    public void record() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while(true){
                        Thread.sleep(1);
                        if(observer!=null){
                            String stringAnswer = arduino.receiveData();
                            double ecgData = 0;
                            if(stringAnswer.length()>0){
                                ecgData = Double.parseDouble((stringAnswer));
                                System.out.println("Recieved data" + ecgData);

                                    EcgDtoImpl ecgDtoImpl = new EcgDtoImpl();
                                    ecgDtoImpl.setTime(new Timestamp(System.currentTimeMillis()));
                                    ecgDtoImpl.setVoltage(ecgData);
                                    if(ecgData>200)
                                    observer.update(ecgDtoImpl);

                            }
                        }
                    }
                } catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //port.isClosed();

    @Override
    public void setObserver(EcgObserver observer) {
        this.observer = observer;
    }

}



