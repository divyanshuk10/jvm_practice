package design_patterns.behaviour;

import java.util.ArrayList;
import java.util.List;

public class ObservablePattern {

    public static void main(String[] args) {
        ObservableImpl observable = new ObservableImpl();
        ObserverImpl1 observerImpl1 = new ObserverImpl1(observable);
        ObserverImpl2 observerImpl2 = new ObserverImpl2(observable);

        observable.notifyObs();
        observable.remove(observerImpl1);
        observable.notifyObs();
        observable.remove(observerImpl2);
        observable.notifyObs();
    }
}

interface IObserver {
    void update();
}

interface IObservable {
    void add(IObserver observer);

    void remove(IObserver observer);

    void notifyObs();
}

class ObserverImpl1 implements IObserver {
    private final ObservableImpl observable;

    public ObserverImpl1(ObservableImpl observable) {
        this.observable = observable;
        observable.add(this);
    }

    @Override
    public void update() {
       observable.getTemperatureStationCount();
    }
}

class ObserverImpl2 implements IObserver {
    private final ObservableImpl observable;

    public ObserverImpl2(ObservableImpl observable) {
        this.observable = observable;
        observable.add(this);
    }

    @Override
    public void update() {
        observable.getTemperatureStationCount();
    }
}

class ObservableImpl implements IObservable {
    final List<IObserver> observers;

    public ObservableImpl() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void add(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void remove(IObserver observer) {
        observers.remove(observer);
    }

    public int getTemperatureStationCount() {
        return observers.size();
    }

    @Override
    public void notifyObs() {
        while (true) {
            observers.forEach(IObserver::update);
            System.out.println("Number of subscribed stations are : " + getTemperatureStationCount());
            try {
                Thread.sleep(2000);
                break;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}