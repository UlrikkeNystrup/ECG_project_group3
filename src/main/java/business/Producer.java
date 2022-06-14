package business;
import business.EcgObserver;
import data.DummyEcgRecorder;
import data.EcgDataRecorder;
import data.dto.EcgDto;
import data.dto.EcgDtoImpl;

import java.util.LinkedList;

//Klassen burde kunne slettes, skal bare lige være helt sikker inden jeg gør det

public class Producer implements EcgObserver {
    private DummyEcgRecorder dataGenerater = new DummyEcgRecorder(1500);
    private Consumer consumer;

/*   public static void main(String[] args) {
        new Producer().run();
    }

    private void run() {
       dataGenerater.record();

        dataGenerater.setObserver(this);
        consumer = new Consumer();
        new Thread(consumer).start();
    }

*/
    @Override
    public void update(EcgDtoImpl ecgDtoImpl) {
        consumer.enqueue(ecgDtoImpl);
        //This wakes up the consumer to save data
        consumer.notifyOnEmpty();
        }
}

