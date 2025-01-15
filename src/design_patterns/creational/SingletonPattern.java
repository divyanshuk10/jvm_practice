package design_patterns.creational;

public class SingletonPattern {

    private static volatile SingletonPattern INSTANCE = null;

    private SingletonPattern() {
        ///  This will be only called once only for the first time creation
        System.out.println("New Instance created");
    }

    public static SingletonPattern getInstance() {
        ///  Using double locking mechanism to prevent multithreading runtime exceptions
        if (INSTANCE == null) {
            synchronized (SingletonPattern.class) {
                if (INSTANCE == null) {
                    INSTANCE = new SingletonPattern();
                }
            }
        }
        return INSTANCE;
    }
}

class SingletonPatternRunner {
    public static void main(String[] args) {
        SingletonPattern singletonObj1 = SingletonPattern.getInstance();
        SingletonPattern singletonObj2 = SingletonPattern.getInstance();

        System.out.println(singletonObj2 == singletonObj1);
    }
}
