package threads;

import java.util.concurrent.*;

public class ThreadExample1 implements Callable<Integer> {
    private final int threadNumber;

    ThreadExample1(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public Integer call() throws Exception {
        int result = 0;
        for (int i = 1; i <= 5; i++) {
            result += i;
            Thread.sleep(1000);
        }
        System.out.println(result + " Thread number : " + threadNumber);
        return result;
    }

}

class ThreadExecution {
    public static void main(String[] args) {
        ExecutorService tpe = Executors.newFixedThreadPool(3);
        ThreadExample1 ex1 = new ThreadExample1(1);
        Future<Integer> res =  tpe.submit(ex1);
        try {
            int a = res.get();
            System.out.println(a);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        tpe.shutdown();
        System.out.println("Hello world");
//        for (int i = 1; i <= 5; i++) {
//            ThreadExample1 ex1 = new ThreadExample1(i);
//            try {
//                int ans = ex1.call();
//                System.out.println(ans);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }

    }
}
