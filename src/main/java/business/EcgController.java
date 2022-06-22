//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package business;
//vores Observable/subject interface?

public interface EcgController {
    void startRecording(String text); //ikke noget med observer pattern
    void registerObserver(EcgObserver ecgObserver);
}