package threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

class TaskSchedulerRunner {

    public static void main(String[] args) {
        TaskScheduler scheduler = new TaskScheduler(Runtime.getRuntime().availableProcessors());
        scheduler.addTask(new Task("New task 1"));
        scheduler.addTask(new Task("New task 2"));
        scheduler.addTask(new Task("New task 3"));
        scheduler.start();
        scheduler.addTask(new Task("New task 4"));
        scheduler.addTask(new Task("New task 5"));
        scheduler.addTask(new Task("New task 6"));
        scheduler.addTask(new Task("New task 7"));
        scheduler.addTask(new Task("New task 8"));
        scheduler.addTask(new Task("New task 9"));
        scheduler.addTask(new Task("New task 10"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));
        scheduler.addTask(new Task("New task 11"));

        scheduler.shutdown();
    }

}

interface ITaskScheduler {
    void addTask(Task task);

    void start();

    void shutdown();
}


class TaskScheduler implements ITaskScheduler {
    private int threadCounts;
    private List<Task> tasksList;
    private ExecutorService executor;
    private ReentrantLock lock;

    public TaskScheduler(int threadCounts) {
        this.threadCounts = threadCounts;
        this.tasksList = new ArrayList<>();
        executor = Executors.newFixedThreadPool(threadCounts);
        lock = new ReentrantLock(false);
    }

    @Override
    public void addTask(Task task) {
        tasksList.add(task);
    }

    @Override
    public void start() {
        for (int i = 0; i < threadCounts; i++) {
            executor.execute(() -> {
                while (true) {
                    lock.lock();
                    try {
                        if (!tasksList.isEmpty()) {
                            Task t = tasksList.remove(tasksList.size() - 1);
                            Thread.sleep(100);
                            System.out.println("Executing task : " + t.getTaskName() + " on : "+ Thread.currentThread().getName());
                        } else {
                            break;
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    } finally {
                        lock.unlock();
                    }
                }
            });
        }
    }

    @Override
    public void shutdown() {
        executor.shutdown();
    }
}

class Task {
    private final String taskName;

    public Task(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskName() {
        return taskName;
    }
}