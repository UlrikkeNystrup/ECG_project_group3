package data;

import business.EKGObserver;
//Subject
public class DummyEKGRecorder implements EkgDataRecorder {
    private EKGObserver observer;

    @Override
    public void record() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //Dummy data generation
                    while(true) {
                        Thread.sleep(500);
                        if (observer != null) {
                            observer.handle(new EKGDataImpl(Math.random(), Math.random()));
                        }
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();

    }

    @Override
    public void setObserver(EKGObserver observer) {
        this.observer=observer;
    }
}
