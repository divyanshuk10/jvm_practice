package lambda.functional;

import java.util.function.Consumer;

public class LambdaConsumerExpression {
    public static void main(String[] args) {
        Consumer<String> lambdaConsumer = (String s) -> {
            System.out.println(s);
        };

        lambdaConsumer.accept("Divyanshu");
    }
}


