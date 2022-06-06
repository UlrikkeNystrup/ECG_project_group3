
package ProducerConsumer;


// producer klassen implementerer et Runnable interface for at aktivere tråden
public class Producer implements Runnable {
    private final DataQueue dataQueue;
    private volatile boolean runFlag;

    public Producer(DataQueue dataQueue) {
        this.dataQueue = dataQueue;
        runFlag = true;
    }

    @Override
    public void run() {
        produce();
    }
//produceren kører kontinuerligt i en while-løkke, som brydes hvis runFlag er falsk
//I hver iteration genererer den en besked. Derefter tjekker den om køen er fuld og venter efter behov

    private void produce() {
        while (runFlag) {
            Message message = generateMessage();
            while (dataQueue.isFull()) {
                try {
                    dataQueue.waitOnFull();
                } catch (InterruptedException e) {
                    break;
                }

            }
            if (!runFlag) {
                break;
            }
            dataQueue.add(message);
            dataQueue.notifyAllForEmpty();
        }
    }
    public void stop() {
        runFlag = false;
        dataQueue.notifyAllForFull();
    }
// stop metoden afslutter processen
// når runFlag skifter til falsk, blir alle producere der venter i en "fuld kø" tilstand, notificeret
}