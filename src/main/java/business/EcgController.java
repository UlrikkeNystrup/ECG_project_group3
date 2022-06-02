package business;
//vores Observable/subject interface?

public interface EcgController {
    void startRecording(String text); //svarer til notify() metode, som subjekt interface plejer at have
    void registerObserver(EcgObserver ecgObserver);
}