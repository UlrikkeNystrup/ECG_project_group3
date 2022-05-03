package business;

public interface EcgController {
    void startRecording(String text);
    void registerObserver(EcgObserver ecgObserver);
}