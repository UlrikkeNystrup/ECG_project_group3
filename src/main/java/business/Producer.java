package business;
import business.EcgObserver;
import data.DummyEcgRecorder;
import data.EcgDataRecorder;
import data.dto.EcgDto;
import data.dto.EcgDtoImpl;

import java.util.LinkedList;

public class Producer implements EcgObserver {
    public LinkedList<EcgDto> dataQueue = new LinkedList<>();
    public Object dbEmptyLock = new Object();
    EcgDataRecorder EcgSim = new DummyEcgRecorder();
    int val =400;

    public Producer() {
        EcgSim.setObserver(this);
        EcgSim.record();
        Consumer consumer = new Consumer(dataQueue, dbEmptyLock);// opretter consumer obj, og giver den parametrene en Linkedlist og objekt
        new Thread(consumer).start();
    }

    public void enqueue(EcgDto EcgData){
        synchronized (dataQueue){
            if (dataQueue.size()<400){  //dataQueue.size()<val ??
                dataQueue.add(EcgData);
            }
            synchronized (dbEmptyLock) {
                dbEmptyLock.notify();
            }
        }
    }


    @Override
    public void update(EcgDto ecgData) {
        System.out.println("Got some data!");
        enqueue(ecgData);
        System.out.println("Queue size is: " + dataQueue.size());
        //SHOW data on screen!
    }

    public static void main(String[] args) {
        new Producer();
    }
}
