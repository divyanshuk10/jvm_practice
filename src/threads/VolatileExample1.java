package threads;

public class VolatileExample1 {
   static volatile int counter = 0;


    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            counter += 1;
        });

        Thread t2 = new Thread(() -> {
            counter--;
        });

    }
}