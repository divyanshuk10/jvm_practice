package design_patterns.creational;

public class FactoryPattern {

    public static void main(String[] args) {
        IEcommerceProductCreator amazonProductCreator = new AmazonProductCreator();
        IEcommerceProductCreator flipkartProductCreator = new FlipkartProductCreator();

        IEcommerce ecom1 = amazonProductCreator.createFactory();
        IEcommerce ecom2 = flipkartProductCreator.createFactory();

        ecom1.productName();
        ecom2.productName();
    }
}


interface IEcommerce {
    void productName();
}

class Flipkart implements IEcommerce {

    @Override
    public void productName() {
        System.out.println("Flipkart : Products");
    }
}

class Amazon implements IEcommerce {

    @Override
    public void productName() {
        System.out.println("Amazon : Products");
    }
}

interface IEcommerceProductCreator {

    IEcommerce createFactory();
}

class FlipkartProductCreator implements IEcommerceProductCreator {

    @Override
    public IEcommerce createFactory() {
        return new Flipkart();
    }
}

class AmazonProductCreator implements IEcommerceProductCreator {

    @Override
    public IEcommerce createFactory() {
        return new Amazon();
    }
}

