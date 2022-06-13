package data;

import business.EcgObserver;
import data.dto.EcgDtoImpl;

/**
     * Even More advanced - Consumer waiting if buffer is empty
     */
public class EcgDataController implements EcgObserver {

        private DummyEcgRecorder dataGen;
        private DataConsumer consumer;

        public static void main(String[] args) {
            new EcgDataController().run();
        }

        private void run() {
            dataGen = new DummyEcgRecorder(1500);
            new Thread(dataGen).start();

            dataGen.setObserver(this);
            consumer = new DataConsumer();
            new Thread(consumer).start();
        }

        @Override
        public void handle(EcgDtoImpl data) {
            consumer.enqueue(data);
            //This wakes up the consumer to save data
            consumer.notifyOnEmpty();
        }
    }
}