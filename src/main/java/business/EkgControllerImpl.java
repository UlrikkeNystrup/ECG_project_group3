package business;

import data.DummyEKGRecorder;
import data.EKGData;
import data.EkgDataRecorder;

public class EkgControllerImpl implements EkgController, EKGObserver {
    EkgDataRecorder ekgDataRecorder = new DummyEKGRecorder();
    private EKGObserver observer;

    @Override
    public void startRecording() {
        ekgDataRecorder.record();
        ekgDataRecorder.setObserver(this);
    }

    @Override
    public void registerObserver(EKGObserver ekgObserver) {
        this.observer = ekgObserver;
    }

    @Override
    public void handle(EKGData ekgData) {
        if(observer!=null){
            observer.handle(ekgData);
        }
    }
}
