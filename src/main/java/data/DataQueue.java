package data;

import data.dto.EcgDtoImpl;

import java.util.LinkedList;
import java.util.Queue;

public class DataQueue { //kø klassen som 'deles' af producer og consumer klassen
    private final Queue<EcgDtoImpl> queue = new LinkedList<>();
    private final Object EMPTY_QUEUE = new Object();
    private final int maxSize;

    DataQueue(int maxSize) {
        this.maxSize = maxSize;
    }
}
