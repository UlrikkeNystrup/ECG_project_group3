package business;

import data.DummyEcgRecorder;
import data.dao.EcgDaoImpl;
import data.dto.EcgDto;
import data.EcgDataRecorder;
import data.dto.EcgDtoImpl;
import javafx.scene.control.TextField;

public class EcgControllerImpl implements EcgController, EcgObserver {
    private EcgDataRecorder ecgDataRecorder = new DummyEcgRecorder();
    private EcgObserver observer;
    private EcgDaoImpl ecgDaoImpl = new EcgDaoImpl();

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
        ecgDtoImpl.setId("Johny");
        ecgDaoImpl.save(ecgDtoImpl);
    }
}
