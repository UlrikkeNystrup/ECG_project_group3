package business;
//vores Observable/subject interface?

public interface EcgController {
    void startRecording(String text); //ikke noget med observer pattern
    void registerObserver(EcgObserver ecgObserver);
}