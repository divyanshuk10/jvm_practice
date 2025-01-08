package threads;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class Stack {
    private int[] arr;
    private int capacity;
    int stackTop = -1;
    private final ReentrantLock lock = new ReentrantLock();


    public Stack(int cap) {
        capacity = cap;
        arr = new int[capacity];
    }

    public boolean push(int element) {
        synchronized (lock) {
            System.out.println(Thread.currentThread() + " " + lock.isHeldByCurrentThread() + " " + lock.getHoldCount());
            if (isFull()) return false;
            stackTop++;
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                throw new RuntimeException("Thread issue - push");
            }
            arr[stackTop] = element;
        }
        return true;
    }

    public int pop() {
        synchronized (lock) {
            System.out.println(Thread.currentThread() + " " + lock.isHeldByCurrentThread() + " " + lock.getHoldCount());
            if (isEmpty()) return Integer.MIN_VALUE;
            int obj = arr[stackTop];
            arr[stackTop] = Integer.MIN_VALUE;
            stackTop--;
            try {
                Thread.sleep(100);
                return obj;
            } catch (Exception e) {
                throw new RuntimeException("Thread issue");
            }
        }
    }

    public boolean isEmpty() {
        return stackTop < 0;
    }

    public boolean isFull() {
        return stackTop == arr.length - 1;
    }

    public int capacity() {
        return arr.length;
    }
}

class StackRunner {
    public static void main(String[] args) {
        Stack st = new Stack(5);

        for (int i = 0; i < 10; i++) {
            int finalI = i;
            new Thread(() -> {
                st.push(finalI);
            }, "T1 - " + i).start();
            new Thread(() -> {
                int x = st.pop();
                System.out.println(x);
            }, "T2 - " + i).start();
        }
    }
}
