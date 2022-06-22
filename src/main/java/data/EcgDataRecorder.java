//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package data;

import business.EcgObserver;

public interface EcgDataRecorder {
    void record(); //svarer til notify()
    void setObserver(EcgObserver observer); //svarer til registerObserver()
}
