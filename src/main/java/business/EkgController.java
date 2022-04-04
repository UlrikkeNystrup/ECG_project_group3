package business;
import gui.EkgguiController;

public interface EkgController {
    void startrecording();
    void registerObserver(EKGObserver ekgObserver);
}