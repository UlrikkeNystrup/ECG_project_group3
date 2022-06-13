package data;

import data.dao.EcgDaoImpl;
import data.dto.EcgDtoImpl;
import java.util.LinkedList;
import java.util.List;


public class DataConsumer implements Runnable{
    private static final int MAX_SIZE = 1500;
    private final LinkedList<EcgDtoImpl> dataList = new LinkedList<>();
    private final EcgDaoImpl dataDAO = new EcgDaoImpl();
    private final Object emptyLock = new Object();

    public void enqueue(EcgDtoImpl data){
        synchronized (dataList){
            // In case buffer is overrun, we just drop data -
            // This is instead of Pausing the producer if the queue is full. (fullLock)
            if (dataList.size()<MAX_SIZE) {
                dataList.add(data);
            }
        }
    }

    public void waitOnEmpty() throws InterruptedException {
        synchronized (emptyLock){
            emptyLock.wait();
        }
    }
    public void notifyOnEmpty(){
        synchronized (emptyLock){
            emptyLock.notifyAll();
        }
    }

    @Override
    public void run() {
        while(true){
            if (dataList.isEmpty()){
                try {
                    //This makes the Thread pause until the producer wakes it up
                    waitOnEmpty();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            List<EcgDtoImpl> listCopy;
            synchronized (dataList){
                //Take a copy of list and empty it;
                listCopy = new LinkedList<>();
                listCopy.addAll(dataList);
                dataList.clear();

            }
            dataDAO.save(listCopy);
        }
    }
}
