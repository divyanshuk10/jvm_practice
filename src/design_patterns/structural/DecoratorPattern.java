package design_patterns.structural;

public class DecoratorPattern {
    public static void main(String[] args) {
        ///  creating simple pizza
        PizzaComponent pizza = new DominosPizzaComponent();
        System.out.println(pizza);

        ///  Putting onion toppings to pizza
        PizzaComponent onionPizza = new OnionToppingsDecorator(pizza);
        System.out.println(onionPizza.pizzaName());
        System.out.println(onionPizza.cost());

        ///  Putting mushroom toppings to onion pizza
        PizzaComponent mushroomPizza = new MushroomToppingsDecorator(onionPizza);
        System.out.println(mushroomPizza.pizzaName());
        System.out.println(mushroomPizza.cost());
    }
}

abstract class PizzaComponent {
    abstract int cost();

    abstract String pizzaName();
}

abstract class PizzaComponentDecorator extends PizzaComponent {
    @Override
    int cost() {
        return 0;
    }

    @Override
    String pizzaName() {
        return "";
    }
}

class DominosPizzaComponent extends PizzaComponent {
    int cost = 100;
    String pizzaName = "Farmhouse";

    @Override
    public String toString() {
        return "DominosPizzaComponent{" +
                "cost=" + cost +
                ", pizzaName='" + pizzaName + '\'' +
                '}';
    }

    @Override
    int cost() {
        return cost;
    }

    @Override
    String pizzaName() {
        return pizzaName;
    }

}

class OnionToppingsDecorator extends PizzaComponentDecorator {
    private final PizzaComponent pizzaComponent;

    public OnionToppingsDecorator(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent;
    }

    @Override
    int cost() {
        return this.pizzaComponent.cost() + 10;
    }

    @Override
    String pizzaName() {
        return this.pizzaComponent.pizzaName().concat(" ").concat("Onion");
    }
}

class MushroomToppingsDecorator extends PizzaComponentDecorator {
    private final PizzaComponent pizzaComponent;

    public MushroomToppingsDecorator(PizzaComponent pizzaComponent) {
        this.pizzaComponent = pizzaComponent;
    }

    @Override
    int cost() {
        return this.pizzaComponent.cost() + 20;
    }

    @Override
    String pizzaName() {
        return this.pizzaComponent.pizzaName().concat(" ").concat(" Mushroom");
    }
}