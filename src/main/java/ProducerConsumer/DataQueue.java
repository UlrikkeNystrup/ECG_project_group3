package ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

//for at lave en afgrænset buffer tages en kø og dens maxSize
// den synkroniserede blok, bruger et objekt til at opnå trådsynkronisering. hvert objekt har en indre lås
// kun den tråd der først opnår låsen, får lov at udføre den synkroniserede blok.

//vi opretter to referencer FULL_QUEUE og EMPTY_QUEUE, dette er handles som initialiseres som objekter
// når køen er fuld, venter prodiceren på FULL_QUEUE objektet, og consumeren giver besked, så snart den modtager en besked

public class DataQueue {
    private final Queue<Message> queue = new LinkedList<>();
    private final int maxSize;
    private final Object FULL_QUEUE = new Object();
    private final Object EMPTY_QUEUE = new Object();

    DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    // other methods
    // producerprocessen kalder waitOnFull metoden
    public void waitOnFull() throws InterruptedException {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.wait();
        }
    }
    //consumer-processen notificerer produceren gennem notifyAllForFull metoden
    public void notifyAllForFull() {
        synchronized (FULL_QUEUE) {
            FULL_QUEUE.notifyAll();
        }
    }
    //hvis køen er tom, vil consumeren vente på EMPTY_QUEUE objektet, og produceren notificerer så snart en besked tilføjes til køen
    public void waitOnEmpty() throws InterruptedException {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.wait();
        }
    }
    // produceren notificerer consumeren gennem notifyAllForEmpty methoden
    public void notifyAllForEmpty() {
        synchronized (EMPTY_QUEUE) {
            EMPTY_QUEUE.notify();
        }
    }
    //producer adder en message til køen
    public void add(Message message) {
        synchronized (queue) {
            queue.add(message);
        }
    }
    //consumeren kalder remove metoden for at hente besked fra køen
    public Message remove() {
        synchronized (queue) {
            return queue.poll();
        }
        public boolean isEmpty() {

        }
    }}

