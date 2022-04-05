package business;

import data.EcgData;

public interface EcgObserver {
    void handle(EcgData ecgData);
}
