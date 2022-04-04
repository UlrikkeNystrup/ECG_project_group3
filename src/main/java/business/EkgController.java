package business;
import gui.EkgguiController;

public interface EkgController {
    void startRecording();
    void registerObserver(EKGObserver ekgObserver);
}