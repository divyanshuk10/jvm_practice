package design_patterns.behaviour;


public class StrategyDesignPattern {
    public static void main(String[] args) {
        StrategyDesignPatternExecutor strategyDesignPatternExecutorType1 = new StrategyDesignPatternExecutor(new IProperty1Type1Impl(), new IProperty2Type1Impl());
        StrategyDesignPatternExecutor strategyDesignPatternExecutorType2 = new StrategyDesignPatternExecutor(new IProperty1Type2Impl(), new IProperty2Type2Impl());
        StrategyDesignPatternExecutor strategyDesignPatternExecutorType12 = new StrategyDesignPatternExecutor(new IProperty1Type1Impl(), new IProperty2Type2Impl());
        StrategyDesignPatternExecutor strategyDesignPatternExecutorType22 = new StrategyDesignPatternExecutor(new IProperty1Type2Impl(), new IProperty2Type2Impl());
        StrategyDesignPatternExecutor strategyDesignPatternExecutorType21 = new StrategyDesignPatternExecutor(new IProperty1Type2Impl(), new IProperty2Type1Impl());

        strategyDesignPatternExecutorType1.executeProperty1();
        strategyDesignPatternExecutorType1.executeProperty2();

        strategyDesignPatternExecutorType2.executeProperty1();
        strategyDesignPatternExecutorType2.executeProperty2();

        strategyDesignPatternExecutorType12.executeProperty1();
        strategyDesignPatternExecutorType12.executeProperty2();

        strategyDesignPatternExecutorType21.executeProperty1();
        strategyDesignPatternExecutorType21.executeProperty2();

        strategyDesignPatternExecutorType22.executeProperty1();
        strategyDesignPatternExecutorType22.executeProperty2();


    }
}


class StrategyDesignPatternExecutor {
    final private IProperty1 property1;
    final private IProperty2 property2;

    public StrategyDesignPatternExecutor(IProperty1 property1, IProperty2 property2) {
        this.property1 = property1;
        this.property2 = property2;
    }

    void executeProperty1() {
        this.property1.runProperty1();
    }

    void executeProperty2() {
        this.property2.runProperty2();
    }
}

interface IProperty1 {
    void runProperty1();
}

interface IProperty2 {
    void runProperty2();
}

class IProperty1Type1Impl implements IProperty1 {

    @Override
    public void runProperty1() {
        System.out.println("TYPE 1 of : IProperty1");
    }
}

class IProperty1Type2Impl implements IProperty1 {

    @Override
    public void runProperty1() {
        System.out.println("TYPE 2 of : IProperty1");
    }
}

class IProperty2Type1Impl implements IProperty2 {

    @Override
    public void runProperty2() {
        System.out.println("TYPE 1 of : IProperty2");
    }
}

class IProperty2Type2Impl implements IProperty2 {

    @Override
    public void runProperty2() {
        System.out.println("TYPE 2 of : IProperty2");
    }
}

