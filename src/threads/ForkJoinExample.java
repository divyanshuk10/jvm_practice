package threads;

import java.util.stream.IntStream;

public class ForkJoinExample {
    public static void main(String[] args) {
        System.out.println(Runtime.getRuntime().availableProcessors());
        int total = IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11).parallel().map(ForkJoinExample::doubleIt).sum();

    }

    public static int doubleIt(int n) {
        try {
            Thread.sleep(100);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return n * 2;
    }
}