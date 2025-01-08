package threads;

public class ThreadExample2 extends Thread {
    ThreadExample2(String threadName) {
        super(threadName);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Printing from : " + Thread.currentThread() + " value is : " + i);
        }
    }
}


class ThreadExample3 implements Runnable{
    Runnable target;

    public ThreadExample3(Runnable target) {
        this.target = target;
    }

    @Override
    public void run() {
        if(target != null){
            target.run();
        }
    }
}


class ThreadExample2Runner {
    public static void main(String[] args) {
        System.out.println("Main thread starts");
        Thread t2 = new ThreadExample2("Thread1");
       // t2.setDaemon(true);
        t2.start();
        System.out.println("Main thread ends");

        Thread tt = new Thread(() -> {
            System.out.println("Target is not null");
        });

        tt.start();
    }
}
