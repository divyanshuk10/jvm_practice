package collection_fw;

import java.util.ArrayDeque;

public class ArrayDequePractice {
    public static void main(String[] args) {
        ///  Used in inserting or removing elements from both sides
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
        arrayDeque.offerFirst(1);
        arrayDeque.offerLast(2);
        arrayDeque.offer(3);
        arrayDeque.offer(4);
        arrayDeque.offer(5);
        arrayDeque.offer(6);
        arrayDeque.offer(7);
        System.out.println(arrayDeque);

        System.out.println("Peek :" + arrayDeque.peek());
        System.out.println("Peek First :" + arrayDeque.peekFirst());
        System.out.println("Peek Last :" + arrayDeque.peekLast());
        System.out.println("Pool  :" + arrayDeque.poll());
        System.out.println("Pool First :" + arrayDeque.pollFirst());
        System.out.println("Pool Last :" + arrayDeque.pollLast());

        System.out.println(arrayDeque);
    }
}
