package business;

import data.DummyEcgRecorder;
import data.dao.EcgDaoImpl;
import data.EcgDataRecorder;
import data.dto.EcgDtoImpl;

public class EcgControllerImpl implements EcgController, EcgObserver {
    private static String CPR;
    private EcgDataRecorder ecgDataRecorder = new DummyEcgRecorder();
    private EcgObserver observer;
    private EcgDaoImpl ecgDaoImpl = new EcgDaoImpl();

    @Override
    public void startRecording(String text) {
        this.CPR = text;
        ecgDataRecorder.record();
        ecgDataRecorder.setObserver(this);
    }

    @Override
    public void registerObserver(EcgObserver ecgObserver) {
        this.observer = ecgObserver;
    }

    @Override
    public void notify(EcgDtoImpl ecgDtoImpl) {
        if(observer!=null){
            observer.notify(ecgDtoImpl);
        }
        ecgDtoImpl.setPatientId(CPR); //indsætter data for patientId
        if (CPR != null && !CPR.isEmpty()) { //kun hvis der skrives et CPR i tekstfeltet skal data gemmes
            ecgDaoImpl.save(ecgDtoImpl);
        }
    }
}
