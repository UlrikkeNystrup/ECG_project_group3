package data;

import business.EcgObserver;
//subjekt, interface
public interface EcgDataRecorder {
    void record(); //notify
    void setObserver(EcgObserver observer);
}
