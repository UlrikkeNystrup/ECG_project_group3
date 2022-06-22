//@author group 2: Ulrikke, Eva, Juliane, Simone og Mikael
package business;

import data.dto.EcgDto;
import data.dto.EcgDtoImpl;

public interface EcgObserver {
    void update(EcgDtoImpl ecgDtoImpl);  //Handle//svarer til en update() metode, som observer klasser har?

}
