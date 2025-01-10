package collection_fw;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LinkedListPractice {
    public static void main(String[] args) {
        /// LinkedList can be implemented using either list or a queue.
        Queue<Integer> queue = new LinkedList<>();
        // offer adds an element to the LinkedList without throwing an exception
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        queue.offer(4);

        // add adds an element to the LinkedList can throw an exception if not added
        queue.add(5);
        queue.add(6);
        queue.add(7);

        System.out.println(queue);
        // removes the top most element and can return null if the linked list is empty
        System.out.println("Polling : " + queue.poll());

        // removes the top most element and can throw exception if linked list is empty
        System.out.println("Removing : " + queue.remove());

        System.out.println(queue);

        // returns the head of the linked list and returns null if empty
        System.out.println("Peeking : " + queue.peek());

        // returns the head of the linked list and throws exception if empty
        System.out.println("Element : " + queue.element());

        /// LinkedList can be implemented using either list or a queue.
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        list.remove(1);
        list.remove(1);
        list.remove(0);
        System.out.println(list);
    }
}
