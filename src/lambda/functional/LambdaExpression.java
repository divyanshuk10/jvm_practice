package lambda.functional;

public class LambdaExpression {

    public static void main(String[] args) {

        Shape rectangle = () -> System.out.println("Draw Rectangle");
        Shape square = () -> System.out.println("Draw Square");
        Shape circle = () -> System.out.println("Draw Circle");

        printShape(() -> System.out.println("Draw Rectangle"));
        printShape(() -> System.out.println("Draw Square"));
        printShape(() -> System.out.println("Draw Circle"));
    }

    private static void printShape(Shape shape) {
        shape.draw();
    }

}

interface Shape {
    void draw();
}
