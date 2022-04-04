package business;

import data.EKGData;

public interface EKGObserver {
    void handle(EKGData ekgData);
}
