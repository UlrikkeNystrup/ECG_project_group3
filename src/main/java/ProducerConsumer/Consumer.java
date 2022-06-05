package ProducerConsumer;

public class Consumer implements Runnable {
    private static final int MAX_QUEUE_CAPACITY = 100;
    private final DataQueue dataQueue;
    private volatile boolean runFlag;

    public Consumer(DataQueue dataQueue) {  //consumeren har en delt datakø som parameter
        this.dataQueue = dataQueue;
        runFlag = true;  //runFlag er initialiseret til true, hvilket stopper consuberprocessen når det er nødvendigt
    }

    @Override
    public void run() {
        consume();
    }

    private void consume() {
    }

    // metode der kører når tråden startes
    //metoden har en konstant kørende while-løkke, denne process stopper når runFLag er falsk
    //hver iteration kontrolerer om køen er tom. hvis køen er tom, venter consumeren på at en message blir sendt
    //denne ventetid bruges også af while-løkken for at undgå falske opvågninger
    //når consumeren vågner efter ventetiden, tjekker den runFlag, hvis flaget er falske bruder den ud af løkken, ellers løser den en besked fra køen og giver besked til produceren om at den venter i "fuld kø"

    public void consume() {
        while (runFlag) {
            Message message;
            if (dataQueue.isEmpty()) {
                try {
                    dataQueue.waitOnEmpty();
                } catch (InterruptedException e) {
                    break;
                }
            }
            if (!runFlag) {
                break;
            }
            message = dataQueue.remove();
            dataQueue.notifyAllForFull();
            useMessage(message);
        }
        public void stop() {
            runFlag = false;
            dataQueue.notifyAllForEmpty();
        }

// opretter et datakø objekt med max kapacitet, et producerobjekt og en tråd

        DataQueue dataQueue = new DataQueue(MAX_QUEUE_CAPACITY);
        Producer producer = new Producer(dataQueue);
        Thread producerThread = new Thread(producer);

        Consumer consumer = new Consumer(dataQueue);
        Thread consumerThread = new Thread(consumer);

        //starter tråden
        producerThread.start();
        consumerThread.start();

        producer.stop();
        consumer.stop();
}

}

}


