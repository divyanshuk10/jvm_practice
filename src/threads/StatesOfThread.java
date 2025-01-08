package threads;

public class StatesOfThread {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                Thread.sleep(1);
                for (int i = 0; i < 5; i++) {

                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        });

        t1.start();

        while (true) {
            Thread.State state = t1.getState();
            System.out.println(state);
            if(state == Thread.State.TERMINATED) break;
        }
    }
}
