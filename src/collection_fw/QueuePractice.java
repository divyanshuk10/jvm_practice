package collection_fw;

import java.util.Comparator;
import java.util.PriorityQueue;

public class QueuePractice {

    public static void main(String[] args) {
        /// Priority queue uses heap under the hood
        ///  by default the minimum element has the highest priority so it will be on top always (Min Heap)
        /// we can customize the priority of the queue by passing a comparator to the constructor of PriorityQueue while initialising it
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // here (Max heap) due to reverse order
        pq.offer(21);
        pq.offer(13);
        pq.offer(11);
        pq.offer(43);

        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.peek());
        System.out.println(pq);
    }

}
