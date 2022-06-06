package business;

public interface EcgController {
    void startRecording(String text); // burde hedde notify
    void registerObserver(EcgObserver ecgObserver);
}