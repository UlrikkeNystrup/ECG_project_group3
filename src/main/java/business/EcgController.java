package business;

public interface EcgController {
    void startRecording();
    void registerObserver(EcgObserver ecgObserver);
}