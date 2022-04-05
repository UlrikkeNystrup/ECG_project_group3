package data;

import business.EcgObserver;

public interface EcgDataRecorder {
    void record();
    void setObserver(EcgObserver observer);
}
