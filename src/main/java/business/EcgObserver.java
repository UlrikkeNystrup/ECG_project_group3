package business;

import data.dto.EcgDto;
import data.dto.EcgDtoImpl;

public interface EcgObserver {
    void handle(EcgDtoImpl ecgDtoImpl);
}
