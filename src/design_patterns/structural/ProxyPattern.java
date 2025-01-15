package design_patterns.structural;

public class ProxyPattern {

    public static void main(String[] args) {
        HeavyResourceObjectLazyInitProxy objectLazyInitProxy = new HeavyResourceObjectLazyInitProxy("Lazy Calculation in progress.... ");
        objectLazyInitProxy.heavyCalculation();
    }
}


class HeavyResourceObjectLazyInitProxy implements IHeavyResourceObject {
    private HeavyResourceObject heavyResourceObject = null;
    private final String data;

    public HeavyResourceObjectLazyInitProxy(String data) {
        this.data = data;
    }

    @Override
    public void heavyCalculation() {
        if (heavyResourceObject == null) {
            heavyResourceObject = new HeavyResourceObject(data);
        }
        heavyResourceObject.heavyCalculation();
    }
}


interface IHeavyResourceObject {
    void heavyCalculation();
}


class HeavyResourceObject implements IHeavyResourceObject {
    private final String data;

    public HeavyResourceObject(String data) {
        this.data = data;
    }

    @Override
    public void heavyCalculation() {
        System.out.println(data);
    }
}


