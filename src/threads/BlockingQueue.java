package threads;

import java.util.LinkedList;
import java.util.Queue;

public class BlockingQueue {
    int capacity;
    final Queue<Integer> queue ;

    public BlockingQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new LinkedList<>();
    }

    public boolean add(int ele){
        synchronized (queue){
            while (queue.size() == capacity) {
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            queue.add(ele);
            queue.notifyAll();
            return true;
        }
    }

    public int remove(){
        synchronized (queue){
            while (queue.isEmpty()){
                try {
                    queue.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            int ele =   queue.poll();
            queue.notifyAll();
            return ele;
        }
    }
}
