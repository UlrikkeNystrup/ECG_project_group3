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
                    double time = 0;
                    while(true) {
                        Thread.sleep(25);
                        if (observer != null) {
                            observer.handle(new EKGDataImpl(Math.random()*200*(-1)+200, time));
                        }//Math.random()*(-1)*(-180), time));
                        time +=1;
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
