package threads;

public class ThreadSynchronization extends Thread {
    StringBuffer stringBuffer;
    StringBuilder stringBuilder;
    int low;
    int high;

    ThreadSynchronization(StringBuilder sb, StringBuffer sbf, String threadName, int low, int high) {
        super(threadName);
        stringBuffer = sbf;
        stringBuilder = sb;
        this.low = low;
        this.high = high;
    }

    @Override
    public void run() {
        for (int i = low; i <= high; i++) {
            // stringBuilder.append(i).append(" ");
            stringBuffer.append(i).append(" ");
            //System.out.println(stringBuffer.toString() + " " + "stringBuffer " + Thread.currentThread().getName());
            System.out.println(stringBuilder.toString().length() + " " + " stringBuilder" + Thread.currentThread().getName());
        }
    }

}

class ThreadSynchronizationRunner {
    public static void main(String[] args) {
        StringBuffer sBuilder = new StringBuffer();
        // StringBuilder sBuilder = new StringBuilder();

        Thread t1 = new Thread(() -> {
            try {
                for(int i = 0; i<sBuilder.length() ;i++)
                    sBuilder.append("A");
                Thread.sleep(1000);
                System.out.println(sBuilder.toString().length());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                for(int i = 0; i<sBuilder.length() ;i++)
                 sBuilder.deleteCharAt(sBuilder.length() - 1);
                Thread.sleep(1000);
                System.out.println(sBuilder.toString().length());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        //Thread t3 = new ThreadSynchronization(sBuilder, sBuffer, "T3", 85, 90);

        t1.start();
        t2.start();
        // t3.start();
    }
}
