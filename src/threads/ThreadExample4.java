package threads;

public class ThreadExample4 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            System.out.println("Thread Execution completed");
        });

        t1.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Main exited");
    }
}
