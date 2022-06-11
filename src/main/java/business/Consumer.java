package business;

import data.dto.EcgDto;

import java.sql.SQLOutput;
import java.util.LinkedList;

public class Consumer implements Runnable {

    private final LinkedList<EcgDto> queue;
    private  Object noItem;

    public Consumer(LinkedList<EcgDto> queue, Object emptyLock ) {
        this.queue = queue;
        this.noItem = emptyLock;
    }


    @Override
    public void run() {
        while (true){
            synchronized (queue){
                if (!queue.isEmpty()){
                    LinkedList<EcgDto> saveList = new LinkedList<EcgDto>();
                    saveList.addAll(queue);
                    queue.clear();
                    System.out.println("Saving some data! : " + saveList.toString());
                    //TODO: Save the data!
                }
            }
            try {
                //simulation af et langsomt gemme forsøg
                Thread.sleep(1600);
            }  catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Parker siger: Removed som snazzy data!");
        }
    }
}
