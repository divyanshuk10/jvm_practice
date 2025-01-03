package lambda.functional;

import java.lang.FunctionalInterface;

public class LambdaRunnableExpression {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyThread());

        Runnable runnable = () -> {
            try {
                System.out.println("Running t2");
                System.out.println("finished t2");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };

        Thread t2 = new Thread(runnable);


        t1.start();
        t2.start();
    }
}

class MyThread implements Runnable {

    @Override
    public void run() {
        try {
            System.out.println("running t1");
            System.out.println("finished t1");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

@FunctionalInterface
interface Myinterface{
    void get();
}