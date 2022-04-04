package data;

import business.EKGObserver;

public interface EkgDataRecorder {
    void record();
    void setObserver(EKGObserver observer);
}
