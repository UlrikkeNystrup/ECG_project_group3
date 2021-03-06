//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package business;

import data.dao.EcgDaoImpl;
import data.dto.EcgDtoImpl;

import java.util.LinkedList;
import java.util.List;

public class Consumer implements Runnable {
    private static final int MAX_SIZE = 1500; //størrelse på køen
    private final EcgDaoImpl dataDAO = new EcgDaoImpl();
    private final LinkedList<EcgDtoImpl> queue = new LinkedList<>();
    private final Object emptyLock = new Object();


    public void enqueue(EcgDtoImpl data){
        synchronized (queue){
            // In case buffer is overrun, we just drop data -
            // This is instead of Pausing the producer if the queue is full. (fullLock)
            if (queue.size()<MAX_SIZE) {
                queue.add(data);
            }
        }
    }

    public void waitWhenEmpty() throws InterruptedException { //Når metoden kaldes venter consumeren med at tage data ind i databasen
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
            if (queue.isEmpty()){
                try {
                    //This makes the Thread pause until the producer wakes it up
                    waitWhenEmpty();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            List<EcgDtoImpl> listCopy;
            synchronized (queue){
                //Take a copy of list and empty it;
                listCopy = new LinkedList<>();
                listCopy.addAll(queue);
                queue.clear();

            }
            dataDAO.save(listCopy);
        }
    }
}
