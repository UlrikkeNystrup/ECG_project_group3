package data;

import business.EcgObserver;
//subject interface
public interface EcgDataRecorder {
    void record(); //svarer til notify()
    void setObserver(EcgObserver observer); //svarer til registerObserver()
}
