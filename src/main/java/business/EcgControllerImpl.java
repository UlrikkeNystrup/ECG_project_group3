package business;

import data.DummyEcgRecorder;
import data.dto.EcgDto;
import data.EcgDataRecorder;
import data.dto.EcgDtoImpl;

public class EcgControllerImpl implements EcgController, EcgObserver {
    private EcgDataRecorder ecgDataRecorder = new DummyEcgRecorder();
    private EcgObserver observer;

    @Override
    public void startRecording() {
        ecgDataRecorder.record();
        ecgDataRecorder.setObserver(this);
    }

    @Override
    public void registerObserver(EcgObserver ecgObserver) {
        this.observer = ecgObserver;
    }

    @Override
    public void handle(EcgDtoImpl ecgDtoImpl) {
        if(observer!=null){
            observer.handle(ecgDtoImpl);
        }
    }
}
