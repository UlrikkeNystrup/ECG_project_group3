package data;

import business.EcgObserver;
//Subject
public class DummyEcgRecorder implements EcgDataRecorder {
    private EcgObserver observer;

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
                            observer.handle(new EcgDataImpl(Math.random()*200*(-1)+200, time));
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
    public void setObserver(EcgObserver observer) {
        this.observer=observer;
    }
}
